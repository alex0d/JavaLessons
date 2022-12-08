package ru.alex0d.java.practice13.task3;

import java.util.StringTokenizer;

public class Address {
    String country;
    String region;
    String city;
    String street;
    String house;
    String building;
    String apartment;

    Address(String str, int iMethod) {
        switch (iMethod) {
            case 0 -> {
                String[] arAddresses = str.split(", ");
                country = arAddresses[0];
                region = arAddresses[1];
                city = arAddresses[2];
                street = arAddresses[3];
                house = arAddresses[4];
                building = arAddresses[5];
                apartment = arAddresses[6];
            }
            case 1 -> {
                StringTokenizer tokenizer = new StringTokenizer(str, ",.;");
                country = tokenizer.nextToken().trim();
                region = tokenizer.nextToken().trim();
                city = tokenizer.nextToken().trim();
                street = tokenizer.nextToken().trim();
                house = tokenizer.nextToken().trim();
                building = tokenizer.nextToken().trim();
                apartment = tokenizer.nextToken().trim();
            }
            default -> throw new IllegalStateException("Unexpected value: " + iMethod);
        }
    }

    @Override
    public String toString() {
        return "Country: " + country + "\n" +
                "Region: " + region + "\n" +
                "City: " + city + "\n" +
                "Street: " + street + "\n" +
                "House: " + house + "\n" +
                "Corpus: " + building + "\n" +
                "Apartment: " + apartment;
    }
}
