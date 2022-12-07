package ru.alex0d.java.practice19;

public class EmptyStringException extends IllegalArgumentException{
    public EmptyStringException(){
        super("Empty string not allowed");
    }

    public EmptyStringException(String message){
        super(message);
    }
}
