<%-- 
    Document   : addUser
    Created on : 04-May-2020, 9:45:06 AM
    Author     : pankaj
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
    </head>
    <body>
        <h1>Library Management System</h1>
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
        <form action="AddUserServletPath" method="POST">
            First Name : <input type="text" name="firstName" size="20"><br/>
            Surname : <input type="text" name="surname" size="20"><br/>
            Age : <input type="number" name="age" min="18" size="20"><br/>
            Gender(M/F) : <input type="text" name="gender" size="20"><br/>
            E-mail address : <input type="email" name="email" size="20"><br/>
            Username : <input type="text" name="username" size="20"><br/>
            Password : <input type="password" name="password" size="20">
            <br/>
            <br/>
            <input type="submit" value="Sign Up">
        </form>
    </body>
</html>
