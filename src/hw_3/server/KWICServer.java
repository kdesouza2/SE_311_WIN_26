package src.hw_3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class KWICServer {

    private static final int PORT = 1234;
    private boolean running = true;

    private ServerSocket serverSocket;   

    private final LineStorage originalLines;
    private final AtomicInteger totalRequests = new AtomicInteger(0);
    private final AtomicInteger successfulRequests = new AtomicInteger(0);

    public KWICServer(LineStorage originalLines) {
        this.originalLines = originalLines;
    }

    public void startServer() {
        System.out.println("KWIC Server starting on port " + PORT + "...");

        try (ServerSocket ss = new ServerSocket(PORT)) {
            this.serverSocket = ss;   

            while (running) {
                try {
                    Socket clientSocket = ss.accept();
                    ClientHandler handler = new ClientHandler(clientSocket, originalLines, totalRequests, successfulRequests);
                    new Thread(handler).start();
                } catch (IOException e) {
                    if (!running) break;   
                }
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }

        System.out.println("KWIC Server stopped.");
    }

    public void stopServer() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();   
            }
        } catch (IOException e) {
            System.out.println("Error closing server: " + e.getMessage());
        }
    }

    public List<String> getLog() {
        List<String> log = new ArrayList<>();
        log.add("Total requests: " + totalRequests.get());
        log.add("Successful requests: " + successfulRequests.get());
        return log;
    }
}


