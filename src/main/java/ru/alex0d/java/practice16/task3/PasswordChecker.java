package ru.alex0d.java.practice16.task3;

import javax.swing.*;
import java.awt.*;

public class PasswordChecker extends JFrame {
    public PasswordChecker(){
        super("CheckingPassword");
        Container contentPane = getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        setSize(350,180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.gray);

        JPanel serviceLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel serviceLabel = new JLabel("Service: ");
        serviceLabelPanel.add(serviceLabel);
        add(serviceLabelPanel);

        JPanel serviceFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField serviceField = new JTextField();
        serviceField.setPreferredSize(new Dimension(200, 20));
        serviceField.setBorder(BorderFactory.createLineBorder(Color.black));
        serviceFieldPanel.add(serviceField);
        add(serviceFieldPanel);



        JPanel nameLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("User name: ");
        nameLabelPanel.add(nameLabel);
        add(nameLabelPanel);

        JPanel nameFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 20));
        nameField.setBorder(BorderFactory.createLineBorder(Color.black));
        nameFieldPanel.add(nameField);
        add(nameFieldPanel);

        JPanel passwordLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel password_label = new JLabel("Password: ");
        passwordLabelPanel.add(password_label);
        add(passwordLabelPanel);

        JPanel passwordFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(200, 20));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordFieldPanel.add(passwordField);
        add(passwordFieldPanel);


        layout.putConstraint(SpringLayout.WEST, serviceLabelPanel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, serviceFieldPanel, 100, SpringLayout.WEST, serviceLabelPanel);

        layout.putConstraint(SpringLayout.NORTH, nameLabelPanel, 15, SpringLayout.SOUTH,serviceLabelPanel );
        layout.putConstraint(SpringLayout.WEST, nameLabelPanel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, nameFieldPanel, 10, SpringLayout.SOUTH,serviceFieldPanel );
        layout.putConstraint(SpringLayout.WEST, nameFieldPanel, 100, SpringLayout.WEST, nameLabelPanel);

        layout.putConstraint(SpringLayout.NORTH, passwordLabelPanel, 15, SpringLayout.SOUTH,nameLabelPanel );
        layout.putConstraint(SpringLayout.WEST, passwordLabelPanel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, passwordFieldPanel, 15, SpringLayout.SOUTH,nameFieldPanel );
        layout.putConstraint(SpringLayout.WEST, passwordFieldPanel, 100, SpringLayout.WEST, passwordLabelPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new PasswordChecker().setVisible(true));
    }
}
