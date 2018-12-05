<%@ page language="java" import="com.michaelkatan.models.*,java.util.*" contentType="text/html; charset=windows-1255"
         pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
    <title>ShoppingCart</title>
</head>
<body>
<h2>Shopping Cart</h2>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Inventory inventory = (Inventory)application.getAttribute("inventory");
    Product product = inventory.getProduct(id);

    if(session.getAttribute("cart")==null)
    {
        session.setAttribute("cart",new ShoppingCart());
    }

    ShoppingCart cart = (ShoppingCart)(session.getAttribute("cart"));

    cart.addProduct(product);

    out.println(cart.getXMLTable());

%>

<br>

<a href=store.jsp>back</a> <a href=payment.jsp>check out</a>

</body>
</html>