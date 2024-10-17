package db;

import model.Item;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();

    private static int id = 6;


    static {
        items.add(new Item(1, "Mouse", "Computer mouse", 10));
        items.add(new Item(2, "Laptop", "Asus t1000", 1000));
        items.add(new Item(3, "Telephone", "Apple 16x Pro", 1500));
        items.add(new Item(4, "Telephone", "Samsung Galaxy x1000", 1000));
        items.add(new Item(5, "Comp", "Home computer", 2000));
    }

    public static void addItem(Item item){
        item.setId(id);
        id++;
        items.add(item);
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }
}
