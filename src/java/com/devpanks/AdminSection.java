/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpanks;

import com.devpanks.datamodels.Book;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pankaj
 */
public class AdminSection extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menuSelection = request.getParameter("menuselection");
        List<String> errorLogs = new ArrayList<>();
        switch(menuSelection)
        {
            case "listBooks":
                List<Book> listOfBooks = listBooks();
                if(listOfBooks==null||listOfBooks.isEmpty()==true)
                {
                    errorLogs.add("Library is empty");
                }
                else
                {
                    request.setAttribute("listOfBooks", listOfBooks);
                    request.getRequestDispatcher("listBooks.jsp").forward(request, response);                    
                }
                break;
            case "listBorrowedBooks":
                break;
            default:
                errorLogs.add("Select Proper Function");
                break;
        }
        request.setAttribute("ERROR_LOGS",errorLogs);
        request.getRequestDispatcher("adminSection.jsp").forward(request, response);
    }

    private List<Book> listBooks() {
        Connection databaseConnection = MyConnection.getDatabaseConnection();
        String query = "SELECT * FROM Books";
        if(databaseConnection!=null)
        {
            PreparedStatement pst = null;
            try {   
                pst = databaseConnection.prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(AdminSection.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pst!=null)
            {
                ResultSet res = null;
                try {
                    res = pst.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminSection.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(res!=null)
                {
                    try {
                        List<Book> listOfBooks = new ArrayList<>();
                        while(res.next())
                        {
                            listOfBooks.add(new Book(
                                    res.getInt("Book_Id"),
                                    res.getString("BookName"),
                                    res.getString("Author"),
                                    res.getString("ISBN"),
                                    res.getInt("AvailableCopies"),
                                    res.getInt("TotalCopies")
                                )
                            );
                        }
                        return listOfBooks;
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminSection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return null;
    }

}
