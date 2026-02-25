package src.hw_3.server;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import src.hw_3.client.*;

public class Main {

    public static void main(String[] args) throws IOException {

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

        TxtOut log = (TxtOut) OptionReader.getObjectFromKey(OptionReader.getString("LogObj"));
        log.setFilename(OptionReader.getString("LogFileName"));

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

            // Start the server in a background thread
            KWICServer server = new KWICServer(storage);
            Thread serverThread = new Thread(server::startServer);
            serverThread.start();
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        
            // Create the client that will talk to the server
            KWICClient client = new KWICClient();
            client.connect();
        
            System.out.println("Type 'quit' to stop the server.\n");
        
            Scanner scanner = new Scanner(System.in);
        
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine().trim();

        
                if (line.equalsIgnoreCase("quit")) {
                    // Send quit to server
                    client.sendCommand(new String[]{"quit"});
        
                    // Stop server
                    server.stopServer();
    
                    break;
                }
        
                String[] commandArgs = line.split("\\s+");

                if (!validator.validateCommand(commandArgs[0])) {
                    System.out.println("Invalid Command");
                    continue;
                }
        
                // Send command to server
                client.sendCommand(commandArgs);
        
                output.printOutput(client.receiveResults());
                log.printOutput(server.getLog());
            }
        
            scanner.close();

        } else {

            // -----------------------------
            // 5. If mode = local → interactive CLI
            // -----------------------------
            System.out.println("Local mode. Type commands like:");
            System.out.println("keyword-search <keyword>");
            System.out.println("Type 'quit' to quit.\n");

            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.print("> ");
                String line = scanner.nextLine().trim();

                if (line.equalsIgnoreCase("quit")) {
                    System.out.println("Exiting program, goodbye!.");
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

            scanner.close();
        }
    }
}
