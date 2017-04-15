//package edu.iba.dao.db2;
//
//import edu.iba.dao.DAOException;
//
//import javax.activation.DataSource;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
///**
// * Created by Igor on 10.04.2017.
// */
//public class DB2AbstractDAOImpl  {
//    private Connection getConnection() throws DAOException {
//        try {
//            InitialContext context = new InitialContext();
//            DataSource dataSource = (DataSource)context.lookup("jdbc/StudentHelperDB");
//            return dataSource.getConnection();
//        }
//        catch (NamingException e1){
//        throw new DAOException(e1);
//        }
//        catch (SQLException e2){
//            throw new DAOException(e2);
//        }
//
//    }
//}
