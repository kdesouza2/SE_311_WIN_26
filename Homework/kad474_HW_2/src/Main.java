
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Main <input-file>");
            return;
        }

        String filename = args[0];

        // 1. Load configuration
        OptionReader.readOptions();

        // 2. Create objects from config
        Input input = (Input) OptionReader.getObjectFromKey("Input");
        Output output = (Output) OptionReader.getObjectFromKey("Output");

        // 3. Inject runtime data (filename)
        if (input instanceof TxtIn) {
            ((TxtIn) input).setFilename(filename);
        } else {
            ((CsvIn) input).setFilename(filename);
        }

        LineStorage storage = new LineStorage();
        CommandValidator commandValidator = new CommandValidator();

        // store original lines
        storage.setLines(input.readLines());

        CommandProcessor commandProcessor = new CommandProcessor(storage, output);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nKWIC System Ready to Process Commands:");
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
