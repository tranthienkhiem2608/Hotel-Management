package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Notification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordDao {

    public ForgotPasswordDao(){}
    private final Conn conn = new Conn();


    public User checkValidUser(User user, Account account) {
        String query = "SELECT users.*, account.* FROM users JOIN account ON users.id = account.id WHERE users.phone = ? AND account.keyAnswer = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, user.getPhone());
            pstmt.setString(2, account.getKeyAnswer());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                return user;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
        return null;
    }

    public int changePassword(Account account, User user) {

        String query = "update account set password = '" + account.getPassword() + "' where id = '" + user.getId() + "'";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }finally {
            conn.closeConnection();
        }
    }
}

