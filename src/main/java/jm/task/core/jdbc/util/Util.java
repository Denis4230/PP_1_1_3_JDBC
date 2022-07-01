package jm.task.core.jdbc.util;

import com.mysql.cj.Session;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    private final String LOGIN = "root";
    private final String PASSWORD = "1234";
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

}
