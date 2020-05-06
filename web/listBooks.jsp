<%-- 
    Document   : listBooks
    Created on : 06-May-2020, 8:40:59 AM
    Author     : pankaj
--%>

<%@page import="com.devpanks.datamodels.Book"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library View</title>
    </head>
    <body>
        <h1>Library Management System</h1>
        <h3>Welcome admin</h3>
        <%
            List<Book> listOfBooks = (List<Book>)request.getAttribute("listOfBooks");
            if(listOfBooks==null||listOfBooks.isEmpty()==true)
            {
            %>
            <p>No book is the library.</p>
            <%

            }
            else
            {
                %>
                <p>List Of Books</p>
                <%
                for(Book book:listOfBooks)
                {
                %>
                <p><%=book.toString()%></p>
                <%
                }
            }
        %>
    </body>
</html>
