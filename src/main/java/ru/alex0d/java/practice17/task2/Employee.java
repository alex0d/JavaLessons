package ru.alex0d.java.practice17.task2;

public class Employee {
    String names;
    Integer hours;
    Integer payPerHour;

    public Integer getHourPayment() {
        return payPerHour;
    }

    public void setHourPayment(Integer payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getSalary(){
        return payPerHour * hours;
    }
}
