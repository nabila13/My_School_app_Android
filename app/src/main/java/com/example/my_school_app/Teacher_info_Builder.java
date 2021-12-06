package com.example.my_school_app;

public class Teacher_info_Builder {
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

    public String getC_gender() {
        return c_gender;
    }

    public void setC_gender(String c_gender) {
        this.c_gender = c_gender;
    }

    public String getC_mobile() {
        return c_mobile;
    }

    public void setC_mobile(String c_mobile) {
        this.c_mobile = c_mobile;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    private int c_id;
    private String c_name,c_gender,c_mobile,c_email;

    public Teacher_info_Builder(int c_id, String c_name, String c_gender, String c_mobile, String c_email) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_gender = c_gender;
        this.c_mobile = c_mobile;
        this.c_email = c_email;
    }
}
