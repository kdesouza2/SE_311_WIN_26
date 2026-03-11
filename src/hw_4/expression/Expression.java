package src.hw_4.expression;

import src.hw_4.visitor.ExpressionVisitor;

public interface Expression {

    void accept(ExpressionVisitor visitor);

}

