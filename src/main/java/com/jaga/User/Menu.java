package com.jaga.User;

import java.util.Scanner;

public class Menu {
    public void helloMessage() {
        System.out.println("Hello, welcome to the bank BVB");
        menu();
    }

    public void menu(){
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


    }

    private void getUserChoice(){
        Scanner s  = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter your choice: ");

        try {
            switch (s.nextInt()){
                case 1:
                    System.out.println("Enter your Name: ");

                    String name = s.nextLine();
                    if(check(s.nextLine())){
                        user.createUser(name, user.createUserBankNumber());
                    }

                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean check(String value){
        Scanner s = new Scanner(System.in);
        System.out.println("Are you sure what " + value + " is your name? (y/n)");
        return s.nextLine().equals("y");
    }
}
