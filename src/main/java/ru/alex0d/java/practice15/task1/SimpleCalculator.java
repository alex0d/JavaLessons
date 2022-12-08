package ru.alex0d.java.practice15.task1;

import java.awt.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame{
    public SimpleCalculator() {
        super("Simple Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,2));

        JPanel[] panel = new JPanel[8];

        JLabel firstNumberLabel = new JLabel();
        JLabel secondNumberLabel = new JLabel();


        JTextField firstNumberText = new JTextField(4);
        JTextField secondNumberText = new JTextField(4);

        Font smallFont = new Font("Times new roman", Font.BOLD, 16);
        Font mediumFont = new Font ("Times new roman", Font.BOLD, 24);
        Font largeFont = new Font("Times new roman", Font.BOLD,32);

        JButton addButton = new JButton("+");
        addButton.setFocusPainted(false);
        addButton.setBackground(Color.ORANGE);
        addButton.setFont(mediumFont);

        JButton subtractButton = new JButton("-");
        subtractButton.setFont(mediumFont);
        subtractButton.setFocusPainted(false);
        subtractButton.setBackground(Color.ORANGE);

        JButton divideButton = new JButton("/");
        divideButton.setFocusPainted(false);
        divideButton.setBackground(Color.ORANGE);
        divideButton.setFont(mediumFont);

        JButton multiplyButton = new JButton("*");
        multiplyButton.setFocusPainted(false);
        multiplyButton.setBackground(Color.ORANGE);
        multiplyButton.setFont(mediumFont);

        for (int i = 0; i < 8; i++){
            panel[i] = new JPanel();
            panel[i].setBackground(Color.WHITE);
            add(panel[i]);
        }

        panel[0].add(firstNumberText);
        firstNumberText.setFont(largeFont);
        firstNumberText.setForeground(Color.black);
        firstNumberText.setBorder(BorderFactory.createLineBorder(Color.black));

        panel[1].add(secondNumberText);
        secondNumberText.setFont(largeFont);
        secondNumberText.setForeground(Color.black);
        secondNumberText.setBorder(BorderFactory.createLineBorder(Color.black));

        panel[2].add(firstNumberLabel);
        firstNumberLabel.setFont(smallFont);
        firstNumberLabel.setText("Число 1");

        panel[3].add(secondNumberLabel);
        secondNumberLabel.setFont(smallFont);
        secondNumberLabel.setText("Число 2");


        panel[4].add(addButton);
        panel[5].add(divideButton);
        panel[6].add(subtractButton);
        panel[7].add(multiplyButton);

        addButton.addActionListener(e -> {
            try {
                double firstNum = Double.parseDouble(firstNumberText.getText().trim());
                double secondNum = Double.parseDouble(secondNumberText.getText().trim());

                JOptionPane.showMessageDialog(this, "Ответ: " + (firstNum + secondNum), "Ответ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exp){
                JOptionPane.showMessageDialog(this, "Ошибка ввода", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        });

        subtractButton.addActionListener(e -> {
            try {
                double firstNum = Double.parseDouble(firstNumberText.getText().trim());
                double secondNum = Double.parseDouble(secondNumberText.getText().trim());

                JOptionPane.showMessageDialog(this, "Ответ: " + (firstNum - secondNum), "Ответ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exp){
                JOptionPane.showMessageDialog(this, "Ошибка ввода", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        });

        divideButton.addActionListener(e -> {
            try {
                double firstNum = Double.parseDouble(firstNumberText.getText().trim());
                double secondNum = Double.parseDouble(secondNumberText.getText().trim());

                JOptionPane.showMessageDialog(this, "Ответ: " + firstNum / secondNum, "Ответ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exp){
                JOptionPane.showMessageDialog(this, "Ошибка ввода", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        });

        multiplyButton.addActionListener(e -> {
            try {
                double firstNum = Double.parseDouble(firstNumberText.getText().trim());
                double secondNum = Double.parseDouble(secondNumberText.getText().trim());

                JOptionPane.showMessageDialog(this, "Ответ: " + firstNum * secondNum, "Ответ", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exp){
                JOptionPane.showMessageDialog(this, "Ошибка ввода", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SimpleCalculator().setVisible(true));
    }
}