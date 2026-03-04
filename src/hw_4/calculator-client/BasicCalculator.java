import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicCalculator extends JFrame implements ActionListener {

    private final JTextField display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public BasicCalculator() {

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===== Add Padding Around Entire Frame =====
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // ===== Display Panel =====
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(0, 60));
        add(display, BorderLayout.NORTH);

        // ===== Button Panel =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBackground(new Color(230, 240, 250)); // Light background panel

        String[] buttons = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", "=", "C", "/"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));

            // ===== Button Styling =====
            button.setBackground(new Color(173, 216, 230)); // Light blue
            button.setFocusPainted(false);

            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                display.setText(command);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + command);
            }
        }

        else if (command.matches("[+\\-*/]")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            startNewNumber = true;
        }

        else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+" -> result = firstNumber + secondNumber;
                case "-" -> result = firstNumber - secondNumber;
                case "*" -> result = firstNumber * secondNumber;
                case "/" -> result = (secondNumber != 0) ? firstNumber / secondNumber : 0;
            }

            display.setText(String.valueOf(result));
            startNewNumber = true;
        }

        else if (command.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operator = "";
            startNewNumber = true;
        }
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}
