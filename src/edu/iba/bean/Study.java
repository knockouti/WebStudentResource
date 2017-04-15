package edu.iba.bean;

import java.util.ArrayList;

public class Study {
    private int id;
    private String name;
    private int hours;
    private int professorId;
    private double avg_mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public double getAvg_mark() {
        return avg_mark;
    }

    public void setAvg_mark(double avg_mark) {
        this.avg_mark = avg_mark;
    }

    public Study() {
    }

    public Study(int id, String name, int hours, int professorId, double avg_mark) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.professorId = professorId;
        this.avg_mark = avg_mark;
    }

    public static ArrayList<Study> studies = new ArrayList<Study>();
    static {
        studies.add(new Study(1,"Math",10,1,10));
        studies.add(new Study(2,"OAIP",10,2,10));
        studies.add(new Study(3,"MIAPR",20,3,10));
        studies.add(new Study(4,"STIAOS",15,4,10));
    }
}
