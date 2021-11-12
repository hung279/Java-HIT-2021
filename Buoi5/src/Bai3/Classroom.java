package Bai3;

import java.util.ArrayList;

public class Classroom {
    private String classID;
    private String className;
    private String date;
    private ArrayList<Student> x;
    private int n;
    private String teacher;

    public Classroom() {
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Student> getX() {
        return x;
    }

    public void setX(ArrayList<Student> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
