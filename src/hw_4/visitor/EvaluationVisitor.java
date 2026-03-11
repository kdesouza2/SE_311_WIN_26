package src.hw_4.visitor;

import src.hw_4.expression.AddSubExpr;
import src.hw_4.expression.AtomExpr;
import src.hw_4.expression.MultDivExpr;

public class EvaluationVisitor implements ExpressionVisitor {

    private double result;

    public double getResult() {
        return result;
    }

    @Override
    public void visit(AtomExpr expr) {
        result = expr.getValue();
    }

    @Override
    public void visit(AddSubExpr expr) {

        EvaluationVisitor leftVisitor = new EvaluationVisitor();
        expr.getLeft().accept(leftVisitor);
        double left = leftVisitor.getResult();

        EvaluationVisitor rightVisitor = new EvaluationVisitor();
        expr.getRight().accept(rightVisitor);
        double right = rightVisitor.getResult();

        if (expr.getOperator().equals("+")) {
            result = left + right;
        } else {
            result = left - right;
        }
    }

    @Override
    public void visit(MultDivExpr expr) {

        EvaluationVisitor leftVisitor = new EvaluationVisitor();
        expr.getLeft().accept(leftVisitor);
        double left = leftVisitor.getResult();

        EvaluationVisitor rightVisitor = new EvaluationVisitor();
        expr.getRight().accept(rightVisitor);
        double right = rightVisitor.getResult();

        if (expr.getOperator().equals("*")) {
            result = left * right;
        } else {
            result = right != 0 ? left / right : 0;
        }
    }
}
