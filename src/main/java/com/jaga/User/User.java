package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;
import java.util.Random;

public class User {
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
            String number = generatorOfNumbers();
            if (dbHelper.checkIfExists(number)) {
                return number;
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

        return sb.toString();
    }

}
