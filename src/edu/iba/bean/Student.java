package edu.iba.bean;

import edu.iba.dao.DAOException;
import edu.iba.dao.db2impl.StudentDAOImpl;
import edu.iba.dao.interfaces.DAO;

import java.util.ArrayList;
import java.util.List;

public class Student  {
    private int id;
    private String firstName;
    private String lastName;
    private double avg_mark;
    private int groupNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAvg_mark() {
        return avg_mark;
    }

    public void setAvg_mark(double avg_mark) {
        this.avg_mark = avg_mark;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Student() {

    }

    public Student(int id, String firstName, String lastName, double avg_mark, int groupNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avg_mark = avg_mark;
        this.groupNumber = groupNumber;
    }







}
