package ru.alex0d.java.practice9_10;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Student> students = setArray(7);
        shuffleArray(students);

        System.out.println("Before sorting:");
        outArray(students);

        System.out.println("\nAfter selectionSort by GPA (default):");
        SortAlgorithms.selectionSort(students);
        outArray(students);

        System.out.println("\nAfter selectionSort by name:");
        SortAlgorithms.selectionSort(students,
                Comparator.comparing(Student::getName));
        outArray(students);

        shuffleArray(students);
        System.out.println("\nAfter quickSort by GPA (default):");
        SortAlgorithms.quickSort(students, 0, students.size() - 1);
        outArray(students);

        System.out.println("\nAfter quickSort by name:");
        SortAlgorithms.quickSort(students, 0, students.size() - 1,
                Comparator.comparing(Student::getName));
        outArray(students);

        shuffleArray(students);
        System.out.println("\nAfter mergeSort by GPA (default):");
        SortAlgorithms.mergeSort(students, 0, students.size() - 1);
        outArray(students);

        System.out.println("\nAfter mergeSort by name:");
        SortAlgorithms.mergeSort(students, 0, students.size() - 1,
                Comparator.comparing(Student::getName));
        outArray(students);
    }

    public static ArrayList<Student> setArray(int n) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student("Name " + i,
                    "Surname " + i,
                    "Specialization " + i,
                    i,
                    "Group " + i,
                    BigDecimal.valueOf(Math.random() * 100)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue()));
        }
        return students;
    }

    public static void shuffleArray(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            int randomIndexToSwap = (int) (Math.random() * students.size());
            Student temp = students.get(randomIndexToSwap);
            students.set(randomIndexToSwap, students.get(i));
            students.set(i, temp);
        }
    }

    public static void outArray(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
