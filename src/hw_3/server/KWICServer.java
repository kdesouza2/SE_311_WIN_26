package src.hw_3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class KWICServer {

    private static final int PORT = 5000;
    private boolean running = true;

    // Server owns the line storage
    private final LineStorage originalLines;

    // Counters for logging
    private final AtomicInteger totalRequests = new AtomicInteger(0);
    private final AtomicInteger successfulRequests = new AtomicInteger(0);

    public KWICServer(LineStorage originalLines) {
        this.originalLines = originalLines;
    }

    public void startServer() {
        System.out.println("KWIC Server starting on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Pass LineStorage and counters to ClientHandler
                ClientHandler handler = new ClientHandler(clientSocket, originalLines, totalRequests, successfulRequests);

                new Thread(handler).start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    public void stopServer() {
        running = false;
        System.out.println("KWIC Server stopped.");
    }

    // Optionally: helper method to log counts
    public void printLog() {
        System.out.println("Total requests: " + totalRequests.get()
                + ", Successful requests: " + successfulRequests.get());
    }
}