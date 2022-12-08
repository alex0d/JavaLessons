package ru.alex0d.java.practice16.task2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Areas extends JFrame {
    public Areas() {
        super("Areas");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        add(center, BorderLayout.CENTER);
        center.add(new JLabel("CENTER"));

        JPanel west = new JPanel();
        west.setLayout(new GridBagLayout());
        add(west, BorderLayout.WEST);
        west.add(new JLabel("WEST"));

        JPanel south = new JPanel();
        south.setLayout(new GridBagLayout());
        add(south, BorderLayout.SOUTH);
        south.add(new JLabel("SOUTH"));

        JPanel north = new JPanel();
        north.setLayout(new GridBagLayout());
        add(north, BorderLayout.NORTH);
        north.add(new JLabel("NORTH"));

        JPanel east = new JPanel();
        east.setLayout(new GridBagLayout());
        add(east, BorderLayout.EAST);
        east.add(new JLabel("EAST"));

        final Integer[] mouse_prev_position = {0};

        center.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouse_prev_position[0] == 1) return;
                JOptionPane.showMessageDialog(getContentPane(),
                        "Добро пожаловать в ЦАО",
                        "Переезд",
                        JOptionPane.PLAIN_MESSAGE);
                mouse_prev_position[0] = 1;
            }
        });

        west.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouse_prev_position[0] == 2) return;
                JOptionPane.showMessageDialog(getContentPane(),
                        "Добро пожаловать в ЗАО",
                        "Переезд",
                        JOptionPane.PLAIN_MESSAGE);
                mouse_prev_position[0] = 2;
            }
        });

        south.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouse_prev_position[0] == 3) return;
                JOptionPane.showMessageDialog(getContentPane(),
                        "Добро пожаловать в ЮАО",
                        "Переезд",
                        JOptionPane.PLAIN_MESSAGE);
                mouse_prev_position[0] = 3;
            }
        });

        north.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouse_prev_position[0] == 4) return;
                JOptionPane.showMessageDialog(getContentPane(),
                        "Добро пожаловать в САО",
                        "Переезд",
                        JOptionPane.PLAIN_MESSAGE);
                mouse_prev_position[0] = 4;
            }
        });

        east.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouse_prev_position[0] == 5) return;
                JOptionPane.showMessageDialog(getContentPane(),
                        "Добро пожаловать в ВАО",
                        "Переезд",
                        JOptionPane.PLAIN_MESSAGE);
                mouse_prev_position[0] = 5;
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Areas().setVisible(true));
    }

}
