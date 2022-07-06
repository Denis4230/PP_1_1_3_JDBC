package jm.task.core.jdbc.util;

import com.mysql.cj.Session;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static Connection connection = null;




    public static Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            System.out.println("проблемы сподключением");
            e.printStackTrace();
        }
        return null;

    }

    public static void connectionClose() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("проблема с закрытием connection");
        }
    }

}
