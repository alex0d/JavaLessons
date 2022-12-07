package ru.alex0d.java.practice19;

public class Student{
    private String name;
    private String surname;
    private String speciality;
    private Integer course;
    private Double GPAScore;
    private String group;

    public Student(String name, String surname, String speciality, Integer course, String group, Double GPAScore) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.GPAScore = GPAScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String stGroup) {
        this.group = stGroup;
    }

    public Double getGPAScore() {
        return GPAScore;
    }

    public void setGPAScore(Double GPAScore) {
        this.GPAScore = GPAScore;
    }

    @Override
    public String toString(){
        return "Студент: " +
                name + ", " +
                surname + ", " +
                group + ", " +
                speciality + ", " +
                course + ", " +
               GPAScore;
    }
}
