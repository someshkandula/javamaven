package com.somesh.sbmaven.streams;

class Employees {
    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age='" + age + '\'' +
                ", sal=" + sal +
                '}';
    }

    int id;
    String fname;
    String lname;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    String age;
    int sal;

    int dept;

    public int getDept() {
        return dept;
    }

    public Employees(int id, String fname, String lname, String age, int sal, int dept) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.sal = sal;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public int getSal() {
        return sal;
    }
}