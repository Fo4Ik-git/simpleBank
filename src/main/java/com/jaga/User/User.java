package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;
import java.util.Random;

public class User {
    Config config = new Config();

    public void createUser(String userName, String userLogin, String userPassword, String bankAccount) {
        DBHelper dbHelper = new DBHelper();
        try {
            dbHelper.openDB();
            dbHelper.createUser(userName, userLogin, userPassword, bankAccount);
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User 11");
            System.out.println(e.getMessage());
        }
    }

    String createUserBankNumber() {
        DBHelper dbHelper = new DBHelper();

        try {
            dbHelper.openDB();
            config.setUserBankNumber(generatorOfNumbers(21));
            if (dbHelper.checkIfExists(config.getUserBankNumber(), "bankNumber")) {
                System.out.println("Your bank account: " + config.getUserBankNumber());
                return config.getUserBankNumber();
            } else {
                createUserBankNumber();
            }
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User 22");
            System.out.println(e.getMessage());
        }
        return "";
    }

    private String generatorOfNumbers(int length) {
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }

   String createUserLogin() {
        DBHelper dbHelper = new DBHelper();

        try {
            dbHelper.openDB();
            config.setUserLogin(generatorOfNumbers(10));
            if (dbHelper.checkIfExists(config.getUserLogin(), "userLogin")) {
                System.out.println("Your user login: " + config.getUserLogin());
                return config.getUserLogin();
            } else {
                createUserLogin();
            }
            dbHelper.closeDB();
        } catch (SQLException e) {
            System.out.println("User 57");
            System.out.println(e.getMessage());
        }
        return "";
    }


}
