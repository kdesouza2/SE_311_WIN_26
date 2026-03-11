package src.hw_4.state;

import src.hw_4.calculator_client.SimpleCalculator;

public class GettingMulDivOperandState implements CalculatorState {

    @Override
    public void handleInput(SimpleCalculator calculator, String input) {

        if (input.matches("[0-9]")) {
            calculator.appendDisplay(input);
        }

        else if (input.equals("*") || input.equals("/")) {
            calculator.storeCurrentNumber();
            calculator.setOperator(input);
            calculator.setState(new WaitingForMulDivOperandState());
        }

        else if (input.equals("+") || input.equals("-")) {
            calculator.storeCurrentNumber();
            calculator.setOperator(input);
            calculator.setState(new WaitingForAddSubOperandState());
        }

        else if (input.equals("=")) {
            calculator.storeCurrentNumber();
            calculator.calculate();
            calculator.setState(new CalculateState());
        }

        else if (input.equals("C")) {
            calculator.clear();
            calculator.setState(new StartState());
        }
    }
}

