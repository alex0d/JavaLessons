package ru.alex0d.java.practice21.task4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        String PATH = "src\\ru\\alex0d\\java\\practice21\\";

        ArrayList<File> files = getFiles(PATH);
        files = new ArrayList<>(files.subList(0, min(files.size(), 5)));

        for (File file : files) {
            System.out.printf("-------- File: %s --------\n", file.getPath());
            System.out.println(readFile(file));
            System.out.printf("-------- End of file: %s --------\n\n", file.getPath());
        }
    }

    public static ArrayList<File> getFiles(String path) {
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            Stream<Path> paths = walk.filter(Files::isRegularFile);

            ArrayList<File> files = new ArrayList<>();
            paths.forEach(p -> files.add(p.toFile()));
            return files;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
