package edu.iba.dao.db2impl;

import edu.iba.bean.Student;
import edu.iba.dao.DAOException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Igor on 16.04.2017.
 */


import edu.iba.dao.DAOException;
import edu.iba.dao.interfaces.GroupDAO;
import edu.iba.bean.Group;
import edu.iba.dao.interfaces.GroupDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GroupDAOImpl extends AbstractDB2DAO implements GroupDAO {


    private static String sqlCreate = "INSERT INTO \"group\" (group_number,avg_mark) VALUES  (?,?) ";
    private static String sqlUpdate = "UPDATE \"group\" SET group_number=?,avg_mark=? WHERE group_number=? ";
    private static String sqlDelete = "DELETE FROM \"group\" WHERE group_number=?";
    private static String sqlRead = "SELECT group_number,avg_mark FROM \"group\"";
    private static String sqlReadOne = "SELECT group_number,avg_mark FROM \"group\" WHERE group_number=?";


    @Override
    public void create(Group obj) throws DAOException {
        PreparedStatement ps;
        try {
            ps = this.getConnection().prepareStatement(sqlCreate);
            ps.setString(1, obj.getGroup_number());
            ps.setDouble(2, obj.getAvg_mark());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void update(Group obj, String identifier) throws DAOException {
        PreparedStatement ps;
        try {
            ps = this.getConnection().prepareStatement(sqlUpdate);
            ps.setString(1, obj.getGroup_number());
            ps.setDouble(2, obj.getAvg_mark());
            ps.setString(3, identifier);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void delete(String identifier) throws DAOException {
        PreparedStatement ps;
        try {
            ps = this.getConnection().prepareStatement(sqlDelete);
            ps.setString(1, identifier);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public Group get(String identifier) throws DAOException {
        PreparedStatement ps;
        ResultSet rs;
        Group group = null;
        try {
            ps = this.getConnection().prepareStatement(sqlReadOne);
            ps.setString(1, identifier);
            rs = ps.executeQuery();
            if (rs.next()) {
                group = new Group(
                        rs.getString(1),
                        rs.getDouble(2));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return group;
    }


    @Override
    public List<Group> getAll() throws DAOException {
        PreparedStatement ps;
        ResultSet rs;
        List<Group> marks = new ArrayList<Group>();
        try {
            ps = this.getConnection().prepareStatement(sqlRead);
            rs = ps.executeQuery();
            while (rs.next()) {
                marks.add(new Group(
                        rs.getString(1),
                        rs.getDouble(2)));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return marks;
    }
}

