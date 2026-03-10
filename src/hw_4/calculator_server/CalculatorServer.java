package src.hw_4.calculator_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import src.hw_4.calculator_client.SocketConnection;

public class CalculatorServer {

    private int port;

    // Thread-safe list of all successfully calculated expressions
    private final List<String> successfulEquations = Collections.synchronizedList(new ArrayList<>());

    public CalculatorServer(int port) {
        this.port = port;
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
            e.printStackTrace();
        }
    }

    private void handleClient(SocketConnection connection) {

        try {

            BufferedReader in = connection.getReader();

            String expression;
            while ((expression = in.readLine()) != null) {

                // Expression is assumed to be a successful calculation, e.g., "3+5*8=43"
                if (!expression.isBlank()) {

                    // Store the expression
                    successfulEquations.add(expression);

                    // Display total and list
                    displayStatus();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

}
