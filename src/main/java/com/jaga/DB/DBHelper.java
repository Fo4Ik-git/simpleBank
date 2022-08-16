package com.jaga.DB;


import com.jaga.User.Config;

import java.io.File;
import java.sql.*;

public class DBHelper {
    // JDBC driver name and database URL
    Config config = new Config();

    static final String JDBC_NAME = "db.db";
    public Statement statement;
    Connection connection;


    //Create Data Base
    public void createDB() throws SQLException {
        File file = new File(JDBC_NAME);

        String CREATE_USER = "CREATE TABLE user (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    userName    VARCHAR (50) NOT NULL,\n" +
                "    userPassword    VARCHAR (50) NOT NULL,\n" +
                "    bankNumber VARCHAR (50) NOT NULL UNIQUE" +
                ")";
        final String CREATE_BANK_ACCOUNT = "CREATE TABLE bankAccount (\n" +
                "    id       INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    bankNumber       VARCHAR (50)      NOT NULL,\n" +
                "    currency       VARCHAR (50)      NOT NULL,\n" +
                "    funds       FLOAT      NOT NULL" +
                ")";
//
        statement = connection.createStatement();
        statement.execute(CREATE_USER);
        statement.execute(CREATE_BANK_ACCOUNT);
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
    public void createUser(String userName, String userPassword, String bankNumber) throws SQLException {
        String CREATE = "INSERT INTO user (userName,userPassword, bankNumber) " +
                "VALUES (" +
                "'" + userName + "', '" + userPassword + "'" + ", '" + bankNumber +
                ")";
        statement = connection.createStatement();
        statement.execute(CREATE);
    }


    public void deleteUser(String id) throws SQLException {
        String DELETE = "DELETE FROM user WHERE id = '" + id + "'";
        statement = connection.createStatement();
        statement.execute(DELETE);
    }

    //Rebuild
    public void userUpdate(String newId, String newUsername, String newBankNumber) throws SQLException {
        String UPDATE = "UPDATE user SET  userName ='" + newUsername + "'" + ", bankNumber = '" + newBankNumber + "'";
        statement = connection.createStatement();
        statement.execute(UPDATE);
    }


    public boolean checkIfExists(String bankNumber) throws SQLException {
        String CHECK = "SELECT * FROM user WHERE" + "'" + bankNumber + "'" + "LIKE" + "'bankNumber';";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(CHECK);
        if (rs.next()) {
            return false;
        } else return true;
    }

    //1234567890
    public void getAllUserData(String bankNumber) throws SQLException {
        try {
            String GET_ALL_DATA =
                    "SELECT * \n" +
                            "FROM user u \n" +
                            "LEFT JOIN bankAccount ba \n" +
                            "on u.bankNumber = ba.bankNumber \n";

            ResultSet rs = statement.executeQuery(GET_ALL_DATA);
            while (rs.next()) {
                config.setUserID(rs.getString("u.id"));
                config.setUserName(rs.getString("u.name"));
                config.setBankAccountID(rs.getString("ba.id"));
                config.setCurrency(rs.getString("ba.currency"));
                config.setFunds(Float.parseFloat(rs.getString("ba.funds")));
            }

            statement = connection.createStatement();
            statement.execute(GET_ALL_DATA);
            System.out.println(GET_ALL_DATA);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createBankAccount(String bankNumber, String currency, float funds) throws SQLException {
        String CREATE = "INSERT INTO bankAccount (bankNumber, currency, funds) " +
                "VALUES (" +
                "'" + bankNumber + "', '" + currency + "', '" + funds + "'" +
                ")";
        statement = connection.createStatement();
        statement.execute(CREATE);
    }

    public boolean checkLogigIsSame(String userLogin, String userPassword) throws SQLException {
        String CHECK_LOGIN = "SELECT * FROM user WHERE\" + \"'\" + userLogin + \"'\" + \"LIKE\" + \"'userLogin';";
        statement = connection.createStatement();
        statement.execute(CHECK_LOGIN);
        ResultSet log = statement.executeQuery(CHECK_LOGIN);
        if (log.next()) {
            return false;
        } else return true;
    }

}
