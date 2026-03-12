package src.hw_4.expression;

import src.hw_4.visitor.ExpressionVisitor;

public class MultDivExpr implements Expression {

    private final Expression left;
    private final Expression right;
    private final String operator;

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

    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}