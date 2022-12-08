package ru.alex0d.java.practice19;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(){
        super("Студент не найден");
    }

    public StudentNotFoundException(String message){
        super(message);
    }
}
