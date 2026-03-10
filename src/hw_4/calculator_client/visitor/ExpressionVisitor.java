package src.hw_4.calculator_client.visitor;

import src.hw_4.calculator_client.expression.AtomExpr;
import src.hw_4.calculator_client.expression.AddSubExpr;
import src.hw_4.calculator_client.expression.MultDivExpr;

public interface ExpressionVisitor {

    void visit(AtomExpr expr);

    void visit(AddSubExpr expr);

    void visit(MultDivExpr expr);

}
