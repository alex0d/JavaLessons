package ru.alex0d.java.practice4.task4;

public class Monitor {
    public enum MonitorBrand {
        SAMSUNG,
        LG,
        DELL,
        ASUS,
        ACER,
        HP,
        APPLE,
        BENQ,
        AOC,
        VIEWSONIC,
        PHILIPS,
        SONY,
    }

    private final MonitorBrand brand;

    public Monitor(MonitorBrand brand) {
        this.brand = brand;
    }

    public MonitorBrand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "brand=" + brand +
                '}';
    }
}
