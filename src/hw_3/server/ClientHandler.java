package src.hw_3.server;

import java.net.Socket;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import src.hw_3.client.SocketConnection;

public class ClientHandler implements Runnable {

    private final SocketConnection connection;
    private final CommandProcessor processor;
    private final AtomicInteger totalRequests;
    private final AtomicInteger successfulRequests;

    public ClientHandler(Socket clientSocket, LineStorage originalLines, AtomicInteger totalRequests, AtomicInteger successfulRequests) {
        this.connection = new SocketConnection(clientSocket);
        this.processor = new CommandProcessor(originalLines);
        this.totalRequests = totalRequests;
        this.successfulRequests = successfulRequests;
    }

    @Override
    public void run() {
        try {
            // Receive command from client
            String commandLine = connection.receiveCommand();
            System.out.println("Received command: " + commandLine);

            // Split into args
            String[] args = commandLine.split(" ");

            // Increment total requests
            totalRequests.incrementAndGet();

            // Process command (returns List<String>)
            List<String> response = processor.processCommand(args);

            // Check if the search was successful (not empty or "not found")
            if (!response.isEmpty() && !response.get(0).toLowerCase().contains("not found")) {
                successfulRequests.incrementAndGet();
            }

            // Send results back to client
            connection.sendResults(response);

        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            // Always close connection
            connection.close();
            System.out.println("Client disconnected.");
        }
    }
}