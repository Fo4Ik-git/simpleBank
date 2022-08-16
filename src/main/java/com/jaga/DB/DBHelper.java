package com.jaga.DB;


import java.io.File;
import java.sql.*;

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
                "    userName    VARCHAR (50) NOT NULL,\n" +
                "    bankAccount VARCHAR (50) NOT NULL UNIQUE" +
                ")";
        final String CREATE_BANK_ACCOUNT = "CREATE TABLE bank_account (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    user_id    INTEGER NOT NULL" +
                ")";
//
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
            //System.out.println("Database closed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Create User
    public void createUser(String userName, String bankAccount) throws SQLException {
        String CREATE = "INSERT INTO user (userName, bankAccount) " +
                "VALUES (" +
                "'" + userName + "', '" + bankAccount + "'" +
                ")";
        statement = connection.createStatement();
        statement.execute(CREATE);
    }


    public void deleteUser(String id) throws SQLException {
        String DELETE = "DELETE FROM user WHERE id = '" + id + "'";
        statement = connection.createStatement();
        statement.execute(DELETE);
    }

    public void userUpdate(String newId, String newUsername, String newBankAccount) throws SQLException {
        String UPDATE = "UPDATE user SET id = '" + newId + "'" + ", user_name ='" + newUsername + "'" + ", bank_account = '" + newBankAccount + "'";
        statement = connection.createStatement();
        statement.execute(UPDATE);
    }
//    UPDATE users
//    SET id = 'new-id',
//        user_name ='new_username',
//        bank_account = 'new_bank_account'

    public boolean checkIfExists(String bankNumber) throws SQLException {
        String CHECK = "FROM user IF(STRCMP(bankNumber, bankNumber) = 0, " + "true" + "," + "false);";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(CHECK);
        while (rs.next()) {
            System.out.println("checkIfExeist:" + rs.first());
        }
        return false;
    }

}
//    FROM users
//    IF(STRCMP(bankNumber, bankNumber) = 0, "TRUE", "FALSE")