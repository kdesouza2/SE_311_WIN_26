package src.hw_3.client;

import java.util.List;

public class KWICClient {

    private SocketConnection connection;

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public void connect() {
        connection = new SocketConnection(HOST, PORT);
        connection.open();
    }

    public List<String> sendCommand(String[] args) {
        // Convert command args to one string
        String command = String.join(" ", args);
        connection.sendCommand(command);          // send command
        return connection.receiveResults();       // wait and return response
    }

    public void disconnect() {
        if (connection != null) {
            connection.close();
        }
    }
}