package ru.alex0d.java.practice16.task1;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class GuessingGame extends JFrame {
    public GuessingGame(){
        super("Угадайка");
        setSize(150, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JTextField userInput = new JTextField();
        add(userInput, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 10, 5), 0, 0));

        JButton userButton = new JButton("Попробовать");
        add(userButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(10, 3, 5, 3), 0, 0));
        final int[] counter = {0};
        int generatedInt = ThreadLocalRandom.current().nextInt(0, 20 + 1);

        userButton.addActionListener(e -> {
            if(userInput.getText().isEmpty()) {
                return;
            }
            if (userInput.getText().equals(Integer.toString(generatedInt))){
                JOptionPane.showMessageDialog(getContentPane(),
                        "Вы угадали! Количество попыток: " + counter[0],
                        "Вы угадали",
                        JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
                dispose();
            }
            else if(counter[0] == 2){
                JOptionPane.showMessageDialog(getContentPane(),
                        "Вы проиграли! Загаданное число: " + generatedInt,
                        "Вы проиграли",
                        JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
                dispose();
            }
            else {
                counter[0]++;
                System.out.println("---Для отладки---");
                System.out.println("Заданное число: " + generatedInt);
                System.out.println("Введенное число: " + userInput.getText());
                System.out.println("Попытка №" + counter[0]);
                if (Integer.parseInt(userInput.getText()) > generatedInt){
                    JOptionPane.showMessageDialog(getContentPane(),
                            "Загаданное число меньше",
                            "Подсказка",
                            JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(getContentPane(),
                            "Загаданное число больше",
                            "Подсказка",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GuessingGame().setVisible(true));
    }

}
