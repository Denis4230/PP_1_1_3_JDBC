package jm.task.core.jdbc.util;

import com.mysql.cj.Session;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            System.out.println("no connect");
        }
    }


    public static Connection getConnection()  {
            return connection;

    }

    public static void connectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("проблема с закрытием connection");
        }
    }

}
