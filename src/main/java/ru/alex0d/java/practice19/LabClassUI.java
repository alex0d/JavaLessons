package ru.alex0d.java.practice19;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class LabClassUI extends JFrame {
    ArrayList<Student> students;

    public LabClassUI(ArrayList<Student> students){
        super("LabClassUI");
        setSize(1000,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.students = students;

        JPanel panelMain = new JPanel(new FlowLayout());

        JButton btnAddStudent = new JButton("Добавить");
        JButton btnRemoveStudent = new JButton("Удалить");
        JButton btnFindStudent = new JButton("Найти");

        panelMain.add(btnAddStudent);
        panelMain.add(btnRemoveStudent);
        panelMain.add(btnFindStudent);

        Object[] headers = new String[] {"Имя", "Фамилия", "Специальность", "Курс", "Группа", "Оценка"};
        Object [][] arStudents = new String[students.size()][6];

        for(int i = 0; i < students.size(); i++){
            arStudents[i][0] = students.get(i).getName();
            arStudents[i][1] = students.get(i).getSurname();
            arStudents[i][2] = students.get(i).getSpeciality();
            arStudents[i][3] = students.get(i).getCourse().toString();
            arStudents[i][4] = students.get(i).getGroup();
            arStudents[i][5] = students.get(i).getGPAScore().toString();
        }


        JTable tableStudents = new JTable(new DefaultTableModel(arStudents, headers)){
            @Override
            public boolean isCellEditable(int x, int y){
                return false;
            }
        };

        JTableHeader header = tableStudents.getTableHeader();
        header.setReorderingAllowed(false);

        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int col = tableStudents.columnAtPoint(e.getPoint());
                    String name = tableStudents.getColumnName(col);
                    switch (name) {
                        case "Имя" -> students.sort(Comparator.comparing(Student::getName));
                        case "Фамилия" -> students.sort(Comparator.comparing(Student::getSurname));
                        case "Специальность" -> students.sort(Comparator.comparing(Student::getSpeciality));
                        case "Курс" -> students.sort(Comparator.comparing(Student::getCourse));
                        case "Группа" -> students.sort(Comparator.comparing(Student::getGroup));
                        case "Оценка" -> students.sort(Comparator.comparing(Student::getGPAScore));
                    }
                    updateTable(tableStudents);
                }
                else if (e.getClickCount() == 2) {
                    int col = tableStudents.columnAtPoint(e.getPoint());
                    String name = tableStudents.getColumnName(col);
                    switch (name) {
                        case "Имя" -> students.sort(Comparator.comparing(Student::getName).reversed());
                        case "Фамилия" -> students.sort(Comparator.comparing(Student::getSurname).reversed());
                        case "Специальность" -> students.sort(Comparator.comparing(Student::getSpeciality).reversed());
                        case "Курс" -> students.sort(Comparator.comparing(Student::getCourse).reversed());
                        case "Группа" -> students.sort(Comparator.comparing(Student::getGroup).reversed());
                        case "Оценка" -> students.sort(Comparator.comparing(Student::getGPAScore).reversed());
                    }
                    updateTable(tableStudents);
                }
            }
        });

        btnAddStudent.addActionListener(e -> {
            try{
                addStudent(tableStudents);
            }catch (IllegalArgumentException exception){
                JOptionPane.showMessageDialog(panelMain, exception.getMessage());
            }
        });

        btnRemoveStudent.addActionListener(e -> removeStudent(tableStudents));

        btnFindStudent.addActionListener(e -> {
            try{
                findStudent();
            } catch (StudentNotFoundException ex){
                JOptionPane.showMessageDialog(getContentPane(), ex.getMessage());
            }
        });

        add(new JScrollPane(tableStudents), BorderLayout.CENTER);

        add(panelMain, BorderLayout.NORTH);
    }


    private void updateTable(JTable tableStudents){
        DefaultTableModel dtm = (DefaultTableModel) tableStudents.getModel();

        for (int i = 0; i < students.size(); i++) {
            dtm.removeRow(i);
            Student student = students.get(i);
            dtm.insertRow(i, new Object[]{student.getName(), student.getSurname(), student.getSpeciality(), student.getCourse(), student.getGroup(), student.getGPAScore()});
        }
    }

    private void findStudent() throws StudentNotFoundException {
        String s = JOptionPane.showInputDialog("Введите фамилию");
        Student[] students = this.students.stream().filter(student -> student.getSurname().equals(s)).toArray(Student[]::new);
        if(students.length == 0) {
            throw new StudentNotFoundException();
        }
        else if (students.length == 1) {
            JOptionPane.showMessageDialog(getContentPane(), students[0].toString());
        } else {
            String[] names = new String[students.length];
            for (int i = 0; i < students.length; i++) {
                names[i] = students[i].getName();
            }
            String name = (String) JOptionPane.showInputDialog(getContentPane(), "Найдено несколько студентов\nВыберите имя", "Выбор имени", JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
            students = this.students.stream().filter(student -> student.getName().equals(name)).toArray(Student[]::new);
            if (students.length == 0) {
                throw new StudentNotFoundException();
            } else {
                JOptionPane.showMessageDialog(getContentPane(), students[0].toString());
            }
        }
    }

    private void removeStudent(JTable studTable) {
        int selectedRowCount = studTable.getSelectedRowCount();
        if (selectedRowCount == 0) {
            JOptionPane.showMessageDialog(this, "Выделите студетов, которых хотите отчислить", "Отчисление", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int selectedRow = studTable.getSelectedRow();
        while (selectedRowCount > 0) {
            students.remove(selectedRow);
            ((DefaultTableModel) studTable.getModel()).removeRow(selectedRow);
            selectedRowCount--;
        }
    }

    private void addStudent(JTable tableStudents) throws IllegalArgumentException {
        String name = JOptionPane.showInputDialog("Введите имя студента");
        if (name == null || name.equals("")) {
            throw new EmptyStringException("Имя не может быть пустым");
        }
        String surname = JOptionPane.showInputDialog("Введите фамилию студента");
        if (surname == null || surname.equals("")) {
            throw new EmptyStringException("Фамилия не может быть пустой");
        }

        String speciality = JOptionPane.showInputDialog("Введите специальность студента");
        if (speciality == null || speciality.equals("")) {
            throw new EmptyStringException("Специальность не может быть пустой");
        }

        String course = JOptionPane.showInputDialog("Введите курс студента");
        if (course == null || course.equals("")) {
            throw new IllegalArgumentException("Курс не может быть пустым");
        }
        if (!course.matches("[1-4]")) {
            throw new IllegalArgumentException("Курс должен быть числом от 1 до 4");
        }

        String group = JOptionPane.showInputDialog("Введите группу студента");
        if (group == null || group.equals("")) {
            throw new IllegalArgumentException("Группа не может быть пустой");
        }

        String gpa = JOptionPane.showInputDialog("Введите средний балл студента");
        if (gpa == null || gpa.equals("")) {
            throw new IllegalArgumentException("Средний балл не может быть пустым");
        }
        if (!gpa.matches("[1-5]")) {
            throw new IllegalArgumentException("Средний балл должен быть числом от 1 до 5");
        }

        students.add(new Student(name, surname, speciality, Integer.parseInt(course), group, Double.parseDouble(gpa)));
        DefaultTableModel dtm = (DefaultTableModel) tableStudents.getModel();
        dtm.addRow(new Object[]{name, surname, speciality, Integer.parseInt(course), group, Double.parseDouble(gpa)});
    }

}
