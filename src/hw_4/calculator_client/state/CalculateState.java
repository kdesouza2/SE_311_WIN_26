package src.hw_4.calculator_client.state;

import src.hw_4.calculator_client.SimpleCalculator;

public class CalculateState implements CalculatorState {

    @Override
    public void handleInput(SimpleCalculator calculator, String input) {

        if (input.matches("[0-9]")) {
            calculator.startNewNumber(input);
            calculator.setState(new GettingFirstOperandState());
        }

        else if (input.equals("+") || input.equals("-")) {
            calculator.storeCurrentNumber();
            calculator.setOperator(input);
            calculator.setState(new WaitingForAddSubOperandState());
        }

        else if (input.equals("*") || input.equals("/")) {
            calculator.storeCurrentNumber();
            calculator.setOperator(input);
            calculator.setState(new WaitingForMulDivOperandState());
        }

        else if (input.equals("C")) {
            calculator.clear();
            calculator.setState(new StartState());
        }
    }
}

