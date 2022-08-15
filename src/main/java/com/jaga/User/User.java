package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;
import java.util.Random;

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

    String createUserBankNumber() {

        String chars = "0123456789";
        Random rnd = new Random();
        int len = 21;
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        System.out.println(sb.toString());

        DBHelper dbHelper = new DBHelper();

        return sb.toString();
    }

}
