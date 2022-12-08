package ru.alex0d.java.practice16.task2_2;

import javax.swing.*;
import java.awt.*;

public class FontChanger extends JFrame {
    public FontChanger() {
        super("TextArea");
        setSize(350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuColors = new JMenu("Цвета");
        JMenu jMenuFonts = new JMenu("Шрифты");

        JMenuItem jMenuItemBlue = new JMenuItem("Синий");
        JMenuItem jMenuItemRed = new JMenuItem("Красный");
        JMenuItem jMenuItemBlack = new JMenuItem("Черный");

        JMenuItem jMenuItemTimes = new JMenuItem("Times New Roman");
        JMenuItem jMenuItemSans = new JMenuItem("MS Sans Serif");
        JMenuItem jMenuItemCourier = new JMenuItem("Courier New");

        jMenuColors.add(jMenuItemRed);
        jMenuColors.add(jMenuItemBlue);
        jMenuColors.add(jMenuItemBlack);

        jMenuFonts.add(jMenuItemTimes);
        jMenuFonts.add(jMenuItemSans);
        jMenuFonts.add(jMenuItemCourier);

        jMenuBar.add(jMenuColors);
        jMenuBar.add(jMenuFonts);

        this.setJMenuBar(jMenuBar);
        this.add(textArea, BorderLayout.CENTER);

        jMenuItemRed.addActionListener(e -> textArea.setForeground(Color.RED));

        jMenuItemBlue.addActionListener(e -> textArea.setForeground(Color.blue));

        jMenuItemBlack.addActionListener(e -> textArea.setForeground(Color.black));

        jMenuItemTimes.addActionListener(e -> textArea.setFont(new Font(jMenuItemTimes.getText(),Font.BOLD, 16)));

        jMenuItemCourier.addActionListener(e -> textArea.setFont(new Font(jMenuItemCourier.getText(),Font.BOLD, 16)));

        jMenuItemSans.addActionListener(e -> textArea.setFont(new Font(jMenuItemSans.getText(),Font.BOLD, 16)));

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FontChanger().setVisible(true));
    }
}
