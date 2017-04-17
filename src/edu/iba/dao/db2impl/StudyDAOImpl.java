package edu.iba.dao.db2impl;

import edu.iba.dao.DAOException;
import edu.iba.dao.interfaces.StudyDAO;
import edu.iba.bean.Study;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudyDAOImpl extends AbstractDB2DAO implements StudyDAO {

    private static String sqlCreate = "INSERT INTO study (name,hours,professorId,avg_mark) VALUES (?,?,?,?) ";
    private static String sqlUpdate = "UPDATE study SET name=?,hours=?,professor_id=?,avg_mark=? WHERE id=? ";
    private static String sqlDelete = "DELETE FROM study WHERE id=?";
    private static String sqlRead = "SELECT id,name,hours,professor_id,avg_mark FROM study ";
    private static String sqlReadOne = "SELECT id,name,hours,professor_id,avg_mark FROM study WHERE id = ?";

    @Override
    public void create(Study obj) throws DAOException {
        PreparedStatement ps ;
        try {
            ps = getConnection().prepareStatement(sqlCreate);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getHours());
            ps.setInt(3, obj.getProfessorId());
            ps.setDouble(4, obj.getAvg_mark());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void update(Study obj, String identifier) throws DAOException {
        PreparedStatement ps ;
        try {
            ps = getConnection().prepareStatement(sqlUpdate);
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getHours());
            ps.setInt(3, obj.getProfessorId());
            ps.setDouble(4, obj.getAvg_mark());
            ps.setInt(5, obj.getId());
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
            ps.setInt(1, Integer.parseInt((String) identifier));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public Study get(String identifier) throws DAOException {
        PreparedStatement ps;
        ResultSet rs ;
        Study study = null;
        try {
            ps = getConnection().prepareStatement(sqlReadOne);
            ps.setInt(1, Integer.parseInt((String) identifier));
            rs = ps.executeQuery();
            if (rs.next()) {
                study = new Study(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return study;
    }

    @Override
    public List<Study> getAll() throws DAOException {
        PreparedStatement ps;
        ResultSet rs = null;
        List<Study> studies = new ArrayList<Study>();
        try {
            ps = getConnection().prepareStatement(sqlRead);
            rs = ps.executeQuery();
            while (rs.next()) {
                studies.add(
                        new Study(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getDouble(5)));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return studies;
    }

}
