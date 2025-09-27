package com.decipher.dinesh.jdbc.schoolManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.InputStream;

public class TestPostgres
{
    private static final Logger log = LoggerFactory.getLogger(TestPostgres.class);

    public static void main(String[] args)
    {
        Properties props = new Properties();

        try (InputStream input = TestPostgres.class.getClassLoader().getResourceAsStream("application.properties"))
        {
            if (input == null)
            {
                log.error("Unable to find application.properties");
                throw new RuntimeException("application.properties file not found in resources folder");
            }

            props.load(input);

            String url = props.getProperty("jdbc.url");          //  port name and name of database which we want to create
            String user = props.getProperty("jdbc.username");    // Postgres SQL username
            String password = props.getProperty("jdbc.password"); // Postgres SQL password

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT version()"))
            {

                if (rs.next())
                {
                    System.out.println(" Connected to PostgreSQL!");
                    System.out.println("PostgreSQL version: " + rs.getString(1));
                }

            }
        }
        catch (Exception e)
        {
            log.error("e: ", e);
        }
    }
}
