package edu.iba.dao.interfaces;

import edu.iba.dao.DAOException;
import edu.iba.dao.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    void create(T obj) throws DAOException, SQLException;
    void update(T obj, String identifier) throws DAOException;
    void delete(String identifier) throws DAOException;
    T get(String identifier) throws DAOException;
    List<T> getAll() throws DAOException;
}
