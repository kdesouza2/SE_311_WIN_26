package src.hw_4.calculator_client;

import java.io.*;
import java.net.Socket;

public class SocketConnection implements CalculatorObserver {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    // Client-side constructor
    public SocketConnection(String host, int port) {
        try {
            socket = new Socket(host, port);
            initializeStreams();
        } catch (IOException e) {
        }
    }

    // Server-side constructor
    public SocketConnection(Socket socket) {
        this.socket = socket;
        initializeStreams();
    }

    private void initializeStreams() {
        try {
            writer = new PrintWriter(socket.getOutputStream(), true); // auto-flush
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
        }
    }

    @Override
    public void update(String expression) {
        sendToServer(expression);
    }

    private void sendToServer(String expression) {
        if (writer != null) {
            writer.println(expression);
            System.out.println("Sent to server: " + expression);
        } else {
            System.err.println("Writer not initialized. Cannot send: " + expression);
        }
    }

    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void close() {
        try {
            if (writer != null) writer.close();
            if (reader != null) reader.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
        }
    }
}
