<%-- 
    Document   : index
    Created on : 03-May-2020, 8:31:13 PM
    Author     : pankaj
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
        <p>
            Welcome to library management system
        </p>
        <a href="visitorHomePage.jsp">Visitor Home Page</a>
        <br/>
        <br/>
        <%
            if(request.getAttribute("ERROR_LOGS")!=null)
            {
            %>
            <div>
                <%="Please correct these errors!!"%>
            </div>
            <% 
                List<String> errorLogs = (List<String>)request.getAttribute("ERROR_LOGS");
                for(String errorMsg : errorLogs){
            %>
                     <%=errorMsg%>
            <%         
                }
            }
        %>
        <form action="GreetingServletPath" method="POST">
            Username : <input type="text" name="username" size="20"><br/>
            Password : <input type="password" name="password" size="20">
            <br/>
            <br/>
            <input type="submit" value="sign in">
        </form>
        <p>Not registered yet? Click<a href="addUser.jsp">here</a></p>
    



