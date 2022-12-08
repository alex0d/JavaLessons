package ru.alex0d.java.practice24.task3;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    Document currentDocument;
    CreateDocument fabricDocument;

    public MainWindow() {
        super("Document editor");
        setSize(540,360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fabricDocument = new CreateTextDocument();
        currentDocument = fabricDocument.createNew("New document");
        setTitle(currentDocument.getName());

        JTextArea textArea = new JTextArea();

        add(textArea);

        JMenuBar menuBarMain = new JMenuBar();
        menuBarMain.setBackground(Color.WHITE);

        JMenu menuFile = new JMenu("File");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemExit = new JMenuItem("Exit");

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemExit);

        menuBarMain.add(menuFile);
        setJMenuBar(menuBarMain);

        itemNew.addActionListener(e -> {
            textArea.setText("");
            String newDocumentName = JOptionPane.showInputDialog("New document name");
            if (newDocumentName == null) {
                return;
            }
            currentDocument = fabricDocument.createNew(newDocumentName);
            setTitle(currentDocument.getName());
        });

        itemOpen.addActionListener(e ->{
            String documentName = JOptionPane.showInputDialog("Enter file name");
            if (documentName == null) {
                return;
            }
            currentDocument = fabricDocument.createOpen(documentName);
            if (currentDocument == null) {
                JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            textArea.setText(currentDocument.getContent());
            setTitle(currentDocument.getName());
        });

        itemSave.addActionListener( e -> {
            JOptionPane.showMessageDialog(getContentPane(), "Document '" + currentDocument.getName() + "' saved successfully");
            currentDocument.setContent(textArea.getText());
        });

        itemExit.addActionListener(e-> this.dispose());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
