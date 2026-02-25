package src.hw_3.client;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class SocketConnection {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private String host;
    private int port;

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

    /* Used by client */
    public void open() {
        try {
            socket = new Socket(host, port);
            socket.setSoTimeout(30000); // 30-second timeout
            initializeStreams();
            System.out.println("Connected to server at " + host + ":" + port);
        } catch (IOException e) {
            throw new RuntimeException("Failed to open socket connection.", e);
        }
    }

    private void initializeStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize streams.", e);
        }
    }

    /* --- SERVER USE --- */
    // Sends multi-line result to client, ending with marker
    public void sendResults(List<String> message) {
        for (String line : message) {
            out.println(line);
        }
        out.println("END"); // signal end of message
    }

    // Receives a single command line from client
    public String receiveCommand() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to receive message.", e);
        }
    }

    /* --- CLIENT USE --- */
    // Sends single-line command to server
    public void sendCommand(String command) {
        out.println(command);
    }

    // Receives multi-line response from server until END_MESSAGE
    public List<String> receiveResults() {
        List<String> results = new ArrayList<>();
        try {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("END")) {
                    break;
                }
                results.add(line);
            }
        } catch (SocketTimeoutException e) {
            throw new RuntimeException("The KWIC server is not responding.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to receive results.", e);
        }
        return results;
    }

    public void close() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                // System.out.println("Socket connection closed.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to close socket connection.", e);
        }
    }

    public String readLine() throws IOException {
        return in.readLine();
    }
    
}