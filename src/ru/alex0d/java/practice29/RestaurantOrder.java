package ru.alex0d.java.practice29;

import java.util.ArrayList;
import java.util.Comparator;

public class RestaurantOrder implements Order{
    OrderList restaurantOrders = new OrderList();

    @Override
    public String[] getMenu(){
        String[] str = new String[restaurantOrders.size()];
        for (int i = 0; i < restaurantOrders.size(); i++){
            str[i] = restaurantOrders.get(i).getName() + " " + restaurantOrders.get(i).getDescription() + " " + restaurantOrders.get(i).getCost();
        }
        return str;
    }

    @Override
    public boolean add(Item item) {
        return restaurantOrders.add(item);
    }

    @Override
    public boolean remove(String name) {
        return restaurantOrders.remove(name);
    }

    @Override
    public int removeAll(String name) {
        int count = restaurantOrders.contains(name);
        while (restaurantOrders.contains(name) != 0) {
            remove(name);
        }
        return count;
    }

    @Override
    public int getCount() {
        return restaurantOrders.size();
    }

    @Override
    public ArrayList<Item> getArray() {
        return restaurantOrders.toArrayList();
    }

    @Override
    public int getCost() {
        ArrayList<Item> al = restaurantOrders.toArrayList();
        int total = 0;
        for (Item item : al) {
            total += item.getCost();
        }
        return total;
    }

    @Override
    public int getAmount(String name) {
        return restaurantOrders.contains(name);
    }

    @Override
    public ArrayList<Item> getSortedArray() {
        ArrayList<Item> al = restaurantOrders.toArrayList();
        al.sort(Comparator.comparing(Item::getCost));
        return al;
    }
}
