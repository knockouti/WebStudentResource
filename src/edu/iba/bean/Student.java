package edu.iba.bean;

import java.util.ArrayList;

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

    public static ArrayList<Student> students = new ArrayList<Student>();
    static {
        students.add(new Student(1,"1","6",8.0,451001));
        students.add(new Student(2,"2","5",8.2,451002));
        students.add(new Student(3,"3","4",8.4,451003));
        students.add(new Student(4,"4","3",8.6,451004));
        students.add(new Student(5,"5","2",8.8,451005));
        students.add(new Student(6,"6","1",9.0,451006));
    }
}
