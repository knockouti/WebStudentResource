package edu.iba.dao.db2impl;

import edu.iba.bean.Mark;
import edu.iba.dao.DAOException;
import edu.iba.dao.interfaces.MarkDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 17.04.2017.
 */
public class MarkDAOImpl extends AbstractDB2DAO implements MarkDAO {

        private static String sqlCreate = "INSERT INTO \"mark\" (study_id,student_id, professor_id, mark, comments,date) VALUES  (?,?,?,?,?,?,?) ";
        private static String sqlUpdate = "UPDATE \"mark\" SET study_id=?,student_id=?, professor_id=?, mark=?, comments=?,date=? WHERE id=? ";
        private static String sqlDelete = "DELETE FROM \"mark\" WHERE id=?";
        private static String sqlRead = "SELECT study_id,student_id, professor_id, mark, comments,date FROM \"mark\"";
        private static String sqlReadOne = "SELECT study_id,student_id, professor_id, mark, comments,date FROM \"mark\" WHERE id=?";

        @Override
        public void create(Mark obj) throws DAOException {
            PreparedStatement ps;
            try {
                ps = this.getConnection().prepareStatement(sqlCreate);
                ps.setInt(1, obj.getStudyId());
                ps.setInt(2, obj.getStudentId());
                ps.setInt(3, obj.getProfessorId());
                ps.setInt(4, obj.getMark());
                ps.setString(5, obj.getComments());
                ps.setDate(6, obj.getDate());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            } finally {
                close();
            }
        }

        @Override
        public void update(Mark obj, String identifier) throws DAOException {
            PreparedStatement ps;
            try {
                ps = this.getConnection().prepareStatement(sqlUpdate);
                ps.setInt(1, obj.getStudyId());
                ps.setInt(2, obj.getStudentId());
                ps.setInt(3, obj.getProfessorId());
                ps.setInt(4, obj.getMark());
                ps.setString(5, obj.getComments());
                ps.setDate(6, obj.getDate());
                ps.setInt(7, obj.getId());
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
                ps = this.getConnection().prepareStatement(sqlDelete);
                ps.setInt(1, Integer.parseInt(identifier));
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException(e);
            } finally {
                close();
            }
        }

        @Override
        public Mark get(String identifier) throws DAOException {
            PreparedStatement ps;
            ResultSet rs ;
            Mark mark = null;
            try {
                ps = this.getConnection().prepareStatement(sqlReadOne);
                ps.setString(1, identifier);
                rs = ps.executeQuery();
                if (rs.next()) {
                    mark = new Mark(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7));
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            } finally {
                close();
            }
            return mark;
        }

        @Override
        public List<Mark> getAll() throws DAOException {
            PreparedStatement ps;
            ResultSet rs ;
            List<Mark> marks = new ArrayList<Mark>();
            try {
                ps = this.getConnection().prepareStatement(sqlRead);
                rs = ps.executeQuery();
                while (rs.next()) {
                    marks.add(new Mark(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getDate(7)));
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            } finally {
                close();
            }
            return marks;
        }

    }


