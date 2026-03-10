package src.hw_4.calculator_server;

import src.hw_4.calculator_client.expression.AtomExpr;
import src.hw_4.calculator_client.expression.AddSubExpr;
import src.hw_4.calculator_client.expression.MultDivExpr;
import src.hw_4.calculator_client.visitor.ExpressionVisitor;

public class ValidationVisitor implements ExpressionVisitor {

    private boolean valid = true;

    public boolean isValid() {
        return valid;
    }

    @Override
    public void visit(AtomExpr expr) {
        // AtomExpr is valid as long as it exists
        if (expr == null) {
            valid = false;
        }
    }

    @Override
    public void visit(AddSubExpr expr) {

        if (expr.getLeft() == null || expr.getRight() == null) {
            valid = false;
            return;
        }

        expr.getLeft().accept(this);
        if (!valid) return;

        expr.getRight().accept(this);
        if (!valid) return;

        String op = expr.getOperator();

        if (op == null || (!op.equals("+") && !op.equals("-"))) {
            valid = false;
        }
    }

    @Override
    public void visit(MultDivExpr expr) {

        if (expr.getLeft() == null || expr.getRight() == null) {
            valid = false;
            return;
        }

        expr.getLeft().accept(this);
        if (!valid) return;

        expr.getRight().accept(this);
        if (!valid) return;

        String op = expr.getOperator();

        if (op == null || (!op.equals("*") && !op.equals("/"))) {
            valid = false;
            return;
        }

        // Division by zero check
        if (op.equals("/") && expr.getRight() instanceof AtomExpr) {

            double value = ((AtomExpr) expr.getRight()).getValue();

            if (value == 0) {
                valid = false;
            }
        }
    }
}
