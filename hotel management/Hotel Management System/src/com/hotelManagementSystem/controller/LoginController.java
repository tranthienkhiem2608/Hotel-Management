package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.LoginDao;
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

    public void changeToSignUp(JButton btn, JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new SignUp().setVisible(true);
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

    public void LoginBtn(JButton btn, JFrame frame, User userLogin){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = new LoginDao().checkLogin(userLogin);
                if(flag == 1) {
                    new ManagerDashboard().setVisible(true);
                    frame.setVisible(false);
                } else if (flag == 2) {
                    new EmployeeDashboard().setVisible(true);
                    frame.setVisible(false);
                } else {
                    new Notification("Invalid Username or Password").setVisible(true);
                }
            }
        });
    }
}
