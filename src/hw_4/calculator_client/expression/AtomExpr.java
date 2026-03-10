package src.hw_4.calculator_client.expression;

public class AtomExpr implements Expression {

    private double value;

    public AtomExpr(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}
