package src.hw_4.calculator_client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnection implements CalculatorObserver {

    private String host;
    private int port;
    private Socket socket;  // For server-side constructor

    /* CLIENT CONSTRUCTOR */
    public SocketConnection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /* SERVER CONSTRUCTOR */
    public SocketConnection(Socket socket) {
        this.socket = socket;
        initializeStreams();
    }

    @Override
    public void update(String expression) {
        sendToServer(expression);
    }

    private void sendToServer(String expression) {

        // Client-side: open new socket to server
        if (socket == null) {
            try (Socket s = new Socket(host, port);
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
                out.println(expression);
            } catch (IOException e) {
                System.out.println("Error sending expression to server: " + e.getMessage());
            }
        } 
        // Server-side: write using existing socket
        else {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                out.println(expression);
            } catch (IOException e) {
                System.out.println("Error sending expression via server socket: " + e.getMessage());
            }
        }
    }

    // Optional server-side initialization for streams
    private void initializeStreams() {
        try {
            // Could add input/output streams if needed
            System.out.println("Server-side SocketConnection initialized for " + socket.getInetAddress());
        } catch (Exception e) {
            System.out.println("Error initializing server SocketConnection: " + e.getMessage());
        }
    }
}
