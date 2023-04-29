package com.xiaohe.reflect;

public class Student extends Person {
    public String birthday;
    private int id;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, String address, String birthday, int id) {
        super(name, address);
        this.birthday = birthday;
        this.id = id;
    }

    public Student(String birthday, int id) {
        this.birthday = birthday;
        this.id = id;
    }

    public Student(String name, String address) {
        super(name, address);
    }

    public Student() {
    }

    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
