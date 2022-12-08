package ru.alex0d.java.practice25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String ipCheck1 = "127.0.0.1";  // true
        String ipCheck2 = "255.255.255.0";  // true

        String ipCheck3 = "1300.6.7.8";  // false
        String ipCheck4 = "abc.def.gha.bcd";  // false

        System.out.println("IP " + ipCheck1 + " is valid: " + isValidIP(ipCheck1));
        System.out.println("IP " + ipCheck2 + " is valid: " + isValidIP(ipCheck2));
        System.out.println("IP " + ipCheck3 + " is valid: " + isValidIP(ipCheck3));
        System.out.println("IP " + ipCheck4 + " is valid: " + isValidIP(ipCheck4));

        String parenthesesCheck1 = "(3*+*5)*–*9*×*4";  // true
        String parenthesesCheck2 = "((3*+*5)*–*9*×*4";  // false
        String parenthesesCheck3 = "((*(*)))";  // true

        System.out.println("Parentheses " + parenthesesCheck1 + " is valid: " + isValidParentheses(parenthesesCheck1));
        System.out.println("Parentheses " + parenthesesCheck2 + " is valid: " + isValidParentheses(parenthesesCheck2));
        System.out.println("Parentheses " + parenthesesCheck3 + " is valid: " + isValidParentheses(parenthesesCheck3));
    }

    public static boolean isValidIP(String str) {
        return str.matches("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    }

    public static boolean isValidParentheses(String str) {
        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher;
        while ((matcher = pattern.matcher(str)).find()) {
            str = matcher.replaceAll("");
        }
        return !(str.contains("(") || str.contains((")")));
    }
}
