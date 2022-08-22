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
            System.out.println("User already exists");
        }
    }

    String createUserBankNumber() {
        DBHelper dbHelper = new DBHelper();

        try {
            dbHelper.openDB();
            config.setUserBankNumber(generatorOfBankNumbers());
            if (dbHelper.checkIfExists(config.getUserBankNumber(), "bankNumber")) {
                return config.getUserBankNumber();
            } else {
                createUserBankNumber();
            }
            dbHelper.closeDB();
        } catch (SQLException e) {

        }
        return "";
    }

    private String generatorOfBankNumbers() {
        String chars = "0123456789";
        Random rnd = new Random();
        int len = 21;
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        System.out.println("Your bank account: " + sb.toString());
        //testets

        return sb.toString();
    }

   String createUserLogin() {
        DBHelper dbHelper = new DBHelper();

        try {
            dbHelper.openDB();
            config.setUserBankNumber(generatorOfUserLogin());
            if (dbHelper.checkIfExists(config.getUserLogin(), "userLogin")) {
                return config.getUserLogin();
            } else {
                createUserLogin();
            }
            dbHelper.closeDB();
        } catch (SQLException e) {

        }
        return "";
    }
    private String generatorOfUserLogin() {
        String chars = "0123456789";
        Random rnd = new Random();
        int len = 10;
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        System.out.println("Your login: " + sb.toString());

        return sb.toString();
    }

}
