package com.michaelkatan.models;

import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private Map<Integer, Product> products;
    private static Inventory inventory = null;

    private Inventory() { }



    public Product addProduct(Product product)
    {
       return products.put(product.getId(),product);
    }

    public Iterator getProducts()
    {
        return products.values().iterator();
    }

    public Product getProduct(int id)
    {
        return products.get(new Integer(id));
    }


    public static Inventory getInventory()
    {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }


}
