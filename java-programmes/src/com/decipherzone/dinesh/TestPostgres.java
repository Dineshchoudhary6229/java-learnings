package com.decipherzone.dinesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestPostgres {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/db1"; // change port/db if needed
        String user = "postgres"; // your PostgreSQL username
        String password = "Dkdinesh6229"; // your PostgreSQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT version()")) {

            if (rs.next()) {
                System.out.println("✅ Connected to PostgreSQL!");
                System.out.println("PostgreSQL version: " + rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
