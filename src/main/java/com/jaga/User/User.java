package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;

public class User {
    public void createUser(String user_name, String bank_account) {
        DBHelper dbHelper = new DBHelper();
        try {
            dbHelper.openDB();
            dbHelper.createUser(user_name, bank_account);
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User already exists");
        }
    }

    private void createUserBankNumber() {
        DBHelper dbHelper = new DBHelper();


    }

}
