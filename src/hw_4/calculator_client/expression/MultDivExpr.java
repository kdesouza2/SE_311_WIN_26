package src.hw_4.calculator_client.expression;

import src.hw_4.calculator_client.visitor.ExpressionVisitor;

public class MultDivExpr implements Expression {

    private Expression left;
    private Expression right;
    private String operator;

    public MultDivExpr(Expression left, Expression right, String operator) {
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