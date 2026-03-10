package src.hw_4.visitor;

import src.hw_4.expression.AddSubExpr;
import src.hw_4.expression.AtomExpr;
import src.hw_4.expression.MultDivExpr;

public interface ExpressionVisitor {

    void visit(AtomExpr expr);

    void visit(AddSubExpr expr);

    void visit(MultDivExpr expr);

}
