package com.nicehiro;

public class Student implements People {

    private String name;
    private String password;

    private static Roles sys_role = Roles.Student;

    public Student(String name, String password) {
        setName(name);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
