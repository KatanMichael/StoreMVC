package com.michaelkatan.models;

public class ShoppingCartLine
{
    private Product product;
    private int quantity;
    public ShoppingCartLine(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }
    public boolean equals(Object ob)
    {
        return this.product.equals(((ShoppingCartLine)ob).getProduct());
    }
    public Product getProduct()
    {
        return product;
    }
    public void setProduct(Product product)
    {
        this.product = product;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


}

