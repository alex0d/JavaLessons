package ru.alex0d.java.practice11.task3;

import ru.alex0d.java.practice9_10.Student;

import java.text.DateFormat;
import java.util.Calendar;

public class StudentWithBirthday extends Student {
    private Calendar birthday;

    public StudentWithBirthday(String name, String surname, String specialization, int course, String group, double GPA, Calendar birthday) {
        super(name, surname, specialization, course, group, GPA);
        this.birthday = birthday;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String toString(DateFormat dateFormat) {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", specialization='" + getSpecialization() + '\'' +
                ", course=" + getCourse() +
                ", group=" + getGroup() +
                ", GPA=" + getGPA() +
                ", birthday=" + dateFormat.format(birthday.getTime()) +
                '}';
    }
}
