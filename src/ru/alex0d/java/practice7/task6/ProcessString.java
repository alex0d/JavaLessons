package ru.alex0d.java.practice7.task6;

import ru.alex0d.java.practice7.task5.ProcessStringInterface;

public class ProcessString implements ProcessStringInterface {
    private String str;

    public ProcessString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public int countChars() {
        return str.length();
    }

    @Override
    public String replaceInOdd() {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 != 0) {
                chars[i] = ' ';
            }
        }
        return new String(chars);
    }

    @Override
    public String invert() {
        return new StringBuilder(str).reverse().toString();
    }
}
