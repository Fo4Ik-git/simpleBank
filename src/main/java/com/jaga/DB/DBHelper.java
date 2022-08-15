package com.jaga.DB;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    // JDBC driver name and database URL

    static final String JDBC_NAME = "db.db";
    public Statement statement;
    Connection connection;

    //Create Data Base
    public void createDB() throws SQLException {
        File file = new File(JDBC_NAME);

        String CREATE_USER = "CREATE TABLE user (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    user_name    VARCHAR (50) NOT NULL,\n" +
                "    bank_account VARCHAR (50) NOT NULL" +
                ")";
       String CREATE_BANK_NUMBER = "CREATE TABLE bank_account (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    user_id    INTEGER NOT NULL" +
                ")";
       //String CREATE_
        statement = connection.createStatement();
        statement.execute(CREATE_USER);
    }

    //Connect to Data Base
    public void openDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(
                    "jdbc:sqlite:" + JDBC_NAME);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error here opendb");
        }
    }

    //Close Data Base
    public void closeDB() {
        try {
            connection.close();
            System.out.println("Database closed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Create User
    public void createUser(String user_name, String bank_account) throws SQLException {
        String CREATE = "INSERT INTO users (user_name, bank_account) VALUES ('" + user_name + "', '" + bank_account + "')";
        statement = connection.createStatement();
        statement.execute(CREATE);
    }


    public void deleteUser(String id) throws SQLException {
        String DELETE = "DELETE FROM users WHERE id = '" + id + "'";
        statement = connection.createStatement();
        statement.execute(DELETE);
    }

}
