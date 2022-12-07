package ru.alex0d.java.practice29;

public class IllegalAddress extends Error{
    public IllegalAddress(String address){
        super("Неверный адрес: " + address);
    }
}
