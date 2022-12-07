package ru.alex0d.java.practice29;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        Order restaurantOrder = new RestaurantOrder();
        restaurantOrder.add(new Dish(100, "Тарелка", "Очень хорошая тарелка. Всем тарелкам тарелка"));
        restaurantOrder.add(new Dish(70, "Кружка", "Пить же надо"));
        restaurantOrder.add(new Drink(400, "Чай", "Чай зеленый"));
        restaurantOrder.add(new Drink(300, "Томатный сок", "Никто не берёт... Но тут взяли"));
        int table = 4;

        System.out.println("Заказ к столу №" + table + ":");
        for (Item item : restaurantOrder.getSortedArray()) {
            System.out.println(item.getName() + " - " + item.getCost() + " руб." + " - " + item.getDescription());
        }
        System.out.println("Количество позиций в заказе: " + restaurantOrder.getCount());
        System.out.println("Стоимость заказа: " + restaurantOrder.getCost() + " руб.");

        try {
            orderManager.add(restaurantOrder, table);
            System.out.println("Заказ к столу №" + table + " добавлен в систему");
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------");

        Order internetOrder = new InternetOrder();
        internetOrder.add(new Dish(70, "Блюдце", "Очень хорошее блюдце. Всем блюдцам блюдце"));
        internetOrder.add(new Drink(500, "Кофе", "Все пьют. Хороший кофе"));
        String address = "ул. Ленина, д. 1";

        System.out.println("Интернет заказ по адресу " + address + ":");
        for (Item item : internetOrder.getSortedArray()) {
            System.out.println(item.getName() + " - " + item.getCost() + " руб." + " - " + item.getDescription());
        }
        System.out.println("Количество позиций в заказе: " + internetOrder.getCount());
        System.out.println("Стоимость заказа: " + internetOrder.getCost() + " руб.");

        try {
            orderManager.add(internetOrder, address);
            System.out.println("Интернет заказ по адресу " + address + " добавлен в систему");
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------");

        // Пробуем добавить заказ к столу №4, который уже есть в системе
        try {
            orderManager.add(restaurantOrder, table);
            System.out.println("Заказ к столу №" + table + " добавлен в систему");
        } catch (OrderAlreadyAddedException e) {
            System.out.println(e.getMessage());
        }

    }
}
