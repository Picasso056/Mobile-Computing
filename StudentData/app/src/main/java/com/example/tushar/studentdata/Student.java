package com.example.tushar.studentdata;

/**
 * Created by Tushar on 01-10-2016.
 */

public class Student {

    private String subject;
    private int marks;
    private String courseno;

    public Student()
    {

    }

    public Student(String subject, String course,int marks) {
        this.marks = marks;
        this.subject = subject;
        this.courseno = course;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }




}
