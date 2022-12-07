package ru.alex0d.java.practice22.task2;

public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorUI view = new CalculatorUI();
        CalculatorController controller = new CalculatorController(model, view);

        controller.initController();
    }
}
