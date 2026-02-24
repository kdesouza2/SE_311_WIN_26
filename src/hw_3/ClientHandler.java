package src.hw_3;

import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {

    private final SocketConnection connection;
    private final CommandProcessor processor;

    public ClientHandler(Socket clientSocket, LineStorage originalLines) {
        this.connection = new SocketConnection(clientSocket);
        this.processor = new CommandProcessor(originalLines);
    }

    @Override
    public void run() {
        try {
            // Receive command from client
            String commandLine = connection.receiveCommand();
            System.out.println("Received command: " + commandLine);

            // Split into args
            String[] args = commandLine.split(" ");

            // Process command
            List<String> response = processor.processCommand(args);

            // Send response back
            connection.sendResults(response);

        } finally {
            // Always close connection
            connection.close();
            System.out.println("Client disconnected.");
        }
    }
}   
