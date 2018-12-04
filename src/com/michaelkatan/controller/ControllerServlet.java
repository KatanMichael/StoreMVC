package com.michaelkatan.controller;

import com.michaelkatan.models.Inventory;
import com.michaelkatan.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ControllerServlet",
        urlPatterns = {"/controller","/store","/shoppingcart","/payment"})
public class ControllerServlet extends HttpServlet
{

    Inventory inventory = Inventory.getInventory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        inventory.addProduct(new Product(1,20.99,"Lenovo Yoga"));
        inventory.addProduct(new Product(2,26.99,"Asus ZenBook"));
        inventory.addProduct(new Product(3,20.99,"Dell Inspirion"));

        RequestDispatcher dispatcher = null;
        String requestUri = request.getRequestURI();


        if(requestUri.endsWith("shoppingcart"))
        {
            dispatcher = getServletContext().getRequestDispatcher("/shoppingCart.jsp");

        }

        else if(requestUri.endsWith("payment"))
        {
            dispatcher = getServletContext().getRequestDispatcher("/payment.jsp");
        }
        else
        {
            dispatcher = getServletContext().getRequestDispatcher("/store.jsp");
        }

        dispatcher.forward(request,response);

    }

}
