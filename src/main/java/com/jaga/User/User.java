package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;
import java.util.Random;

public class User {
    Config config = new Config();

    public void createUser(String userName, String bankAccount) {
        DBHelper dbHelper = new DBHelper();
        try {
            dbHelper.openDB();
            dbHelper.createUser(userName, bankAccount);
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User already exists");
        }
    }

    String createUserBankNumber() {
        DBHelper dbHelper = new DBHelper();

        try {
            dbHelper.openDB();
            config.setUserBankNumber(generatorOfNumbers());
            if (dbHelper.checkIfExists(config.getUserBankNumber())) {
                return config.getUserBankNumber();
            } else {
                createUserBankNumber();
            }
            dbHelper.closeDB();
        } catch (SQLException e) {
        }
        return "";
    }

    private String generatorOfNumbers() {
        String chars = "0123456789";
        Random rnd = new Random();
        int len = 21;
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        System.out.println("Generator " + sb.toString());
        //testets

        return sb.toString();
    }

}
