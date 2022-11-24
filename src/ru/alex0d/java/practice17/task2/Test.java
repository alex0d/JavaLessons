package ru.alex0d.java.practice17.task2;

public class Test {
    public static void main(String[] args) {
        Employee model = retrieveDataFromDatabase();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);

        controller.updateView();

        controller.setEmployeeHourPayment(5000);
        controller.updateView();
    }

    public static Employee retrieveDataFromDatabase(){
        Employee model = new Employee();
        model.setName("Alex");
        model.setHours(160);
        model.setHourPayment(1000);
        return model;
    }
}
