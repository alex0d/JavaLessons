package ru.alex0d.java.practice9_10;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private String specialization;
    private int course;
    private String group;

    private double GPA;

    public Student(String name, String surname, String specialization, int course, String group, double GPA) {
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.course = course;
        this.group = group;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialization='" + specialization + '\'' +
                ", course=" + course +
                ", group=" + group +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getGPA)
                .reversed()
                .compare(this, o);
    }
}
