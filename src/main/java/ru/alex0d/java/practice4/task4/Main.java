package ru.alex0d.java.practice4.task4;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("MyComputer",
                new Processor(Processor.ProcessorBrand.INTEL),
                new Memory(Memory.MemoryBrand.KINGSTON),
                new Monitor(Monitor.MonitorBrand.LG));

        System.out.println(computer);
    }
}
