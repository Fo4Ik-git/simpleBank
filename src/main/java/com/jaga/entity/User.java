package com.jaga.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Account> accounts;
    private UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


//initialize User Roles
public enum UserRole {
    ADMIN,
    USER
}
}

