/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpanks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pankaj
 * date : May 4, 2020
 */
public class MyConnection {

    /**
     *
     * @param databaseName
     * @return
     */
    
    public static Connection getDatabaseConnection(String databaseName)
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection databaseConnection=null;
        try {
            databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName+"?autoReconnect=true&useSSL=false", "pankaj","Pankaj@18");
        } catch (SQLException ex) {
            System.out.println("123");
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return databaseConnection;
    }

    public static Connection getDatabaseConnection() {
            return getDatabaseConnection("LibraryManagement");
    }
}
