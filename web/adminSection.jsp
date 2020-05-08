<%-- 
    Document   : adminSection
    Created on : 04-May-2020, 8:12:30 PM
    Author     : pankaj
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Section</title>
    </head>
    <body>
        <h1>Welcome admin!</h1>
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
        <form action="AdminSection" method="GET">
            <input type="radio" name="menuselection" value="listBooks">List Books<br/>
            <input type="radio" name="menuselection" value="listBorrowedBooks">List Borrowed Books<br/>
            <input type="submit" value="submit"><br/>
        </form>
        <p>Click <a href="index.jsp">here</a>to logout.</p>
    </body>
</html>
