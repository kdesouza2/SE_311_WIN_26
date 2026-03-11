package src.hw_4.expression;

import src.hw_4.visitor.ExpressionVisitor;

public class AddSubExpr implements Expression {

    private final Expression left;
    private Expression right;
    private final String operator;

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

    
    public void setRight(Expression expr) {
        this.right = expr;
    }
}
