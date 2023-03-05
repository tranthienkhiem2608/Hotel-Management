package com.hotelManagementSystem.app;

import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "lucle1102");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
