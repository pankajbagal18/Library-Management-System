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
public class AddUserServlet extends HttpServlet {





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
        
        boolean status = registerUser(request);
        if(status==true)
        {
            System.out.println("User successfully registered");
            RequestDispatcher rd = request.getRequestDispatcher("successGreeting.jsp");
            rd.forward(request, response);
        }
        else
        {
            List<String> errorLogs = new ArrayList<String>();
            errorLogs.add("User not registered!\n Try Again!");
            request.setAttribute("ERROR_LOGS", errorLogs);
            request.getRequestDispatcher("addUser.jsp").forward(request, response);
        }
    }

    private boolean registerUser(HttpServletRequest request) {
                
        String firstName = String.valueOf(request.getParameter("firstName"));
        String surname = String.valueOf(request.getParameter("surname"));
        int age = Integer.valueOf(request.getParameter("age"));
        String gender = String.valueOf(request.getParameter("gender"));
        String email = String.valueOf(request.getParameter("email"));
        String username = String.valueOf(request.getParameter("username"));
        String password = String.valueOf(request.getParameter("password"));
        
        String query  = "INSERT INTO Users VALUES(?,?,?,?,?,?,?)";
        Connection databaseConnection = MyConnection.getDatabaseConnection();
        if(databaseConnection==null)
        {
            System.out.println("connection not setup");
            return false;
        }
        else
        {
            PreparedStatement pst = null;
            try {
                pst = databaseConnection.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst==null)
            {
                System.out.println("statement not prepered");
                return false;
            }
            else
            {
                int rowsAffected = 0;
                try {
                    pst.setString(1, firstName);
                    pst.setString(2, surname);
                    pst.setInt(3, age);
                    pst.setString(4, gender);
                    pst.setString(5, email);
                    pst.setString(6, username);
                    pst.setString(7, password);
                    rowsAffected = pst.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(AddUserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   
                if(rowsAffected>0)
                {
                    User user = new User(firstName,surname,age,gender,email,username,password);
                    request.setAttribute("CURRENT_USER",user);
                }
                return rowsAffected>0;
            }
        }
    }

}
