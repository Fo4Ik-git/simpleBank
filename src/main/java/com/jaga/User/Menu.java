package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in);
    DBHelper dbHelper = new DBHelper();
    User user = new User();
    Config config = new Config();

    public void helloMessage() {
        System.out.println("Hello, welcome to the bank BVB " +
                "Do you have an account? (y/n)");
        if (s.nextLine().equals("y")) {
            checkUserData();
        } else {
            System.out.println("Do you want to create an account? (y/n)");
            if (s.nextLine().equals("y")) {
                createUser();
            } else {
                System.out.println("Goodbye");
            }
        }
    }

    void createUser() {
        String[] userData = new String[2];
        String[] userText = {"Please enter your name", "Please enter your password"};

        for (int i = 0; i < userData.length; i++) {
            System.out.println(userText[i]);
            userData[i] = s.nextLine();
        }
        if (check(userData)) {
                    user.createUser(userData[0], user.createUserLogin(), userData[1], user.createUserBankNumber());
            menu();
        } else {
            createUser();
        }
    }

    private boolean check(String[] userData) {
        String[] userText = {"Your name: ", "Your login: ", "Your password: "};
        for (int i = 0; i < userData.length; i++) {
            System.out.println(userText[i] + userData[i]);
        }
        System.out.println("It`s correct? (y/n)");
        if (s.nextLine().equals("y")) {
            return true;
        }
        if (s.nextLine().equals("n")) {
            createUser();
        }
        return false;
    }

    private void checkUserData() {
        System.out.println("Please enter your login");
        String userLogin = s.nextLine();
        System.out.println("Please enter your password");
        String userPassword = s.nextLine();
        if (userLogin.equals(config.getUserName()) && userPassword.equals(config.getUserPassword())) {
            menu();
        } else {
            System.out.println("Wrong username or password");
        }
    }

    public void menu() {
        System.out.println("1. Create a new currency account for a user");
        System.out.println("2. Deposit money to a bank account");
        System.out.println("3. Withdraw money from a bank account");
        System.out.println("4. Print the balance of a bank account");
        System.out.println("5. Update user");
        System.out.println("6. Delete user");
        System.out.println("7. Get user");
        System.out.println("8. Get all users");
        System.out.println("9. Exit");

        getUserChoice();
    }


    private void getUserChoice() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your choice: ");

        try {
            switch (s.nextInt()) {
                case 1 -> createCurrencyAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 5 -> printBalance();
                case 6 -> updateUser();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void createCurrencyAccount() {

    }

    void printBalance() {
        //    System.out.println("You have " + dbHelper.getBalance() + " in your account");

        try {
            dbHelper.openDB();
            dbHelper.getAllUserData(config.getUserBankNumber());
            System.out.println("You have " + config.getFunds() + " in your account");
            dbHelper.closeDB();
            menu();
        } catch (SQLException e) {
            System.out.println("Menu 94");
            System.out.println(e.getMessage());
        }
    }

    void updateUser() {

        menu();
    }


    void depositMoney() throws Exception {
        System.out.println("Enter a value of deposit: ");
        dbHelper.openDB();

        dbHelper.closeDB();
        s.nextInt();
        menu();
    }

    void withdrawMoney() throws Exception {

        menu();
    }

    //Check is Username and Password are correct

}
