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

        if (commandType.equals("kwic")) {
			KWICProcessor kwicProcessor = new KWICProcessor(originalLines, output);
            kwicProcessor.execute();
            return true;
		} // else if (commandType.equals("search")) {
		// 	SearchProcessor searchProcessor = new SearchProcessor(originalLines, output, command);
        //  searchProcessor.execute();
        //  return true;
		// } else if (commandType.equals("index")) {
		// 	IndexProcessor indexProcessor = new IndexProcessor(originalLines, command);
        //  indexProcessor.execute();
        //  return true;
		// } else {
		// 	QuitProcessor quitProcessor = new QuitProcessor();
        //  quitProcessor.execute();
        // }

        return false;
    }
    
}
