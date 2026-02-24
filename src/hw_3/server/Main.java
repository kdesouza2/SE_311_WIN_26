package src.hw_3.server;

import java.util.List;
import java.util.Scanner;
import src.hw_3.client.*;

public class Main {

    public static void main(String[] args) {

        // -----------------------------
        // 1. Validate launch arguments
        // -----------------------------
        if (args.length < 2) {
            System.out.println("Usage: java -jar hw3_server.jar config.properties <server|local>");
            return;
        }

        String mode = args[1].toLowerCase();

        if (!mode.equals("server") && !mode.equals("local")) {
            System.out.println("Second argument must be 'server' or 'local'");
            return;
        }

        // -----------------------------
        // 2. Load configuration
        // -----------------------------
        OptionReader.readOptions(args[0]);

        String typeOfInput = OptionReader.getString("Input");
        Input input = (Input) OptionReader.getObjectFromKey(typeOfInput);

        String typeOfOutput = OptionReader.getString("Output");
        Output output = (Output) OptionReader.getObjectFromKey(typeOfOutput);

        if (input instanceof TxtIn txtIn) {
            txtIn.setFilename(OptionReader.getString("InputFileName"));
        }

        if (input instanceof CsvIn csvIn) {
            csvIn.setFilename(OptionReader.getString("InputFileName"));
        }

        if (output instanceof TxtOut txtOut) {
            txtOut.setFilename(OptionReader.getString("OutputFileName"));
        }

        // -----------------------------
        // 3. Load data into storage
        // -----------------------------
        LineStorage storage = new LineStorage();
        storage.setLines(input.readLines());

        CommandValidator validator = new CommandValidator();

        // -----------------------------
        // 4. If mode = server → start server
        // -----------------------------
        if (mode.equals("server")) {
            KWICServer server = new KWICServer(storage);
            server.startServer();
            return;
        }

        // -----------------------------
        // 5. If mode = local → interactive CLI
        // -----------------------------
        System.out.println("Local mode. Type commands like:");
        System.out.println("keyword-search <keyword>");
        System.out.println("Type 'exit' to quit.\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye.");
                break;
            }

            String[] commandArgs = line.split("\\s+");

            if (!validator.validateCommand(commandArgs[0])) {
                System.out.println("Invalid Command");
                continue;
            }

            CommandProcessor processor = new CommandProcessor(storage);
            List<String> results = processor.processCommand(commandArgs);
            output.printOutput(results);
        }
    }
}
