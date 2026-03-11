package src.hw_4.calculator_client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorClient extends JFrame implements ActionListener {

    private final JTextField display;
    private boolean startNewNumber = true;

    private final SimpleCalculator calculator;

    public CalculatorClient() {

        calculator = new SimpleCalculator();

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(0, 60));

        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "0","=","C","/"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        calculator.processInput(command);

        display.setText(calculator.getDisplay());

    }
}
