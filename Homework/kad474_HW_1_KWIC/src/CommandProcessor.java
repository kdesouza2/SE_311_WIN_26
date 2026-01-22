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

    public boolean processCommand(String command) {
		String[] parts = parseCommand(command);
		String commandType = parts[0].toLowerCase();

        switch (commandType) {
            case "kwic" -> {
                KWICProcessor kwicProcessor = new KWICProcessor(originalLines, output);
                kwicProcessor.execute();
                return true;
            }
            case "search" -> {
                SearchProcessor searchProcessor = new SearchProcessor(originalLines, output, command);
                searchProcessor.execute();
                return true;
            }
            case "index" -> {
                IndexProcessor indexProcessor = new IndexProcessor(originalLines, output);
                indexProcessor.execute();
                return true;
            }
            default -> {
                QuitProcessor quitProcessor = new QuitProcessor(originalLines, output);
                quitProcessor.execute();
            }
        }

        return false;
    }
    
}
