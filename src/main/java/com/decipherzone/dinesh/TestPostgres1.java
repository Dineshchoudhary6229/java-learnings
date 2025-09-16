package com.decipherzone.dinesh;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestPostgres1 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/db1";
        String user = "postgres";
        String password = "Dkdinesh6229";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            } else {
                System.out.println("Failed to connect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
