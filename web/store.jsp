<%@ page language="java" import="com.michaelkatan.models.*,java.util.*" contentType="text/html; charset=windows-1255"
         pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
    <title>Store</title>
</head>
<body>
<%
    if(application.getAttribute("inventory")==null)
    {


        application.setAttribute("inventory",Inventory.getInventory());
    }
%>
<h1>The Store!</h1>
<table>
    <tr><td>Product</td><td>Price</td><td>Buy</td></tr>
    <%
        Inventory inventory = (Inventory)(application.getAttribute("inventory"));
        Iterator iterator = inventory.getProducts();
        while(iterator.hasNext())
        {
            Product currentProduct = (Product)iterator.next();
            int id = currentProduct.getId();
            double price = currentProduct.getPrice();
            String name = currentProduct.getName();
    %>
    <tr><td><%= name %></td><td><%= String.valueOf(price) %></td><td><a href=shoppingCart.jsp?id=<%=String.valueOf(id)%>>buy</a></td></tr>
    <%
        }
    %>
</table>
</body>
</html>