package ru.alex0d.java.practice14;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 1");
        System.out.println("Введите строку для разбиения: ");
        String task1String = scanner.nextLine();
        System.out.println(task1(task1String));

        System.out.println("\nЗадание 2");
        String task2String1 = "abcdefghijklmnopqrstuv18340";
        String task2String2 = "dfdgdf";
        System.out.printf("Является ли строка %s строкой %s?: %s\n", task2String1, task2String1, task2(task2String1));
        System.out.printf("Является ли строка %s строкой %s?: %s\n", task2String2, task2String1, task2(task2String2));

        System.out.println("\nЗадание 3");
        String task3String = "25.98 RUB";
        String task3String2 = "0.004 RRRR";
        System.out.printf("Корректна ли строка %s?: %s\n", task3String, task3(task3String));
        System.out.printf("Корректна ли строка %s?: %s\n", task3String2, task3(task3String2));

        System.out.println("\nЗадание 4");
        String task4String = "(1 + 8) - 9 / 4";
        String task4String2 = "6 / 5 - 2 * 9";
        System.out.printf("Есть ли в тексте %s цифры, за которыми стоит '+'?: %s\n", task4String, task4(task4String));
        System.out.printf("Есть ли в тексте %s цифры, за которыми стоит '+'?: %s\n", task4String2, task4(task4String2));

        System.out.println("\nЗадание 5");
        String task5String1 = "29/02/2000";
        String task5String2 = "56/04/2003";
        System.out.printf("Строка %s в формте dd/mm/yyyy?: %s\n", task5String1, task5(task5String1));
        System.out.printf("Строка %s в формте dd/mm/yyyy?: %s\n", task5String2, task5(task5String2));

        System.out.println("\nЗадание 6");
        String task6String1 = "user@example.com";
        String task6String2 = "userexample.com";
        System.out.printf("Строка %s является email?: %s\n", task6String1, task6(task6String1));
        System.out.printf("Строка %s является email?: %s\n", task6String2, task6(task6String2));

        System.out.println("\nЗадание 7");
        String task7String1 = "F032_Password";
        String task7String2 = "smart_pass";
        System.out.printf("Строка %s - надежный пароль?: %s\n", task7String1, task7(task7String1));
        System.out.printf("Строка %s - надеждный пароль?: %s\n", task7String2, task7(task7String2));

        System.out.println("\nЗадание 8");
        String[] task8StringArray = new String[]{"first", "second", "toDelete", "third", "toDelete", "fourth"};
        System.out.println("Применение фильтра !equals('toDelete') к массиву " + Arrays.toString(task8StringArray));
        System.out.println(Arrays.toString(task8(task8StringArray)));

        System.out.println("\nЗадание 9");
        String task9String = "abcdefghijklmnopqrstuvwxyzabcabcghjk";
        System.out.printf("Частота букв в строке %s:\n%s\n", task9String, task9(task9String));
    }

    public static ArrayList<String> task1(String str){
        return new ArrayList<>(Arrays.asList(str.split(" ")));
    }

    public static boolean task2(String str){
        return str.matches("abcdefghijklmnopqrstuv18340");
    }

    public static boolean task3(String str){
        return str.matches("^[0-9]{1,}.[0-9]{1,2}\\s(USD|RUB|EU)");
    }


    public static boolean task4(String str){
        return str.matches(".*(\\+)\\s*[0-9]{1,}.*");
    }

    public static boolean task5(String str){
        return str.matches("(0[1-9]|[12][0-9]|3[01])[/](0[13578]|1[02])[/](([0-9]{2})[0-9]{2})|0[1-9]|[12][0-9]|30[/](0[469]|11)[/](([0-9]{2})[0-9]{2})|(0[1-9]|1[0-9]|2[0-8])[/](02)[/](([0-9]{2})[0-9]{2})|29[/](02)[/]((([0-9]{2})(04|08|[2468][048]|[13579][26]))|2000|1000)");
    }

    public static boolean task6(String str){
        return str.matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)(|(\\.([a-zA-Z]{2,5})))$");
    }

    public static boolean task7(String str){
        return str.matches("^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d).*");
    }

    public static String[] task8(String[] array){
        return (String[])filter(array, o -> !o.equals("toDelete"));
    }

    public static Object[] filter(Object[] array, Filter filter) {
        int deletedCount = 0;
        for(int i = 0; i< array.length; i++){
            if(!filter.apply(array[i])){
                deletedCount++;
            } else{
                array[i - deletedCount] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length - deletedCount);
    }

    interface Filter {
        boolean apply(Object o);
    }

    public static Map<String, Integer> task9(String str){
        Map<String, Integer> dictionary = new HashMap<>();
        for(int i = 97; i < 123; i++){
            Pattern pattern = Pattern.compile(Character.toString((char)i));
            Matcher matcher = pattern.matcher(str);
            int count = 0;
            while(matcher.find()) {
                count++;
            }
            dictionary.put(Character.toString((char)i), count);
        }
        return dictionary;
    }
}
