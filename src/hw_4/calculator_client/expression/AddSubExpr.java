package src.hw_4.calculator_client.expression;

import src.hw_4.calculator_client.visitor.ExpressionVisitor;

public class AddSubExpr implements Expression {

    private final Expression left;
    private final Expression right;
    private String operator;

    public AddSubExpr(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
