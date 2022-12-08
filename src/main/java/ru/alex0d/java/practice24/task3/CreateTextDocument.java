package ru.alex0d.java.practice24.task3;

import java.util.ArrayList;

public class CreateTextDocument implements CreateDocument {

    ArrayList<Document> fabricFiles = new ArrayList<>();

    public Document createNew(String name) {
        Document newDocument = new TextDocument(name);

        fabricFiles.add(newDocument);
        return newDocument;
    }


    public Document createOpen(String name) {
        for (Document document : fabricFiles) {
            if (document.getName().equals(name)) {
                return document;
            }
        }
        return null;
    }
}
