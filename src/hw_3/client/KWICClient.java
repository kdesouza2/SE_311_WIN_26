package src.hw_3.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class KWICClient {

    private SocketConnection connection;

    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public void connect() {
        connection = new SocketConnection(HOST, PORT);
        connection.open();
    }

    public void sendCommand(String[] args) {
        // Convert command args to one string
        String command = String.join(" ", args);
        connection.sendCommand(command);          // send command
    }


    public List<String> receiveResults() throws IOException {
        List<String> results = new ArrayList<>();

        while (true) {
            String line = connection.readLine();   

            if (line == null) break;               
            if (line.equals("END")) break;         

            results.add(line);
        }

        return results;
    }

    public void disconnect() {
        if (connection != null) {
            connection.close();
        }
    }
}