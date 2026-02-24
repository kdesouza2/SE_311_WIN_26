package src.hw_3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Load configuration
        OptionReader.readOptions();

        // 2. Create objects from config
        Input input = (Input) OptionReader.getObjectFromKey(
                OptionReader.getString("Input"));

        Output output = (Output) OptionReader.getObjectFromKey(
                OptionReader.getString("Output"));

        // 3. Inject runtime data (filenames)
        switch (input) {
            case TxtIn txtIn -> txtIn.setFilename(
                    OptionReader.getString("InputFileName"));
            case CsvIn csvIn -> csvIn.setFilename(
                    OptionReader.getString("InputFileName"));
            default -> {
            }
        }

        if (output instanceof TxtOut txtOut) {
            txtOut.setFilename(
                    OptionReader.getString("OutputFileName"));
        }

        LineStorage storage = new LineStorage();
        storage.setLines(input.readLines());

        // 4. Validate command
        CommandValidator commandValidator = new CommandValidator();

        System.out.println("\nKWIC Client Sending Command:");

        if (args.length == 0 || !commandValidator.validateCommand(args[0])) {
            System.out.println("Invalid Command");
            return;
        }

        // 5. Send command to server
        KWICClient client = new KWICClient();
        KWICServer server = new KWICServer(storage);

        try {
            server.startServer();

            client.connect();   // open socket

            List<String> response = client.sendCommand(args);

            output.printOutput(response);

            client.disconnect();

        } catch (Exception e) {
            System.out.println("Server communication failed.");
        }
    }
}