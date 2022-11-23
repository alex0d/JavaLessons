package ru.alex0d.java.practice15.task4;

import ru.alex0d.java.practice15.task2.CountriesMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class AdvancedCalculator extends JFrame {
    AdvancedCalculator() {
        super("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);
        getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));

        JTextField textField = new JTextField() {
            @Override
            public void setText(String t) {
                if (t.equals("Ошибк")) {
                    // Была нажата кнопка "Удалить" после ошибки
                    super.setText("");
                } else if (!t.isEmpty() && getText().contains("Ошибка")) {
                    // Была нажата какая-то кнопка после ошибки
                    super.setText(t.charAt(t.length() - 1) + "");
                } else {
                    super.setText(t);
                }
            }
        };
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Verdana", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridy = 0;
        textFieldConstraints.gridwidth = GridBagConstraints.REMAINDER;
        textFieldConstraints.anchor = GridBagConstraints.CENTER;
        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        textFieldConstraints.insets = new Insets(10, 10, 10, 10);
        add(textField, textFieldConstraints);

        JButton[] digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + ((JButton) e.getSource()).getText());
                }
            });
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

        JButton commaButton = new JButton(".");
        commaButton.addActionListener(e -> textField.setText(textField.getText() + "."));
        add(commaButton, getButtonConstraints(1, 5));

        JButton answerButton = new JButton("=");
        answerButton.addActionListener(e -> {
            Double answer = calculate(textField.getText());
            if (answer != null) {
                textField.setText(answer.toString());
            } else {
                textField.setText("Ошибка");
            }
        });
        GridBagConstraints answerButtonConstraint = getButtonConstraints(2, 5);
        answerButtonConstraint.gridwidth = GridBagConstraints.REMAINDER;
        add(answerButton, answerButtonConstraint);

        JButton plusButton = new JButton("+");
        plusButton.addActionListener(e -> textField.setText(textField.getText() + "+"));
        add(plusButton, getButtonConstraints(3, 4));

        JButton minusButton = new JButton("-");
        minusButton.addActionListener(e -> textField.setText(textField.getText() + "-"));
        add(minusButton, getButtonConstraints(3, 3));

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(e -> textField.setText(textField.getText() + "*"));
        add(multiplyButton, getButtonConstraints(3, 2));

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(e -> textField.setText(textField.getText() + "/"));
        add(divideButton, getButtonConstraints(3, 1));

        JButton moduloButton = new JButton("%");
        moduloButton.addActionListener(e -> textField.setText(textField.getText() + "%"));
        add(moduloButton, getButtonConstraints(2, 1));

        JButton deleteButton = new JButton("◀");
        deleteButton.addActionListener(e -> {
            String text = textField.getText();
            if (text.length() > 0) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        });
        add(deleteButton, getButtonConstraints(1, 1));

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(e -> textField.setText(""));
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

    private boolean isNumeric(String str) {
        return str.matches("\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private int getPriority(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }

    private Double calculate(Double leftOperand, Double rightOperand, String operator) {
        return switch (operator) {
            case "+" -> leftOperand + rightOperand;
            case "-" -> leftOperand - rightOperand;
            case "*" -> leftOperand * rightOperand;
            case "/" -> leftOperand / rightOperand;
            case "%" -> leftOperand % rightOperand;
            default -> 0.0;
        };
    }

    private Double calculate(String expression) {
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
            System.err.println("An error occurred while calculating expression: " + expression);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new AdvancedCalculator().setVisible(true));
    }

}
