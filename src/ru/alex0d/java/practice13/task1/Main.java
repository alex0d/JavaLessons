package ru.alex0d.java.practice13.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter any string: ");
        String userString = scanner.nextLine();
        ex1(userString);
        System.out.println(ex2(userString));
        System.out.println(ex3(userString));
        System.out.println(ex4(userString));
        System.out.println(ex5(userString));
        System.out.println(ex6(userString));
        System.out.println(ex7(userString));
        System.out.println(ex8(userString));
        System.out.println(ex9(userString));
        System.out.println(ex10(userString));

    }

    public static void ex1(String str){
        System.out.println(str);
    }

    public static Character ex2(String str){
        return str.charAt(str.length()-1);
    }

    public static boolean ex3(String str){
        return str.endsWith("!!!");
    }

    public static boolean ex4(String str){
        return str.startsWith("I like");
    }

    public static boolean ex5(String str){
        return str.contains("Java");
    }

    public static int ex6(String str){
        return str.indexOf("Java");
    }

    public static String ex7(String str){
        return str.replace('a', 'o');
    }

    public static String ex8(String str){
        return str.toUpperCase();
    }

    public static String ex9(String str){
        return str.toLowerCase();
    }

    public static String ex10(String str){
        return str.substring(str.indexOf("Java"), str.indexOf("Java") + 4);
    }
}
