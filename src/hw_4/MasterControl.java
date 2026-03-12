package src.hw_4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import src.hw_4.calculator_client.CalculatorClient;
import src.hw_4.calculator_client.SimpleCalculator;
import src.hw_4.calculator_client.SocketConnection;
import src.hw_4.calculator_server.CalculatorServer;

public class MasterControl {

    public static void main(String[] args) {

        CalculatorServer server = new CalculatorServer(5000);
        Thread serverThread = new Thread(server::start);
        serverThread.start();

        SimpleCalculator calculator = new SimpleCalculator();
        SocketConnection connection = new SocketConnection("localhost", 5000);
        calculator.addObserver(connection);

        CalculatorClient gui = new CalculatorClient(calculator);

        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    // Close the client connection
                    connection.close();

                    // Stop server
                    server.stop();

                    // Wait for server thread to finish
                    serverThread.join();

                    // Write summary now that all equations have been received
                    server.writeSummary();

                } catch (InterruptedException ex) {
                }
            }
        });
    }
}