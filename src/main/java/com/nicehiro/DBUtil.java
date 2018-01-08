package com.nicehiro;

import java.sql.*;

public class DBUtil {
    private boolean bInited = false;

    public void initJDBC() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        bInited = true;
        System.out.println("Success loading Mysql Driver...");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (!bInited) {
            initJDBC();
        }
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/laboratory_manage",
                "root",
                "9090"
        );
        return connection;
    }

    private Roles searchInDB(String sql, String userName, String password, String nameField, String pwdField) {
        String returnValue = "anonymous";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String userNameInDB = rs.getString(nameField);
                String passwordInDB = rs.getString(pwdField);
                String sysRoleInDB = rs.getString("sys_role");
                if (userNameInDB.equals(userName) &&
                        (passwordInDB.equals(password))) {
                    returnValue = sysRoleInDB;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(returnValue);

        if (returnValue.equals("student"))
            return Roles.Student;
        else if (returnValue.equals("teacher"))
            return Roles.Teacher;
        else return Roles.Anonymous;
    }

    public Roles loginSuccess(String userName, String password) {
        String searchStuSQL = "select * from students";
        String searchTeaSQL = "select * from teachers";

        Roles returnValue = searchInDB(searchStuSQL, userName, password, "student_id", "password");

        if (returnValue.equals(Roles.Anonymous))
            return searchInDB(searchTeaSQL, userName, password, "teacher_id", "password");
        else
            return returnValue;

    }
}
