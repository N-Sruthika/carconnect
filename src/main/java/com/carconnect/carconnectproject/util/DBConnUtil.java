package com.carconnect.carconnectproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    static {
        String host = PropertyUtil.getProperty("host", "localhost");
        String port = PropertyUtil.getProperty("port", "3306");
        String dbname = PropertyUtil.getProperty("dbname", "project");

        dbUser = PropertyUtil.getProperty("username");
        dbPassword = PropertyUtil.getProperty("password");

        // Construct the URL dynamically
        dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbname;

        try {
            // Ensure the driver class is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Database Driver not found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
