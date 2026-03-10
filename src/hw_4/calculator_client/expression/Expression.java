package src.hw_4.calculator_client.expression;

import src.hw_4.calculator_client.visitor.ExpressionVisitor;

public interface Expression {

    void accept(ExpressionVisitor visitor);

}
