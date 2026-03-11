package src.hw_4.calculator_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.hw_4.calculator_client.SocketConnection;

public class CalculatorServer {

    private final int port;

    // Thread-safe list of all successfully calculated expressions
    private final List<String> successfulEquations = Collections.synchronizedList(new ArrayList<>());

    public CalculatorServer(int port) {
        this.port = port;

        // Shutdown hook: runs when program exits
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            writeSummary();
        }));
    }

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Calculator Server running on port " + port);

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                SocketConnection connection = new SocketConnection(clientSocket);

                // Handle each client in a separate thread
                new Thread(() -> handleClient(connection)).start();
            }

        } catch (Exception e) {
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
            System.out.println("All equations:");

            for (String eq : successfulEquations) {
                System.out.println("  " + eq);
            }

            System.out.println("-----------------------------");
        }
    }

    private void writeSummary() {

        String filePath = "src/hw_4/summary.txt";

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
}
