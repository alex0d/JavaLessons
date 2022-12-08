package ru.alex0d.java.practice11.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате dd.MM.yyyy HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        String userDate = scanner.nextLine();

        Date dateUser;
        try {
            dateUser = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(userDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date dateProgram = new Date();
        if (dateUser.compareTo(dateProgram) == 0){
            System.out.println("Пользовательское время равно системному");
        }
        else if(dateUser.compareTo(dateProgram) > 0){
            System.out.println("Пользовательское время больше системного");
        }
        else{
            System.out.println("Пользовательское время меньше системного");
        }
    }
}
