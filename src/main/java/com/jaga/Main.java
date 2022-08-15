package com.jaga;

import com.jaga.DB.DBHelper;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{
            DBHelper dbHelper = new DBHelper();
            dbHelper.openDB();
            dbHelper.createDB();
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("Table already exists");
        }

        try{
            DBHelper dbHelper = new DBHelper();
            dbHelper.openDB();
            dbHelper.createUser("John", "12345");
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User already exists");
        }

    }
}
