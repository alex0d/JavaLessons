package ru.alex0d.java.practice13.task2;

public class Person {
    private String surname;
    private String name;
    private String patronymic;

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Person(String surname){
        this.surname = surname;
    }

    public String getSurnameNP() {
        if (name != null && patronymic != null) {
            return new StringBuilder(surname).append(" ")
                    .append(name.charAt(0)).append(". ")
                    .append(patronymic.charAt(0)).append(".")
                    .toString();
        } else if (name != null) {
            return new StringBuilder(surname).append(" ")
                    .append(name.charAt(0)).append(".")
                    .toString();
        } else {
            return surname;
        }
    }
}
