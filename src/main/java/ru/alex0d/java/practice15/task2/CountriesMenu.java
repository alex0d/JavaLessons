package ru.alex0d.java.practice15.task2;

import javax.swing.*;
import java.awt.*;

public class CountriesMenu extends JFrame {
    public CountriesMenu() {
        super("Countries");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1));

        Font smallFont = new Font("Verdana", Font.PLAIN, 20);
        Font mediumFont = new Font("Verdana", Font.PLAIN, 24);

        JPanel[] panel = new JPanel[3];
        final JLabel countryNameLabel = new JLabel(" ");
        final JLabel populationLabel = new JLabel("");

        String[] countries = {
                "Russia",
                "USA",
                "China"
        };

        panel[0] = new JPanel();
        panel[0].setBackground(Color.WHITE);
        panel[1] = new JPanel();
        panel[1].setBackground(Color.WHITE);
        panel[2] = new JPanel();
        panel[2].setBackground(Color.WHITE);

        add(panel[0]);
        add(panel[1]);
        add(panel[2]);

        countryNameLabel.setFont(mediumFont);
        panel[1].add(countryNameLabel);

        populationLabel.setFont(smallFont);
        panel[2].add(populationLabel);

        JComboBox comboBox = new JComboBox(countries);
        comboBox.setFont(smallFont);
        comboBox.setBackground(Color.WHITE);
        panel[0].add(comboBox);

        comboBox.addActionListener(e -> {
            JComboBox box = (JComboBox)e.getSource();
            String item = (String)box.getSelectedItem();
            countryNameLabel.setText(item);

            switch (item){
                case "Russia":
                    populationLabel.setText("Population: 146.1 million");
                    break;
                case "USA":
                    populationLabel.setText("Population: 301.7 million");
                    break;
                case "China":
                    populationLabel.setText("Population: 1,410.5 million");
            }
        });
        comboBox.setSelectedItem("Russia");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new CountriesMenu().setVisible(true));
    }
}
