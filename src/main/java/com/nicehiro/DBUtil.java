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

    public boolean loginSuccess(String userName, String password) {
        boolean returnValue = false;
        String sql = "select * from students";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String userNameInDB = rs.getString("student_id");
                String passwordInDB = rs.getString("password");
                if (userNameInDB.equals(userName) &&
                        (passwordInDB.equals(password))) {
                    returnValue = true;
                }
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
