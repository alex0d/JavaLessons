package ru.alex0d.java.practice24.task3;


public class TextDocument extends Document {
    private String content;

    public TextDocument(String name){
        this.name = name;
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String stContent) {
        this.content = stContent;
    }
}
