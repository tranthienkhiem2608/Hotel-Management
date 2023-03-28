package com.hotelManagementSystem.controller;
import javax.swing.*;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.*;
import com.hotelManagementSystem.dao.AddUserDao;
public class AddUserController {

    public AddUserController(){}
    public void addBtn(JButton btn, User user, Account account){
        btn.addActionListener(e -> {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getGender() + " " + user.getPosition() + " " + user.getSalary() + " " + user.getPhone() + " " + user.getEmail());
            int flag = new AddUserDao().addUser(user, account);
            if(flag == 1){
                new Notification("Add user successfully!").setVisible(true);
            } else if (flag == 2) {
                new Notification("User already exists!").setVisible(true);
            } else if (flag == 0) {
                new Notification("Add user failed!").setVisible(true);
            } else if (flag == 3) {
                new Notification("Add user successfully!").setVisible(true);
            }
        });
    }
}
