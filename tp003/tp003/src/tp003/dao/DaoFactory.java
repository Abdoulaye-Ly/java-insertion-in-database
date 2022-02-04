/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.dao;

import java.sql.Connection;

/**
 *
 * @author ENVYHP
 */
public class DaoFactory {
    private static final Connection 
            conn = DBConnection.getInstance();
    public static DAO getDaoClient(){
        return new DaoClient (conn);
    }
    public  static DAO grtCompte(){
       return new DaoCompte (conn);
    }
    
}
