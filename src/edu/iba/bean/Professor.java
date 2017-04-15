package edu.iba.bean;

import java.sql.Date;
import java.util.ArrayList;

public class Professor {

    private int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Date birthday;
    private double avg_mark;

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getAvg_mark() {
        return avg_mark;
    }

    public void setAvg_mark(double avg_mark) {
        this.avg_mark = avg_mark;
    }


    public static ArrayList<Professor> professors ;
    static {
        professors = new ArrayList<Professor>();
        professors.add(new Professor(1, "A", "A", "A", Date.valueOf("1990-10-20"), 10));
        professors.add(new Professor(2, "B", "B", "B", Date.valueOf("1990-10-20"), 10));
        professors.add(new Professor(3, "C", "C", "C", Date.valueOf("1990-10-20"), 10));
        professors.add(new Professor(4, "D", "D", "D", Date.valueOf("1990-10-20"), 10));
        professors.add(new Professor(5, "E", "E", "E", Date.valueOf("1990-10-20"), 10));
    }

    public Professor() {
    }

    public Professor(int id, String firstName, String lastName, String fatherName, Date birthday, double avg_mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthday = birthday;
        this.avg_mark = avg_mark;
    }
}
