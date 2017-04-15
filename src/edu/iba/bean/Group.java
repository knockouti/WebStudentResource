package edu.iba.bean;

import java.util.ArrayList;

public class Group {
    private String group_number;
    private double avg_mark;

    public String getGroup_number() {
        return group_number;
    }

    public void setGroup_number(String group_number) {
        this.group_number = group_number;
    }

    public double getAvg_mark() {
        return avg_mark;
    }

    public void setAvg_mark(double avg_mark) {
        this.avg_mark = avg_mark;
    }

    public static ArrayList<Group> groups = new ArrayList<Group>();
    static {
        groups.add(new Group(451001+"",8.0));
        groups.add(new Group(451002+"",8.2));
        groups.add(new Group(451003+"",8.4));
        groups.add(new Group(451004+"",8.6));
        groups.add(new Group(451005+"",8.8));
        groups.add(new Group(451006+"",9.0));
    }

    public Group() {
    }

    public Group(String group_number, double avg_mark) {
        this.group_number = group_number;
        this.avg_mark = avg_mark;
    }
}
