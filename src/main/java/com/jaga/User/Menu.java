package com.jaga.User;

public class Menu {
    public static void helloMessage() {
        System.out.println("Hello, welcome to the bank BVB");
        menu();
    }

    public static void menu(){
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
}
