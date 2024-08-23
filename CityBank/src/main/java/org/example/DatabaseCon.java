package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCon {
    String DB_URL = "jdbc:mysql://localhost:3306/citybank";
    String DB_USERNAME = "root";
    String DB_PASSWORD = "1234";

    public Connection createConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return conn;
    }

}
