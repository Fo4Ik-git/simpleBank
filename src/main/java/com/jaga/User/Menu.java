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
        if (s.nextLine().equals("y")){
           checkUserData();
        } else {
            System.out.println("Do you want to create an account? (y/n)");
            if (s.nextLine().equals("y")){
                createUser();
            } else {
                System.out.println("Goodbye");
            }
        }
    }

    private void checkUserData() {
        System.out.println("Please enter your username");
        String userName = s.nextLine();
        System.out.println("Please enter your password");
        String userPassword = s.nextLine();
        if (userName.equals(config.getUserName()) && userPassword.equals(config.getUserPassword())) {
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
                case 1 -> createUser();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> createCurrencyAccount();
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
            throw new RuntimeException(e);
        }
    }

    void updateUser() {

        menu();
    }


    void createUser() {
        System.out.println("Enter your Name: ");
        String name = s.nextLine();
        if (check(name)) {
            user.createUser(name, "test",  user.createUserBankNumber());
            menu();
        } else {
            createUser();
        }
    }

    void depositMoney() throws Exception {
        System.out.println("Enter a value of deposit: ");
        float depositAmount = s.nextInt();
        dbHelper.openDB();
        dbHelper.deposit();
        dbHelper.closeDB();
        menu();
    }

    void withdrawMoney() throws Exception {

        menu();
    }

    //Check is Username
    private boolean check(String value) {
        System.out.println("Are you sure what " + value + " is your name? (y/n)");
        if (s.nextLine().equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}
