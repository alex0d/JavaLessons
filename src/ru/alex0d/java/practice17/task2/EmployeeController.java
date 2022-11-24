package ru.alex0d.java.practice17.task2;

public class EmployeeController {

    Employee model;
    EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name){
        model.setName(name);
    }

    public String getEmployeeName(String name){
        return model.getName();
    }

    public void setEmployeeHourPayment(Integer payment){
        model.setHourPayment(payment);
    }

    public void setEmployeeHours(Integer hours){
        model.setHours(hours);
    }

    public String getEmployeeHourPayment(){
        return model.getHourPayment().toString();
    }

    public String getEmployeeHours(){
        return model.getHours().toString();
    }

    public void updateView(){
        view.displayDataEmployee(model.getName(), model.getSalary().toString());
    }
}
