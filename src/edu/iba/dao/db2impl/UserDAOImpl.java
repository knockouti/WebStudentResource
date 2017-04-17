package edu.iba.dao.db2impl;

import edu.iba.dao.DAOException;
import edu.iba.dao.interfaces.UserDAO;
import edu.iba.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends AbstractDB2DAO implements UserDAO {

    private static String sqlCreate = "INSERT INTO user (\"user\",password,role) VALUES (?,?,?) ";
    private static String sqlUpadte = "UPDATE \"user\" SET password=?,role=?,user=? WHERE user=? ";
    private static String sqlDelete = "DELETE FROM \"user\" WHERE user=?";
    private static String sqlRead = "SELECT \"user\",role,password FROM user ";
    private static String sqlReadOne = "SELECT \"user\",role,password FROM user WHERE user=?";

    @Override
    public void create(User obj) throws DAOException {
        PreparedStatement ps ;
        try {
            ps = getConnection().prepareStatement(sqlCreate);
            ps.setString(1, obj.getUser());
            ps.setString(2, obj.getPassword());
            ps.setInt(3, obj.getRole().ordinal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void update(User obj, String identifier) throws DAOException {
        PreparedStatement ps ;
        try {
            ps = getConnection().prepareStatement(sqlUpadte);
            ps.setString(1, obj.getPassword());
            ps.setInt(2, obj.getRole().ordinal());
            ps.setString(3, obj.getUser());
            ps.setString(4, identifier);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void delete(String identifier) throws DAOException {
        PreparedStatement ps ;
        try {
            ps = getConnection().prepareStatement(sqlDelete);
            ps.setString(1, identifier);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public User get(String identifier) throws DAOException {
        PreparedStatement ps;
        ResultSet rs ;
        User user = null;
        try {
            ps = getConnection().prepareStatement(sqlReadOne);
            ps.setString(1, identifier);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), User.Role.values()[rs.getInt(3)]);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        PreparedStatement ps;
        ResultSet rs ;
        List<User> users = new ArrayList<User>();
        try {
            ps = getConnection().prepareStatement(sqlRead);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString(1), rs.getString(2), User.Role.values()[rs.getInt(3)]));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return users;
    }


    @Override
    public User tryLogonUser(String name, String password) {
        try {
            User u = get(name);
            return u.getPassword().equals(password) ? u : null;
        } catch (DAOException e) {
            return null;
        }
    }
}