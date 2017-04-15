package edu.iba.bean;

import java.sql.Date;
import java.util.ArrayList;

public class Mark  {
    private int id;
    private int studyId;
    private int studentId;
    private int professorId;
    private int mark;
    private String comments;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudyId() {
        return studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static ArrayList<Mark> marks = new ArrayList<Mark>();
    static {
        int i=1;
        marks.add(new Mark(i++,1,1,1,10,"I",Date.valueOf("2017-04-04")));
        marks.add(new Mark(i++,i-1,1,1,10,"I",Date.valueOf("2017-04-04")));
        marks.add(new Mark(i++,1,i-2,1,10,"I",Date.valueOf("2017-04-04")));
        marks.add(new Mark(i++,1,1,i-3,10,"I",Date.valueOf("2017-04-04")));
        marks.add(new Mark(i++,1,1,1,i+4,"I",Date.valueOf("2017-04-04")));
        marks.add(new Mark(i,1,1,1,10,"J",Date.valueOf("2017-04-04")));
    }

    public Mark() {
    }

    public Mark(int id, int studyId, int studentId, int professorId, int mark, String comments, Date date) {
        this.id = id;
        this.studyId = studyId;
        this.studentId = studentId;
        this.professorId = professorId;
        this.mark = mark;
        this.comments = comments;
        this.date = date;
    }
}
