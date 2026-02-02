import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Usage: java Main <input-file>");
            return;
        }

        String filename = args[0];
        Input input = new TxtIn(filename);
        Output output = new ConsoleOut();
        LineStorage storage = new LineStorage();
        CommandValidator commandValidator = new CommandValidator();

        // store original lines
        storage.setLines(input.readLines());

        CommandProcessor commandProcessor = new CommandProcessor(storage, output);
        
        try (Scanner scanner = new Scanner(System.in)) {
            output.printOutputLine("\nKWIC System Ready to Process Commands:");
            while (true) {
                System.out.print("\n> ");
                String command = scanner.nextLine();
                
                if (!commandValidator.validateCommand(command)) {
                    System.out.println("Invalid Command");
                } else if (!commandProcessor.processCommand(command)) {
                    break;
                }
            }
        }

    }

}


