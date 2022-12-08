package ru.alex0d.java.practice29;

public class OrderAlreadyAddedException extends Exception{
    public OrderAlreadyAddedException(String address){
        super("Заказ к столу / по адресу " + address + " уже добавлен! Заказ не может быть добавлен дважды.");
    }
}