package ru.alex0d.java.practice22.task2;

import javax.swing.*;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorUI view;

    public CalculatorController(CalculatorModel model, CalculatorUI view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        view.setVisible(true);

        model.setExpression("");

        JButton[] digitButtons = view.getDigitButtons();
        for (JButton digitButton : digitButtons) {
            digitButton.addActionListener(e -> buttonClicked(((JButton) e.getSource()).getText()));
        }

        JButton[] operationButtons = view.getOperationButtons();
        for (JButton operationButton : operationButtons) {
            operationButton.addActionListener(e -> buttonClicked(((JButton) e.getSource()).getText()));
        }

        view.getCommaButton().addActionListener(e -> buttonClicked("."));
        view.getAnswerButton().addActionListener(e -> getAnswer());
        view.getDeleteButton().addActionListener(e -> deleteLastSymbol());
        view.getClearButton().addActionListener(e -> clearExpression());
    }

    private void buttonClicked(String text) {
        String currentExpression = model.getExpression();
        char lastSymbol = currentExpression.length() > 0 ? currentExpression.charAt(currentExpression.length() - 1) : ' ';
        if (lastSymbol == '.' && text.equals(".")) {
            return;
        }

        String operationSymbols = "+-*/%";
        if (lastSymbol == ' ' && (operationSymbols.contains(text) || text.equals("."))) {
            return;
        }
        if (operationSymbols.contains(text) && operationSymbols.contains(String.valueOf(lastSymbol))) {
            model.setExpression(currentExpression.substring(0, currentExpression.length() - 1) + text);
        } else {
            model.setExpression(currentExpression + text);
        }
        view.getExpressionField().setText(model.getExpression());
    }

    private void getAnswer() {
        double answer = model.getAnswer();
        if (answer == Double.POSITIVE_INFINITY) {
            view.getExpressionField().setText("Ошибка");
        } else {
            view.getExpressionField().setText(String.valueOf(answer));
        }
    }

    private void deleteLastSymbol() {
        model.deleteLastSymbol();
        view.getExpressionField().setText(model.getExpression());
    }

    private void clearExpression() {
        model.clearExpression();
        view.getExpressionField().setText(model.getExpression());
    }
}
