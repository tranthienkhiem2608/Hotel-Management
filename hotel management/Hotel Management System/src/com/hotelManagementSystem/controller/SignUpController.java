package com.hotelManagementSystem.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotelManagementSystem.dao.SignUpDao;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.*;
public class SignUpController {
    void SignUpController(){}
    public void SignUpUser(JButton bSignUp, JFrame frame, User user){
        bSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = new SignUpDao().SignUpUser(user);
                if (flag == 1){
                    frame.setVisible(false);
                    new Notification("Account Created Successfully").setVisible(true);
                }else{
                    frame.setVisible(true);
                    new Notification("Account Created Failed").setVisible(true);
                }            }
        });
    }
}
