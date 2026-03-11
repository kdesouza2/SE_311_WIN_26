package src.hw_4.expression;

import src.hw_4.visitor.ExpressionVisitor;

public class AtomExpr implements Expression {

    private final double value;

    public AtomExpr(double value) {
        this.value = value;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

    public double getValue() {
        return value;
    }
}
