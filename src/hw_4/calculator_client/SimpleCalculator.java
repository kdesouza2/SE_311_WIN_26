package src.hw_4.calculator_client;

import java.util.ArrayList;
import java.util.List;
import src.hw_4.expression.*;
import src.hw_4.state.CalculatorState;
import src.hw_4.state.StartState;
import src.hw_4.visitor.*;

public class SimpleCalculator {

    private CalculatorState currentState;

    private Expression currentExpression;   // root of expression tree
    private String operator;

    private String display = "";

    private final List<CalculatorObserver> observers = new ArrayList<>();


    public SimpleCalculator() {
        currentState = new StartState();
    }


    public void processInput(String input) {
        currentState.handleInput(this, input);
    }


    public void setState(CalculatorState state) {
        this.currentState = state;
    }


    public void setDisplay(String text) {
        display = text;
    }


    public void appendDisplay(String text) {
        display += text;
    }


    public String getDisplay() {
        return display;
    }


    /* CREATE ATOM FROM DISPLAY */
    public void createAtom() {
        double value = Double.parseDouble(display);
        Expression atom = new AtomExpr(value);

        if (currentExpression == null) {
            currentExpression = atom;
        } else {
            buildExpression(atom);
        }

        display = "";
    }


    public void setOperator(String op) {
        operator = op;
    }


    /* BUILD TREE NODE */
    private void buildExpression(Expression right) {

        if (operator.equals("+") || operator.equals("-")) {
    
            currentExpression = new AddSubExpr(
                    currentExpression,
                    right,
                    operator
            );
        }
    
        else if (operator.equals("*") || operator.equals("/")) {
    
            // If current expression is Add/Sub, attach inside its right side
            if (currentExpression instanceof AddSubExpr addSub) {
    
                Expression rightChild = addSub.getRight();
    
                MultDivExpr multDiv = new MultDivExpr(
                        rightChild,
                        right,
                        operator
                );
    
                addSub.setRight(multDiv);
    
            } else {
    
                currentExpression = new MultDivExpr(
                        currentExpression,
                        right,
                        operator
                );
            }
        }
    }


    /* VISITOR CALCULATION */
    public void calculate() {
        if (display.length() > 0) {
            createAtom();
        }
    
        EvaluationVisitor visitor = new EvaluationVisitor();
        currentExpression.accept(visitor);
        double result = visitor.getResult();
    
        display = String.valueOf(result);
    
        // Send expression to server
        notifyObservers(currentExpression.toString() + " = " + result);
    
        currentExpression = null;
    }


    /* CLEAR */
    public void clear() {
        display = "0";
        operator = "";
        currentExpression = null;
    }


    /* OBSERVER METHODS */

    public void addObserver(CalculatorObserver obs) {
        observers.add(obs);
    }

    public void notifyObservers(String expr) {
        for (CalculatorObserver obs : observers) {
            obs.update(expr);
        }
    }


    public void storeCurrentNumber() {
        if (!display.isEmpty()) {
            createAtom();   // turns display into AtomExpr and attaches it to the tree
        }
    }

    public void startNewNumber(String digit) {
        display = digit;
    }

    public void setFirstNumber() {
        if (!display.isEmpty()) {
            double value = Double.parseDouble(display);
            currentExpression = new AtomExpr(value);
            display = "";
        }
    }
    
    
}