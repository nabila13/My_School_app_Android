package com.example.my_school_app;

public class Exam_result_Builder {
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_roll() {
        return c_roll;
    }

    public void setC_roll(String c_roll) {
        this.c_roll = c_roll;
    }

    public double getC_gpa() {
        return c_gpa;
    }

    public void setC_gpa(double c_gpa) {
        this.c_gpa = c_gpa;
    }

    public double getC_point() {
        return c_point;
    }

    public void setC_point(double c_point) {
        this.c_point = c_point;
    }

    private int c_id;
private String c_name, c_roll;
private double c_gpa, c_point;

    public Exam_result_Builder(int c_id, String c_name, String c_roll, double c_gpa, double c_point) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_roll = c_roll;
        this.c_gpa = c_gpa;
        this.c_point = c_point;
    }
}
