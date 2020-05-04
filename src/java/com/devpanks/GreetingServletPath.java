/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpanks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pankaj
 */
public class GreetingServletPath extends HttpServlet {

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String username = String.valueOf(request.getParameter("username"));
        String password = String.valueOf(request.getParameter("password"));
        User currentUser = null;
        List<String> errorLogs = new ArrayList<>();
        try {
            currentUser = checkValidUser(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(GreetingServletPath.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(currentUser==null)
        {
            errorLogs.add("Username or password incorrect");
            request.setAttribute("ERROR_LOGS", errorLogs);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        else
        {
            request.setAttribute("CURRENT_USER", currentUser);
            RequestDispatcher rd = request.getRequestDispatcher("successGreeting.jsp");
            rd.forward(request, response);
        }
    }


    private User checkValidUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM Users WHERE UserName=? and Password=?";
        Connection databaseConnection = MyConnection.getDatabaseConnection();
        if(databaseConnection==null)
            System.out.println("connection not setup");
        PreparedStatement pst = databaseConnection.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet res = pst.executeQuery();
        if(res.next()==true)
        {
            // Learn to use JPA
            return new User(
                    res.getString(1),
                    res.getString(2),
                    res.getInt(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7)
            );
        }
        else
        {
            return null;
        }
    }

}
