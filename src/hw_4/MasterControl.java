package src.hw_4;

import src.hw_4.calculator_client.CalculatorClient;
import src.hw_4.calculator_client.SimpleCalculator;
import src.hw_4.calculator_client.SocketConnection;
import src.hw_4.calculator_server.CalculatorServer;

public class MasterControl {

    public static void main(String[] args) {

        new Thread(() -> {
            CalculatorServer server = new CalculatorServer(5000);
            server.start();
        }).start();

        SimpleCalculator calculator = new SimpleCalculator();

        SocketConnection connection = new SocketConnection("localhost", 5000);

        calculator.addObserver(connection);

        CalculatorClient gui = new CalculatorClient();

    }
}
