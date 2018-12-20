/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode.bvjniot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author omkarkamate
 */
public class SqliteConnection {
    public static Connection Connector(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con=DriverManager.getConnection("jdbc:sqlite:chinook.db");  
            return con;
        } catch (Exception ex) {
            Logger.getLogger(SqliteConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
}
