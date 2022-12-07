package ru.alex0d.java.practice24.task3;

public abstract class Document {
    protected String name = "";

    public abstract String getContent();

    public abstract void setContent(String content);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
