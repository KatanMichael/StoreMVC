<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 12/3/2018
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Michael Store Of Junk!</title>
  </head>
  <body>
  <%
    RequestDispatcher dispatcher = application.getRequestDispatcher("/ControllerServlet");

    dispatcher.forward(request,response);
  %>
  </body>
</html>
