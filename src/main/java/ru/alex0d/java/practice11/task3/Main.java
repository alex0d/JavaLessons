package ru.alex0d.java.practice11.task3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        StudentWithBirthday student = new StudentWithBirthday("Aleksey",
                "Denisov",
                "Software engineering",
                2,
                "IKBO-01-21",
                5,
                new java.util.GregorianCalendar(2003, Calendar.FEBRUARY, 25));

        System.out.println(student.toString(SimpleDateFormat.getDateInstance(DateFormat.SHORT)));
        System.out.println(student.toString(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM)));
        System.out.println(student.toString(SimpleDateFormat.getDateInstance(DateFormat.LONG)));
        System.out.println(student.toString(SimpleDateFormat.getDateInstance(DateFormat.FULL)));
    }
}
