package src.hw_4.calculator_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.hw_4.calculator_client.SocketConnection;

public class CalculatorServer {

    private final int port;
    private volatile boolean running = true;
    private ServerSocket serverSocket;

    private final List<String> successfulEquations = Collections.synchronizedList(new ArrayList<>());

    public CalculatorServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Calculator Server running on port " + port);

            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                    SocketConnection connection = new SocketConnection(clientSocket);
                    new Thread(() -> handleClient(connection)).start();

                } catch (IOException e) {
                    if (running) {
                    }
                }
            }

        } catch (IOException e) {
        } finally {
        }
    }

    private void handleClient(SocketConnection connection) {
        try {
            BufferedReader in = connection.getReader();
            String expression;

            while ((expression = in.readLine()) != null) {
                if (!expression.isBlank()) {
                    successfulEquations.add(expression);
                    displayStatus();
                }
            }
        } catch (IOException e) {
        }
    }

    private void displayStatus() {
        synchronized (successfulEquations) {
            System.out.println("Total successful calculations: " + successfulEquations.size());
            for (String eq : successfulEquations) {
                System.out.println("  " + eq);
            }
            System.out.println("-----------------------------");
        }
    }

    public void writeSummary() {
        if (successfulEquations.isEmpty()) {
            return;
        }

        String filePath = "summary.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Calculator Server Summary\n");
            writer.write("=========================\n");

            synchronized (successfulEquations) {
                writer.write("Total successful calculations: " + successfulEquations.size() + "\n\n");
                writer.write("All equations:\n");
                for (String eq : successfulEquations) {
                    writer.write(eq);
                    writer.newLine();
                }
            }

            System.out.println("Summary written to " + filePath);

        } catch (IOException e) {
        }
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
        }
    }
}
