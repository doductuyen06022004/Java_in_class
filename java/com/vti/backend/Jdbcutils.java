package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcutils {
    private static final String URL = "jdbc:mysql://localhost:3306/java_login";
    private static final String USER = "root";
    private static final String PASSWORD = "tuyen06022004";

    public static Connection getConnection() throws SQLException, SQLException {
        return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
