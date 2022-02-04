/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WBVC0932
 */
public class DBConnection {
    private static Connection con = null;

    static Connection getIntance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public DBConnection() {
        try {
            //Chargement de notre driver
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/tp0002",
                            "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static Connection getInstance() {
        if (null == con) {
            new DBConnection();
        }
        return con;
    }
}
