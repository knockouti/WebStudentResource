package edu.iba.dao.db2impl;

import edu.iba.dao.interfaces.*;

public class DB2DAOFactory {

//    public static GroupDAO getGroupDAO() {
//        return new GroupDAOImpl();
//    }
//
//    public static MarkDAO getMarkDAO() {
//        return new MarkDAOImpl();
//    }
//
//    public static ProfessorDAO getProfessorDAO() {
//        return new ProfessorDAOImpl();
//    }

    public static StudentDAOImpl getStudentDAO() {
        return new StudentDAOImpl();
    }

//    public static StudyDAO getStudyDAO() {
//        return new StudyDAOImpl();
//    }
//
//    public static UserDAO getUserDAO() {
//        return new UserDAOImpl();
//    }

    public static DAO getDAO(String entityType) {
//        if (entityType.equals("group")) {
//            return new GroupDAOImpl();}
       if (entityType.equals("student"))

    {
        return new StudentDAOImpl();
    }
//        } else if (entityType.equals("professor")) {
//            return new ProfessorDAOImpl();
//        } else if (entityType.equals("mark")) {
//            return new MarkDAOImpl();
//        } else if (entityType.equals("user")) {
//            return new UserDAOImpl();
//        } else if (entityType.equals("study")) {
//            return new StudyDAOImpl();
//        }
        return null;
    }
}
