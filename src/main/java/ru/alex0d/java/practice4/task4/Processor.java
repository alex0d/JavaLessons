package ru.alex0d.java.practice4.task4;

public class Processor {
    public enum ProcessorBrand {
        INTEL,
        AMD,
        ARM,
    }

    private final ProcessorBrand brand;

    public Processor(ProcessorBrand brand) {
        this.brand = brand;
    }

    public ProcessorBrand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "brand=" + brand +
                '}';
    }
}
