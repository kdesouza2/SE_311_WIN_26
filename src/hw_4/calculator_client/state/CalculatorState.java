package src.hw_4.calculator_client.state;

import src.hw_4.calculator_client.SimpleCalculator;

public interface CalculatorState {
    
    void handleInput(SimpleCalculator calculator, String input);
}
