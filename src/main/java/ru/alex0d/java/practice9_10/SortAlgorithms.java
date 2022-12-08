package ru.alex0d.java.practice9_10;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class SortAlgorithms {
    public static void selectionSort(ArrayList<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).compareTo(current) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, current);
        }
    }

    public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(students.get(j), current) > 0) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, current);
        }
    }

    public static void quickSort(ArrayList<Student> students, int low, int high) {
        if (students.size() == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Student baseStudent = students.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (students.get(i).compareTo(baseStudent) < 0) {
                i++;
            }

            while (students.get(j).compareTo(baseStudent) > 0) {
                j--;
            }

            if (i <= j) {
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(students, low, j);

        if (high > i)
            quickSort(students, i, high);
    }

    public static void quickSort(ArrayList<Student> students, int low, int high, Comparator<Student> comparator) {
        if (students.size() == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Student baseStudent = students.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(students.get(i), baseStudent) < 0) {
                i++;
            }

            while (comparator.compare(students.get(j), baseStudent) > 0) {
                j--;
            }

            if (i <= j) {
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(students, low, j, comparator);

        if (high > i)
            quickSort(students, i, high, comparator);
    }

    public static void mergeSort(ArrayList<Student> students, int low, int high) {
        if (students.size() <= 1)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        mergeSort(students, low, middle);
        mergeSort(students, middle + 1, high);
        merge(students, low, middle, high);
    }

    public static void mergeSort(ArrayList<Student> students, int low, int high, Comparator<Student> comparator) {
        if (students.size() <= 1)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        mergeSort(students, low, middle, comparator);
        mergeSort(students, middle + 1, high, comparator);
        merge(students, low, middle, high, comparator);
    }

    private static void merge(ArrayList<Student> students, int low, int middle, int high) {
        ArrayList<Student> left = new ArrayList<>();
        ArrayList<Student> right = new ArrayList<>();

        for (int i = low; i <= middle; i++) {
            left.add(students.get(i));
        }

        for (int i = middle + 1; i <= high; i++) {
            right.add(students.get(i));
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                students.set(k, left.get(i));
                i++;
            } else {
                students.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            students.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            students.set(k, right.get(j));
            j++;
            k++;
        }
    }

    static void merge(ArrayList<Student> students, int low, int middle, int high, Comparator<Student> comparator) {
        ArrayList<Student> left = new ArrayList<>();
        ArrayList<Student> right = new ArrayList<>();

        for (int i = low; i <= middle; i++) {
            left.add(students.get(i));
        }

        for (int i = middle + 1; i <= high; i++) {
            right.add(students.get(i));
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                students.set(k, left.get(i));
                i++;
            } else {
                students.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            students.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            students.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
