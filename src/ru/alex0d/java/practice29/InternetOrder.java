package ru.alex0d.java.practice29;

import java.util.ArrayList;
import java.util.Comparator;

public class InternetOrder implements Order{
    OrderList internetOrders;

    InternetOrder(){
        internetOrders = new OrderList();
    }

    public void getOrder(ArrayList<Item> order){
        for(Item item : order) internetOrders.add(item);
    }

    @Override
    public String[] getMenu(){
        String[] str = new String[internetOrders.size()];
        for (int i = 0; i < internetOrders.size(); i++){
            str[i] = internetOrders.get(i).getName() + " " + internetOrders.get(i).getDescription() + " " + internetOrders.get(i).getCost();
        }
        return str;
    }

    @Override
    public boolean add(Item item) {
        return internetOrders.add(item);
    }

    @Override
    public boolean remove(String name) {
        return internetOrders.remove(name);
    }

    @Override
    public int removeAll(String name) {
        int count = internetOrders.contains(name);
        while (internetOrders.contains(name) != 0) {
            remove(name);
        }
        return count;
    }

    @Override
    public int getCount() {
        return internetOrders.size();
    }

    @Override
    public ArrayList<Item> getArray() {
        return internetOrders.toArrayList();
    }

    @Override
    public int getCost() {
        ArrayList<Item> al = internetOrders.toArrayList();
        int total = 0;
        for (Item item : al) {
            total += item.getCost();
        }
        return total;
    }

    @Override
    public int getAmount(String name) {
        return internetOrders.contains(name);
    }

    @Override
    public ArrayList<Item> getSortedArray() {
        ArrayList<Item> al = internetOrders.toArrayList();
        al.sort(Comparator.comparing(Item::getCost));
        return al;
    }


}
