package ru.alex0d.java.practice22.task2;

import ru.alex0d.java.practice22.task1.RPNCalculator;

public class CalculatorModel {
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void deleteLastSymbol() {
        if (expression.length() > 0) {
            expression = expression.substring(0, expression.length() - 1);
        }
    }

    public void clearExpression() {
        expression = "";
    }

    public double getAnswer() {
        Double ans = RPNCalculator.calculate(expression);
        if (ans == null) {
            expression = "";
            return Double.POSITIVE_INFINITY;
        }
        expression = String.valueOf(ans);
        return ans;
    }
}
