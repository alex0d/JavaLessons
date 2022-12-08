package ru.alex0d.java.practice19;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иван", "Иванов", "Программная инженерия",2, "ИКБО-01-21",5d));
        students.add(new Student("Петр", "Петров", "Программная инженерия",2, "ИКБО-01-21",4.5d));
        students.add(new Student("Сидор", "Сидоров", "Программная инженерия",3, "ИКБО-30-20",4d));
        students.add(new Student("Андрей", "Андреев", "Прикладная математика",1, "ИМБО-02-22",3.5d));
        students.add(new Student("Алексей", "Алексеев", "Информатика и вычислительная техника",2, "ИВБО-01-21",1.1d));
        students.add(new Student("Александр", "Александров", "Программная инженерия",2, "ИКБО-01-21",2.5d));
        students.add(new Student("Антон", "Антонов", "Прикладная математика",3, "ИМБО-01-20",5d));
        students.add(new Student("Дмитрий", "Иванов", "Прикладная математика",4, "ИМБО-01-19",5d));
        students.add(new Student("Артем", "Артемов", "Программная инженерия",2, "ИКБО-01-21",1.5d));
        new LabClassUI(students).setVisible(true);
    }
}
