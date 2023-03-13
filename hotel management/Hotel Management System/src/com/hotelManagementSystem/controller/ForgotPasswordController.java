package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.ForgotPasswordDao;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Login;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordController {

    public ForgotPasswordController(){}
    public void checkUser(JButton btn,User user, JLabel result){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new ForgotPasswordDao().checkValidUser(user, result) != null){
                    result.setText(user.getUsername());
                    result.setForeground(Color.decode("#069e20"));
                }else{
                    result.setText("not found");
                    result.setForeground(Color.decode("#ff0000"));
                    new Notification("Wrong phone or answer");
                }
            }
        });
    }

    public void changePasswword(JButton btn, User user,  JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int flag = new ForgotPasswordDao().changePassword(user);
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
