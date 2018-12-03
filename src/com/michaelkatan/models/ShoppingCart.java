package com.michaelkatan.models;

import java.util.*;

public class ShoppingCart
{
    Map lines = new Hashtable();

    public void addProduct(Product product)
    {
        if(lines.get(product)==null)
        {
            lines.put(product, new ShoppingCartLine(product,1));
        }
        else
        {
            ShoppingCartLine line = (ShoppingCartLine)(lines.get(product));
            line.setQuantity(line.getQuantity()+1);
        }
    }

    public double getTotal()
    {
        double total = 0;
        Iterator iterator = lines.values().iterator();
        while(iterator.hasNext())
        {
            ShoppingCartLine line = (ShoppingCartLine)iterator.next();
            total += line.getQuantity() * line.getProduct().getPrice();
        }
        return total;
    }

    public String getXMLTable()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<table width=500><tr><th align=left>product</th><th align=left>price</th><th align=left>quantity</th><th align=left>total</th></tr>");
        Iterator iterator = lines.values().iterator();
        while(iterator.hasNext())
        {
            ShoppingCartLine line = (ShoppingCartLine)iterator.next();
            sb.append("<tr><td>"+line.getProduct().getName()+"</td>");
            sb.append("<td>"+line.getProduct().getPrice()+"</td>");
            sb.append("<td>"+line.getQuantity()+"</td>");
            sb.append("<td>"+line.getQuantity()*line.getProduct().getPrice()+"</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}

