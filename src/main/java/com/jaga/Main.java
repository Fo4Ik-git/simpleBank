package com.jaga;

import com.jaga.DB.DBHelper;
import com.jaga.User.Menu;

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

        Menu menu = new Menu();
        menu.helloMessage();
    }


}
