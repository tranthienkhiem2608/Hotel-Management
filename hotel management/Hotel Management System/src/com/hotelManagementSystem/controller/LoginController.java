package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.AccountSettingDao;
import com.hotelManagementSystem.dao.LoginDao;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginController {

    void LoginController(){}
    public void changeToLogin(JButton btn, JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login().setVisible(true);
            }
        });
    }

    public void backToWelcome(JButton btn, JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new HotelManagementSys().setVisible(true);
            }
        });
    }


    public void changeToForgotPass(JButton btn, JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ForgotPassword().setVisible(true);
            }
        });
    }

    public void LoginBtn(JButton btn, JFrame frame, Account userLogin, User user){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(userLogin.getIdAccount() + " " + userLogin.getPassword());
                int flag = new LoginDao().checkLogin(userLogin, user);
                if(flag == 1) {
                    new ManagerDashboard().setVisible(true);
                    frame.setVisible(false);
                } else if (flag == 2) {
                    new EmployeeDashboard().setVisible(true);
                    frame.setVisible(false);
                } else if (flag == 3) {
                    frame.setVisible(false);
                    new AccountSetting(user).setVisible(true);
                }
                else {
                    new Notification("Invalid Username or Password").setVisible(true);
                }
            }
        });
    }
}
