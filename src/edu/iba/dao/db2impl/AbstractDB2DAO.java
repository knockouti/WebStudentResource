package edu.iba.dao.db2impl;

import edu.iba.dao.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDB2DAO{

    private Connection cn;

    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "mydb";
    private final String userName = "root";
    private final String password = "5win3se7enrus2";

//    private AbstractDB2DAO() {
//        try {
//            cn = ((DataSource)new InitialContext.lookUp()).getConnection;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    protected final Connection getConnection() throws DAOException{
        try {
            if (cn.isClosed())
                cn = DriverManager.getConnection(url + dbName, userName, password);
            return cn;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    protected final void close() {
        if (cn != null) {
            try {
                if (!cn.isClosed())
                    cn.close();
            } catch (SQLException e) {
                try {
                    cn.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }

}