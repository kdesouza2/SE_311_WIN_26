package src.hw_4.calculator_client.state;

import src.hw_4.calculator_client.SimpleCalculator;

public class StartState implements CalculatorState {

    @Override
    public void handleInput(SimpleCalculator calculator, String input) {

        if (input.matches("[0-9]")) {
            calculator.setDisplay(input);
            calculator.setState(new GettingFirstOperandState());
        }

        else if (input.equals("C")) {
            calculator.clear();
        }
    }
}

