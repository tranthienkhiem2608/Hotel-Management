package com.hotelManagementSystem.conn;

import java.sql.*;

import static com.hotelManagementSystem.constants.Constants.*;

public class Conn {

    private static Conn instance;
    private Connection c;
    private Statement s;

    private Conn() {
        try {
            Class.forName(CLASSNAME);
            System.out.println(MESSDB);
            c = DriverManager.getConnection(URL, ROOT, PASSWORD);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Conn getInstance() {
        if (instance == null) {
            instance = new Conn();
        }
        return instance;
    }

    public Statement getStatment() {
        return s;
    }

    public Connection getConnection() {
        return c;
    }

    public void closeConnection() {
        try {
            c.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
