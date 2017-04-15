//package edu.iba.dao.db2;
//
//import edu.iba.dao.DAOException;
//import edu.iba.dao.UserDAO;
//import edu.iba.entity.User;
//
//import javax.activation.DataSource;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Igor on 10.04.2017.
// */
//public class DB2UserImpl implements UserDAO {
//    private static final String GET_ALL =
//            "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS";
//    @Override
//    public List<User> getAllUsers() throws DAOException {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet set = null;
//        try {
//            connection = getConnection();
//            statement = connection.prepareStatement(GET_ALL);
//           set = statement.executeQuery();
//            List<User> list = new ArrayList<>();
//            while (set.next()){
//                User user = new User();
//                user.setRole(User.Role.valueOf(set.getString("ROLE").toUpperCase()));
//                user.setUser(set.getString("USER"));
//            }
//            return list;
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        }
//        finally {
//            try {
//                if(set != null){
//                    set.close();
//                }
//            }
//                 catch (SQLException){
//
//                }
//                try {
//                if(statement != null){
//                    statement.close();
//                }}catch (SQLException) {
//                }
//                try {
//                    if (connection != null) {
//                        connection.close();
//                    }
//                }catch (SQLException){
//
//                }
//
//
//
//        }
//
//    }
//private Connection getConnection()  {
//        try {
//            InitialContext context = new InitialContext();
//            DataSource dataSource = (DataSource)context.lookup("jdbc/StudentHelperDB");
//            return dataSource.getConnection();
//        }
//    catch (Exception e){
//
//    }
//
//}
//    @Override
//    public User getUserById(String id) {
//        return null;
//    }
//
//    @Override
//    public void updateUser(String id, User user) {
//
//    }
//
//    @Override
//    public void deleteUserById(String id) {
//
//    }
//
//    @Override
//    public void addUser() {
//
//    }
//
//    @Override
//    public User getUserByIdAndPassword(String id, String password) {
//        return null;
//    }
//}
