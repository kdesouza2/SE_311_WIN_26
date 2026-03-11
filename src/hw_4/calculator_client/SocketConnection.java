package src.hw_4.calculator_client;

import java.io.*;
import java.net.Socket;

public class SocketConnection implements CalculatorObserver {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    /* CLIENT-SIDE CONSTRUCTOR */
    public SocketConnection(String host, int port) {
        try {
            socket = new Socket(host, port);
            initializeStreams();
        } catch (IOException e) {
        }
    }

    /* SERVER-SIDE CONSTRUCTOR */
    public SocketConnection(Socket socket) {
        this.socket = socket;
        initializeStreams();
    }

    private void initializeStreams() {
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
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
        }
    }

    // THIS IS THE COMPLETION OF getReader()
    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }
}
