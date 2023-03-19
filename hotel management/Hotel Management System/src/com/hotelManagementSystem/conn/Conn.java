package com.hotelManagementSystem.conn;
import java.sql.*;

import static com.hotelManagementSystem.constants.Constants.*;


public class Conn {

    private Connection c;
    public Statement s;
    public Conn() {
        try {
            Class.forName(CLASSNAME);
            System.out.println(MESSDB);
            c =DriverManager.getConnection(URL, ROOT, PASSWORD);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Statement getStatment(){
        return s;
    }
    public Connection getConnection(){
        return c;
    }



    public void closeConnection(){
        try {
            c.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
