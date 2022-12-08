package ru.alex0d.java.practice29;

import java.util.ArrayList;

public class OrderList {
    ListElement head = null;

    public int size(){
        if (head == null) {
            return 0;
        }

        int count = 0;
        ListElement tmp = head;
        while (tmp != null) {
            tmp = tmp.nextItem;
            count++;
        }
        return count;

    }

    public boolean add(Item item){
        if (head == null) {
            head = new ListElement(item, null);
        } else {
            ListElement tmp = head;
            while(tmp.nextItem != null) tmp = tmp.nextItem;
            tmp.nextItem = new ListElement(item, tmp);
        }
        return true;
    }

    public boolean remove(String name){
        ListElement tmp = head;
        if (head != null && head.item.getName().equals(name)){
            head = head.nextItem;
        }

        if (tmp == null) {
            return false;
        }

        while (tmp.nextItem != null && !tmp.item.getName().equals(name)) {
            tmp = tmp.nextItem;
        }

        if (tmp.nextItem != null && tmp.prevItem != null) {
            ListElement prev = tmp.prevItem;
            ListElement next = tmp.nextItem;
            prev.nextItem = tmp.nextItem;
            next.prevItem = tmp.prevItem;
        } else if(tmp.prevItem != null) {
            tmp.prevItem.nextItem = null;
        }

        return true;
    }

    public int contains(Item item){
        ListElement tmp = head;
        int count = 0;

        while(tmp != null)
            if (item.getCost() == tmp.item.getCost()
                    && item.getName().equals(tmp.item.getName())
                    && item.getDescription().equals(tmp.item.getDescription())) {
                count++;
                tmp = tmp.nextItem;
            }
            else
                tmp = tmp.nextItem;
        return count;
    }

    public int contains(String name){
        ListElement tmp = head;
        int count = 0;

        while(tmp != null)
            if (name.equals(tmp.item.getName())) {
                count++;
                tmp = tmp.nextItem;
            }
            else
                tmp = tmp.nextItem;
        return count;
    }

    public ArrayList<Item> toArrayList(){
        ArrayList<Item> result = new ArrayList<>();
        ListElement tmp = head;

        while (tmp != null){
            result.add(tmp.item);
            tmp = tmp.nextItem;
        }
        return result;
    }

    public Item get(int i){
        if (i > size()) return null;

        int count = 0;

        ListElement tmp = head;

        while(tmp != null && count++ != i) tmp = tmp.nextItem;

        return (tmp!= null) ?  tmp.item : null;
    }

    private static class ListElement {
        Item item;
        ListElement prevItem;
        ListElement nextItem;

        ListElement(Item item, ListElement parent){
            this.item = item;
            this.prevItem = parent;
        }
    }


}
