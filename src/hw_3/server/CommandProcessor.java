package src.hw_3.server;

import java.util.List;

public class CommandProcessor {
    protected LineStorage originalLines;

    // for server mode
    public CommandProcessor(LineStorage input) {
        this.originalLines = input;
    }

    public List<String> processCommand(String[] command) {

        String commandType = command[0].toLowerCase();

        switch (commandType) {

            case "kwic-processing" -> {
                KWICProcessor kwicProcessor = new KWICProcessor(originalLines);

                return kwicProcessor.execute();
            }

            case "keyword-search" -> {

                if (command.length < 2) {
                    return List.of("Invalid usage: keyword-search <keyword>");
                }

                SearchProcessor searchProcessor = new SearchProcessor(originalLines, command[1]);

                return searchProcessor.execute();
            }

            case "index-generation" -> {
                IndexProcessor indexProcessor = new IndexProcessor(originalLines);

                return indexProcessor.execute();
            }
        }

        return List.of("Unknown command");
    }
}