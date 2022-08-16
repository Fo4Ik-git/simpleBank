package com.jaga.User;

import com.jaga.DB.DBHelper;

import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in);
    DBHelper dbHelper = new DBHelper();
    User user = new User();

    public void helloMessage() {
        System.out.println("Hello, welcome to the bank BVB");
        menu();
    }

    public void menu() {
        System.out.println("1. Create a new bank account for a user");
        System.out.println("2. Deposit money to a bank account");
        System.out.println("3. Withdraw money from a bank account");
        System.out.println("4. Transfer money from one bank account to another");
        System.out.println("5. Print the balance of a bank account");
        System.out.println("6. Update user");
        System.out.println("7. Delete user");
        System.out.println("8. Get user");
        System.out.println("9. Get all users");
        System.out.println("10. Exit");

        getUserChoice();
    }


    private void getUserChoice() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your choice: ");

        try {
            switch (s.nextInt()) {
                case 1 -> enterName();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 6 -> updateUser();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void updateUser() {
    }


    void enterName() {
        System.out.println("Enter your Name: ");
        String name = s.nextLine();
        if (check(name)) {
            user.createUser(name, user.createUserBankNumber());
        } else {
            enterName();
        }
    }

    void depositMoney() throws Exception {
        System.out.println("Enter a value of deposit: ");
        dbHelper.openDB();

        dbHelper.closeDB();
        s.nextInt();
    }

    void withdrawMoney() throws Exception {

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
