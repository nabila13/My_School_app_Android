package com.example.my_school_app;

public class Student_info_Builder {
    private int c_id,c_roll,c_number;
    private double c_age;
    private String c_name,c_gname;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getC_roll() {
        return c_roll;
    }

    public void setC_roll(int c_roll) {
        this.c_roll = c_roll;
    }

    public int getC_number() {
        return c_number;
    }

    public void setC_number(int c_number) {
        this.c_number = c_number;
    }

    public double getC_age() {
        return c_age;
    }

    public void setC_age(double c_age) {
        this.c_age = c_age;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_gname() {
        return c_gname;
    }

    public void setC_gname(String c_gname) {
        this.c_gname = c_gname;
    }

    public Student_info_Builder(int c_id, int c_roll , String c_name, double c_age, String c_gname , int c_number) {
        this.c_id = c_id;
        this.c_roll = c_roll;
        this.c_name = c_name;
        this.c_age = c_age;
        this.c_gname = c_gname;
        this.c_number = c_number;

    }
}
