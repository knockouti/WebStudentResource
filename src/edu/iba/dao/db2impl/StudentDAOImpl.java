package edu.iba.dao.db2impl;

import edu.iba.bean.Student;
import edu.iba.dao.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 14.04.2017.
 */
public class StudentDAOImpl extends AbstractDB2DAO implements edu.iba.dao.interfaces.StudentDAO {
    private static String sqlCreate = "INSERT INTO `students`(`ID`, `FIRST_NAME`, `LAST_NAME`, `AVG_MARK`, `GROUP_NUMBER`) VALUES (?,?,?,?,?)";
    private static String sqlUpdate = "UPDATE 'student' SET ID=?,FIRST_NAME=?,LAST_NAME=?,AVG_MAR=?,GROUP_NUMBER=? where ID = ?";
    private static String sqlDelete = "DELETE FROM 'student' WHERE ID=?";
    private static String sqlOne = "SELECT * FROM 'student' WHERE ID=?";
    private  static String sqlAll = "SELECT * FROM 'student'";

    @Override
    public void create(Student obj) throws DAOException, SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = this.getConnection().prepareStatement(sqlCreate);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getLastName());
            preparedStatement.setDouble(4, obj.getAvg_mark());
            preparedStatement.setInt(5, obj.getGroupNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }

    }

    @Override
    public void update(Student obj, String identifier) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getLastName());
            preparedStatement.setDouble(4, obj.getAvg_mark());
            preparedStatement.setInt(5, obj.getGroupNumber());
            preparedStatement.setInt(6, Integer.parseInt(identifier));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public void delete(String identifier) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, Integer.parseInt(identifier));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
    }

    @Override
    public Student get(String identifier) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            preparedStatement = this.getConnection().prepareStatement(sqlOne);
            preparedStatement.setInt(1, Integer.parseInt(identifier));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5));
            }
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return student;
    }

    @Override
    public List<Student> getAll() throws DAOException {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            preparedStatement = this.getConnection().prepareStatement(sqlAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              studentList.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5)));
            }
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            close();
        }
        return studentList;
    }
}
