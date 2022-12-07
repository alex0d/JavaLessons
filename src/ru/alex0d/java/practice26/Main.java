package ru.alex0d.java.practice26;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("key1", "value1");
        hashTable.put("key2", "value2");
        hashTable.put("key3", "value3");

        System.out.println(hashTable.get("key1"));
        System.out.println(hashTable.get("key2"));
        System.out.println(hashTable.get("hehe"));

        hashTable.remove("key1");
        hashTable.remove("key2");

        System.out.println(hashTable.get("key1"));
        System.out.println(hashTable.get("key2"));
    }
}
