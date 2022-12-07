package ru.alex0d.java.practice26;

public class HashTable {
    private final float loadFactor;  // коэффициент, при превышении которого происходит рехэширование
    private int capacity;  // размер массива
    private int size;  // количество элементов в таблице
    private Entry[] table;

    public HashTable() {
        this(16, 0.75f);
    }

    public HashTable(int capacity) {
        this(capacity, 0.75f);
    }

    public HashTable(int capacity, float loadFactor) {
        if (capacity <= 0 || loadFactor <= 0 || loadFactor >= 1) {
            throw new IllegalArgumentException("Illegal capacity or loadFactor");
        }
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = new Entry[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null");
        }
        if (size >= capacity * loadFactor) {
            resize();
        }
        int index = hash(key);
        Entry entry = table[index];
        if (entry == null) {
            table[index] = new Entry(key, value);
            size++;
        } else {
            while (entry.next != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new Entry(key, value);
                size++;
            }
        }
    }

    public String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null");
        }
        int index = hash(key);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must be not null");
        }
        int index = hash(key);
        Entry entry = table[index];
        if (entry == null) {
            return;
        }
        if (entry.key.equals(key)) {
            table[index] = entry.next;
            size--;
            return;
        }
        while (entry.next != null) {
            if (entry.next.key.equals(key)) {
                entry.next = entry.next.next;
                size--;
                return;
            }
            entry = entry.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        capacity *= 2;
        Entry[] oldTable = table;
        table = new Entry[capacity];
        for (Entry entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private static class Entry {
        private String key;
        private String value;
        private Entry next;  // указатель на следующий элемент (для реализации цепочек)

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
