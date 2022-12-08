package ru.alex0d.java.practice27.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> people = createMap();

        System.out.println("Дублирующиеся имена: ");
        for (Map.Entry<String, Integer> entry : getSameFirstNameCount(people).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Сидор");
        map.put("Смирнов", "Сергей");
        map.put("Алексеев", "Иван");
        map.put("Федоров", "Петр");
        map.put("Сергеев", "Сергей");
        return map;
    }

    public static Map<String, Integer> getSameFirstNameCount(Map<String, String> map) {
        Map<String, Integer> duplicates = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (duplicates.containsKey(entry.getValue())) {
                duplicates.put(entry.getValue(), duplicates.get(entry.getValue()) + 1);
            } else {
                duplicates.put(entry.getValue(), 1);
            }
        }

        // Удаляем все элементы, у которых значение 1
        ArrayList<String> keysToRemove = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
            if (entry.getValue() == 1) {
                keysToRemove.add(entry.getKey());
            }
        }

        for (String key : keysToRemove) {
            duplicates.remove(key);
        }

        return duplicates;
    }
}
