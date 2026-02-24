package src.hw_3;

import java.io.*;
import java.net.Socket;
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

    // Used by: ClientHandler
    public void sendResults(List<String> message) {

        for (String line : message) {
            out.println(line);
        }
    
        out.println("END_MESSAGE");
    }

    // Used by: KWICClient
    public void sendCommand(String command) {
        out.println(command);
    }

    // Used by: ClientHandler
    public String receiveCommand() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to receive message.", e);
        }
    }

    // Used by: KWICClient
    public List<String> receiveResults() {

        List<String> results = new ArrayList<>();

        try {
            String line;

            while ((line = in.readLine()) != null) {

                if (line.equals("END_COMMAND")) {
                    break;
                }

                results.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to receive results.", e);
        }

        return results;
    }


    public void close() {
        try {
            if (socket != null) {
                socket.close();
                System.out.println("Socket connection closed.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to close socket connection.", e);
        }
    }
}