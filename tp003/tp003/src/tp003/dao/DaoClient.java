/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp003.models.Client;

/**
 *
 * @author WBVC0932
 */
public class DaoClient extends DAO<Client> {
    public DaoClient(Connection conn) {
        super(conn);
    }
    @Override
    public boolean create(Client t) {
        try {
            String strSql="INSERT INTO CLIENTS (nom,prenom,adresse) VALUES ('"
                    +t.getNom()+"','"+t.getPrenom()+
                    "','"+t.getAdresse()+"')";
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public Client findById(int id) {
        try {
            Statement stm= this.connect.createStatement();
            ResultSet rst=stm.executeQuery("SELECT * FROM CLIENTS WHERE ID="+id);
             Client client=new Client();
        try {
        while(rst.next()) {
            client.setId(rst.getInt("id"));
            client.setNom(rst.getString("nom"));
            client.setPrenom(rst.getString("prenom"));
            client.setAdresse(rst.getString("adresse"));
        }
        } catch (Exception ex ) {
             System.out.println(ex.getMessage());
        }
        return client;
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<Client> findAll() {
        List<Client>  lst = new ArrayList<Client>();
        try {
            Statement stm= this.connect.createStatement();
            ResultSet rst =stm.executeQuery("SELECT * FROM CLIENTS ");
            while(rst.next()) {
            Client client=new Client();
            client.setId(rst.getInt("id"));
            client.setNom(rst.getString("nom"));
            client.setPrenom(rst.getString("prenom"));
            client.setAdresse(rst.getString("adresse"));
            lst.add(client);
        }
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public boolean update(Client t) {
        try {
            String strSql="UPDATE CLIENTS SET nom='"+t.getNom()+"', prenom="
                    +t.getPrenom()+"', adresse='"+t.getAdresse()+"'";
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        try {
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate("DELETE FROM CLIENTS WHERE ID="+id);
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return false;
    }
    
    
}
