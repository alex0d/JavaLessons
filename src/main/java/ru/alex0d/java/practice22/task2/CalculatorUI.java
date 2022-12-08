package ru.alex0d.java.practice22.task2;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    private final JTextField expressionField;
    private final JButton[] digitButtons;
    private final JButton commaButton;
    private final JButton answerButton;
    private final JButton plusButton;
    private final JButton minusButton;
    private final JButton multiplyButton;
    private final JButton divideButton;
    private final JButton moduloButton;
    private final JButton deleteButton;
    private final JButton clearButton;
    CalculatorUI() {
        super("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(270, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);
        getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));

        expressionField = new JTextField();
        expressionField.setEditable(false);
        expressionField.setBackground(Color.WHITE);
        expressionField.setFont(new Font("Verdana", Font.PLAIN, 20));
        expressionField.setHorizontalAlignment(JTextField.RIGHT);
        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridy = 0;
        textFieldConstraints.gridwidth = GridBagConstraints.REMAINDER;
        textFieldConstraints.anchor = GridBagConstraints.CENTER;
        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        textFieldConstraints.insets = new Insets(10, 10, 10, 10);
        add(expressionField, textFieldConstraints);

        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
        }
        add(digitButtons[0], getButtonConstraints(0, 5));

        add(digitButtons[1], getButtonConstraints(0, 4));
        add(digitButtons[2], getButtonConstraints(1, 4));
        add(digitButtons[3], getButtonConstraints(2, 4));

        add(digitButtons[4], getButtonConstraints(0, 3));
        add(digitButtons[5], getButtonConstraints(1, 3));
        add(digitButtons[6], getButtonConstraints(2, 3));

        add(digitButtons[7], getButtonConstraints(0, 2));
        add(digitButtons[8], getButtonConstraints(1, 2));
        add(digitButtons[9], getButtonConstraints(2, 2));

        commaButton = new JButton(".");
        add(commaButton, getButtonConstraints(1, 5));

        answerButton = new JButton("=");
        GridBagConstraints answerButtonConstraint = getButtonConstraints(2, 5);
        answerButtonConstraint.gridwidth = GridBagConstraints.REMAINDER;
        add(answerButton, answerButtonConstraint);

        plusButton = new JButton("+");
        add(plusButton, getButtonConstraints(3, 4));

        minusButton = new JButton("-");
        add(minusButton, getButtonConstraints(3, 3));

        multiplyButton = new JButton("*");
        add(multiplyButton, getButtonConstraints(3, 2));

        divideButton = new JButton("/");
        add(divideButton, getButtonConstraints(3, 1));

        moduloButton = new JButton("%");
        add(moduloButton, getButtonConstraints(2, 1));

        deleteButton = new JButton("◀");
        add(deleteButton, getButtonConstraints(1, 1));

        clearButton = new JButton("C");
        add(clearButton, getButtonConstraints(0, 1));

        Font buttonFont = new Font("Dialog", Font.BOLD, 16);
        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                component.setFont(buttonFont);
                component.setBackground(new Color(0xEEEEEE));
            }
        }
        answerButton.setBackground(new Color(0x1978C5));
        answerButton.setForeground(Color.WHITE);

    }

    private GridBagConstraints getButtonConstraints(int x, int y) {
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = x;
        buttonConstraints.gridy = y;
        buttonConstraints.weightx = 0.5f;
        buttonConstraints.weighty = 0.5f;
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.insets = new Insets(5, 5, 5, 5);
        return buttonConstraints;
    }

    public JTextField getExpressionField() {
        return expressionField;
    }

    public JButton[] getDigitButtons() {
        return digitButtons;
    }

    public JButton[] getOperationButtons() {
        return new JButton[]{
                plusButton,
                minusButton,
                multiplyButton,
                divideButton,
                moduloButton};
    }

    public JButton getCommaButton() {
        return commaButton;
    }

    public JButton getAnswerButton() {
        return answerButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
}
