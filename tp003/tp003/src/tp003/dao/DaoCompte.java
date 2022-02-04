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
import tp003.models.Compte;

/**
 *
 * @author WBVC0932
 */
public class DaoCompte extends DAO<Compte>{

    public DaoCompte(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Compte t) {
        try {
            String strSql = "INSERT INTO COMPTES (numero,type,solde,client_id) VALUES ('"
                    + t.getNumero() + "','" + t.getType()
                    + "','" + t.getSolde() + "','" + t.getClient() + "')";
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate(strSql);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Compte findById(int id) {
        try {
            Statement stm= this.connect.createStatement();
            ResultSet rst=stm.executeQuery("SELECT * FROM COMPTES WHERE NUMERO='" + id + "'");
            Compte compte=new Compte();
        while(rst.next()) {
            //compte.setId(rst.getInt("id"));
            compte.setNumero(rst.getString("numero"));
            compte.setType(rst.getString("type"));
            compte.setSolde(rst.getDouble("solde"));
            compte.setClient(rst.getInt("client_id"));
        }
        return compte;
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Compte> findAll() {
         try {
            Statement stm= this.connect.createStatement();
            ResultSet rst=stm.executeQuery("SELECT * FROM COMPTES");
             List<Compte>  lst = new ArrayList<Compte>();
        while(rst.next()) {
              Compte compte=new Compte();
            //compte.setId(rst.getInt("id"));
            compte.setNumero(rst.getString("numero"));
            compte.setType(rst.getString("type"));
            compte.setSolde(rst.getDouble("solde"));
            compte.setClient(rst.getInt("client_id"));
            lst.add(compte);
        }
        return lst;
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Compte t) {
        try {
            String strSql = "UPDATE COMPTES set numero='"
                    + t.getNumero() + "',type="
                    + t.getType() + "',solde="
                    + t.getSolde() + "',client_id="
                    + t.getClient();
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate(strSql);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
         try {
            Statement stm= this.connect.createStatement();
            return 1==stm.executeUpdate("DELETE FROM COMPTES WHERE NUMERO='" + id + "'");
        } catch (SQLException ex) {
            Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return false;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
