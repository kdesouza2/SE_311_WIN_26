package src.hw_4.expression;

import src.hw_4.visitor.ExpressionVistor;

public interface Expression {

    void accept(ExpressionVisitor visitor);

}

