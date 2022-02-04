/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp003.dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author WBVC0932
 */
public abstract class DAO<T> {

    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    public abstract boolean create(T t);

    public abstract T findById(int id);

    public abstract List<T> findAll();

    public abstract boolean update(T t);

    public abstract boolean delete(int id);
}
