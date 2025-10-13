package com.decipher.dinesh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBUtils {

    private static Properties props = new Properties();

    static {
        try (InputStream input = DBUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) throw new RuntimeException("application.properties not found");
            props.load(input);
            Class.forName(props.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL") != null ? System.getenv("DB_URL") : props.getProperty("jdbc.url");
        String user = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : props.getProperty("jdbc.username");
        String password = System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, user, password);
    }
}
