package src.hw_4.state;

import src.hw_4.calculator_client.SimpleCalculator;

public class WaitingForMulDivOperandState implements CalculatorState {

    @Override
    public void handleInput(SimpleCalculator calculator, String input) {

        if (input.matches("[0-9]")) {
            calculator.startNewNumber(input);
            calculator.setState(new GettingMulDivOperandState());
        }

        else if (input.equals("*") || input.equals("/")) {
            calculator.setOperator(input);
        }

        else if (input.equals("+") || input.equals("-")) {
            calculator.setOperator(input);
            calculator.setState(new WaitingForAddSubOperandState());
        }

        else if (input.equals("C")) {
            calculator.clear();
            calculator.setState(new StartState());
        }
    }
}
