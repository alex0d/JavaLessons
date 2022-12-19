package ru.alex0d.java.practice4.task4;

public class Memory {
    public enum MemoryBrand {
        SAMSUNG,
        ADATA,
        KINGSTON,
        GSKILL,
        CORSAIR,
    }

    private final MemoryBrand brand;

    public Memory(MemoryBrand brand) {
        this.brand = brand;
    }

    public MemoryBrand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "brand=" + brand +
                '}';
    }
}
