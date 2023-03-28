package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.dao.AccountSettingDao;
import com.hotelManagementSystem.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSettingController {

    public void confirmChangePassword(JButton btn , User user, Account account, JFrame frame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = new AccountSettingDao().checkChangePassword(user, account);
                if (flag == 1){
                    if(user.getPosition() == "Manager"){
                        frame.setVisible(false);
                        new ManagerDashboard().setVisible(true);
                    } else {
                        frame.setVisible(false);
                        new EmployeeDashboard().setVisible(true);
                    }
                    new Notification("Update password successfully!").setVisible(true);
                } else {
                    new Notification("Update password failed!").setVisible(true);
                }

            }
        });

    }
}
