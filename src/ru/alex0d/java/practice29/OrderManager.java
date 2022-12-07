package ru.alex0d.java.practice29;

import java.util.HashMap;

public class OrderManager {
    HashMap<Integer, Object> restaurantOrders = new HashMap<>();
    HashMap<String, Object> internetOrders = new HashMap<>();

    public void add(Order order, int table) throws OrderAlreadyAddedException {
        if (restaurantOrders.containsKey(table)) {
            throw new OrderAlreadyAddedException(Integer.toString(table));
        } else {
            restaurantOrders.put(table, order);
        }
    }

    public void addPosition(Item item, int table){
        if (restaurantOrders.containsKey(table)){
            Order order = (Order) restaurantOrders.get(table);
            order.add(item);
            restaurantOrders.replace(table,order);
        }
        else {
            throw new IllegalAddress(Integer.toString(table));
        }
    }

    public Object getOrder(int table){
        return restaurantOrders.get(table);
    }


    public void removeOrder(int table){
        restaurantOrders.remove(table);
    }

    public HashMap orders(){
        return restaurantOrders;
    }


    public void add(Order order, String address) throws OrderAlreadyAddedException {
        if (internetOrders.containsKey(address))
            throw new OrderAlreadyAddedException(address);
        else internetOrders.put(address, order);
    }

    public void addPosition(Item item, String  address) throws IllegalAddress {
        if (internetOrders.containsKey(address)){
            Order order = (Order) internetOrders.get(address);
            order.add(item);
            internetOrders.replace(address,order);
        }
        else{
            throw new IllegalAddress(address);
        }
    }


    public Object getOrder(String address){
        return internetOrders.get(address);
    }

    public void removeOrderInternet(String address){
        internetOrders.remove(address);
    }

    public HashMap getInternetOrder(){
        return internetOrders;
    }
}
