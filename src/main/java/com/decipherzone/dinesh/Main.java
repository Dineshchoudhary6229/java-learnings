package com.decipherzone.dinesh;
import java.sql.Connection;

public class Main {
    public static void main(String[] args)
    {
        DbFunctions db = new DbFunctions();
        Connection conn=db.connect_to_db("db1","postgres","Dkdinesh6229");
        db.createTable(conn ,"employee");
    }
}