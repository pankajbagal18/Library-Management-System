<%-- 
    Document   : successGreeting
    Created on : 03-May-2020, 8:38:43 PM
    Author     : pankaj
--%>

<%@page import="com.devpanks.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Management System</title>
    </head>
    <%
        User currentUser = (User)request.getAttribute("CURRENT_USER");
    %>
    <body>
        <h1>(Library Management System) : Greeting to the user</h1>
        <h3>
            Welcome <%=currentUser.getFirstName()%>
        </h3>
        <br/>
        <p>Click <a href="logoutServlet">here</a> to logout</p>
    </body>
</html>
