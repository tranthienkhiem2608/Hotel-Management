package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.ProfileUserDao;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;

public class ProfileUserController {
    public void updateBtn(JButton btn, Account account, User user){
        btn.addActionListener(e -> {
            System.out.println(account.getPassword() + " " + user.getName() + " " + user.getAge() + " " + user.getGender() + " " + user.getPhone() + " " + user.getEmail());
            if(new ProfileUserDao().updateUser(account, user) == 1){
                new Notification("Update successfully!").setVisible(true);
            } else {
                new Notification("Update failed!").setVisible(true);
            }
        });
    }
}
