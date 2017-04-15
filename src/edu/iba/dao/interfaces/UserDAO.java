package edu.iba.dao.interfaces;

import edu.iba.bean.User;

public interface UserDAO extends DAO<User>{

    User tryLogonUser(String name, String password);
}
