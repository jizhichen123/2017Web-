package com.nicehiro;

public class Teacher implements People {

    private String name;
    private String password;

    private static Roles sys_role = Roles.Teacher;

    public Teacher(String name, String password) {
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
