package edu.iba.dao;

import edu.iba.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Igor on 10.04.2017.
 */
public interface UserDAO {
    List<User> getAllUsers() throws DAOException, SQLException;
    User getUserById(String id) throws  DAOException;
    void updateUser(String id, User user) throws  DAOException;
    void deleteUserById(String id) throws  DAOException;
    void addUser() throws  DAOException;
    User getUserByIdAndPassword(String id, String password) throws  DAOException;
}
