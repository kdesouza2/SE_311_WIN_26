package src.hw_3;

public class CommandProcessor {
    protected LineStorage originalLines;
    protected Output output;

    public CommandProcessor(LineStorage input, Output output) {
        this.originalLines = input;
        this.output = output;
    }

    public String[] parseCommand(String command) {
		return command.split(" ");
	}

    public void processCommand(String[] command) {

		String commandType = command[0].toLowerCase();

        switch (commandType) {
            case "kwic-processing" -> {
                KWICProcessor kwicProcessor = new KWICProcessor(originalLines, output);
                kwicProcessor.execute();
            }
            case "keyword-search" -> {
                if (command[1] == null) {
                    System.out.println("Invalid usage: keyword-search <keyword>");
                } else {
                    SearchProcessor searchProcessor = new SearchProcessor(originalLines, output, command[1]);
                    searchProcessor.execute();
                }
            }
            case "index-generation" -> {
                IndexProcessor indexProcessor = new IndexProcessor(originalLines, output);
                indexProcessor.execute();
            }

        }

    }
    
}
