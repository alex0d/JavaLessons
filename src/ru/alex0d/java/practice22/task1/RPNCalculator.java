package ru.alex0d.java.practice22.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public abstract class RPNCalculator {
    public static Double calculate(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        try {
            String[] tokens = expression.split("(?<=[-+*/%])|(?=[-+*/%])");
            for (String token : tokens) {
                if (isNumeric(token)) {
                    operands.push(Double.valueOf(token));
                } else {
                    if (operators.isEmpty()) {
                        operators.push(token);
                    } else {
                        String operator = operators.peek();
                        if (getPriority(operator) >= getPriority(token)) {
                            Double rightOperand = operands.pop();
                            Double leftOperand = operands.pop();
                            Double result = calculate(leftOperand, rightOperand, operator);
                            operands.push(result);
                            operators.pop();
                            operators.push(token);
                        } else {
                            operators.push(token);
                        }
                    }
                }
            }
            while (!operators.isEmpty()) {
                String operator = operators.pop();
                Double rightOperand = operands.pop();
                Double leftOperand = operands.pop();
                Double result = calculate(leftOperand, rightOperand, operator);
                operands.push(result);
            }
            Double ans = operands.pop();
            return BigDecimal.valueOf(ans).setScale(2, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static int getPriority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }

    private static Double calculate(Double leftOperand, Double rightOperand, String operator) {
        return switch (operator) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            case "%" -> leftOperand % rightOperand;
            default -> 0.0;
        };
    }

}