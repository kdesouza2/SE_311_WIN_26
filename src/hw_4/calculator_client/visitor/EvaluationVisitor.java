package src.hw_4.calculator_client.visitor;

import src.hw_4.calculator_client.expression.AtomExpr;
import src.hw_4.calculator_client.expression.AddSubExpr;
import src.hw_4.calculator_client.expression.MultDivExpr;
import src.hw_4.calculator_client.expression.Expression;

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
