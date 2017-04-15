package edu.iba.entity;

import java.util.ArrayList;

public class User  {

    public enum Role {
        STUDENT, PROFESSOR, ADMIN
    }

    private String user;
    private String password;
    private Role role;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStringRole(){
        return  role.toString();
    }
}
