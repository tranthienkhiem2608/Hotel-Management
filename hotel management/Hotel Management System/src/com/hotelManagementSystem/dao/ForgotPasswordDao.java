package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Notification;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordDao {

    public ForgotPasswordDao(){}

    public User checkValidUser(User user, JLabel result){
        String query = "select * from users where phone = '"+user.getPhone()+"' and answer = '"+user.getAnswer()+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.getStatment().executeQuery(query);
            if(rs.next()){
                user.setUsername(rs.getString("username"));
                return user;
            }else{
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    return null;
}
    public int changePassword(User user){

            String query = "update users set password = '" + user.getPassword() + "' where username = '" + user.getUsername() + "'";
            try{
                Conn c = new Conn();
                c.getStatment().executeUpdate(query);
                return 1;
            }catch (Exception ex){
                ex.printStackTrace();
            }

        return 0;
    }
}

