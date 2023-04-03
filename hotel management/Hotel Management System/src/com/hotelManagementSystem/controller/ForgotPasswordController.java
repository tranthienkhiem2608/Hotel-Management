package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.ForgotPasswordDao;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Login;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordController {

    public ForgotPasswordController(){}
    public void checkUser(JButton btn, User user, Account account, JLabel result){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(user.getPhone() + " " + account.getKeyAnswer());
                if(new ForgotPasswordDao().checkValidUser(user, account) != null){
                    result.setText(user.getName());
                    result.setForeground(Color.decode("#069e20"));
                }else{
                    result.setText("not found");
                    result.setForeground(Color.decode("#ff0000"));
                    new Notification("Wrong phone or answer");
                }
            }
        });
    }

    public void changePasswword(JButton btn, User user, Account account,  JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(account.getPassword() + " " + user.getId() + " " + account.getConfirmPassword());
                int flag = new ForgotPasswordDao().changePassword(account, user);
                if(flag == 1){
                    frame.setVisible(false);
                    new Login().setVisible(true);
                    new Notification("Password Changed Successfully").setVisible(true);
                }else {
                    frame.setVisible(true);
                    new Notification("Password Changed Failed").setVisible(true);
            }}
        });
    }
}
