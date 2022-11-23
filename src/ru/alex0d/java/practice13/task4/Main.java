package ru.alex0d.java.practice13.task4;

public class Main {
    public static void main(String[] args) {
        String[] shirtStrings = new String[11];
        shirtStrings[0] = "S001,Black Polo Shirt,Black,XL";
        shirtStrings[1] = "S002,Black Polo Shirt,Black,L";
        shirtStrings[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirtStrings[3] = "S004,Blue Polo Shirt,Blue,M";
        shirtStrings[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirtStrings[5] = "S006,Black TShirt,Black,XL";
        shirtStrings[6] = "S007,White T-Shirt,White,XL";
        shirtStrings[7] = "S008,White T-Shirt,White,L";
        shirtStrings[8] = "S009,Green T-Shirt,Green,S";
        shirtStrings[9] = "S010,Orange T-Shirt,Orange,S";
        shirtStrings[10] = "S011,Maroon PoloShirt,Maroon,S";

        Shirt[] shirts = new Shirt[shirtStrings.length];
        for (int i = 0; i < shirtStrings.length; i++) {
            shirts[i] = new Shirt(shirtStrings[i]);
        }

        for (Shirt shirt : shirts) {
            System.out.println(shirt);
        }
    }
}
