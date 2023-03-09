package com.hotelManagementSystem.constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Constants {
    public final static String URL = "jdbc:mysql:///hotelmanagementsystem";
    public final static String  CLASSNAME = "com.mysql.cj.jdbc.Driver";
    public final static String ROOT = "root";
    public final static String PASSWORD = "lucle1102";
    public final static String MESSDB = "Database connection Successful";

    public final static String MESSINVALID = "Invalid username or password";
    public final static String MESSCHANGEPASS = "Password changed successfully";
}
