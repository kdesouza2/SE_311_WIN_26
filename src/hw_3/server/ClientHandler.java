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
            while (true) {
                String commandLine = connection.receiveCommand();
                if (commandLine == null) break;              // client disconnected
                if (commandLine.equalsIgnoreCase("quit")) {  // client wants to stop
                    connection.sendResults(List.of("Goodbye."));
                    break;
                }

                String[] args = commandLine.split(" ");
                totalRequests.incrementAndGet();

                List<String> response = processor.processCommand(args);

                if (!response.isEmpty() && !response.get(0).toLowerCase().contains("not found")) {
                    successfulRequests.incrementAndGet();
                }

                connection.sendResults(response);  // sends results + END
            }
        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }

}