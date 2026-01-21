public class CommandProcessor {
    protected LineStorage originalLines;

    public CommandProcessor(LineStorage input) {
        this.originalLines = input;
    }

    public String[] parseCommand(String command) {
		return command.split(" ");
	}

    public void processCommand(String command) {
		String[] parts = parseCommand(command);
		String commandType = parts[0].toLowerCase();
        Output output = new ConsoleOut();

    //     if (commandType.equals("kwic")) {
	// 		KWICProcessor kwicProcessor = new KWICProcessor(originalLines, command);
    //      List<String> result = kwicProcessor.execute();
    //      output.printOutput(result);
	// 	} else if (commandType.equals("search")) {
	// 		SearchProcessor searchProcessor = new DepositProcessor(originalLines, keyword);
    //      List<String> result = searchProcessor.execute();
    //      output.printOutput(result);
	// 	} else if (commandType.equals("index")) {
	// 		IndexProcessor indexProcessor = new IndexProcessor(originalLines, command);
    //      List<String> result = indexProcessor.execute();
    //      output.printOutput(result);
	// 	} else if (commandType.equals("quit")) {
	// 		QuitProcessor quitProcessor = new QuitProcessor(originalLines, command);
    //      output.printOutput("You have exited the program. Have a great day!");
    //     }
    }
    
}
