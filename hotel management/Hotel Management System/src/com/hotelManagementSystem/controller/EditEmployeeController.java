package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.views.*;
import com.hotelManagementSystem.dao.*;
import com.hotelManagementSystem.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEmployeeController {

    public void searchIdUser(JButton btn, User user, JPanel panel, JTextArea textArea, JTextArea textArea1, JTextArea textArea2, JTextArea textArea3, JTextArea textArea4, JTextArea textArea5, JTextArea textArea6, JTextArea textArea7){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(user.getId());
                if(new EditEmployeeDao().searchUser(user)!= null){
                          panel.setVisible(true);
                          System.out.println(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getGender() + " " + user.getPosition() + " " + user.getSalary() + " " + user.getPhone() + " " + user.getEmail());
                            textArea.setText(user.getId());
                            textArea1.setText(user.getName());
                            textArea2.setText(String.valueOf(user.getAge()));
                            textArea3.setText(user.getGender());
                            textArea4.setText(user.getPosition());
                            textArea5.setText(user.getSalary());
                            textArea6.setText(user.getPhone());
                            textArea7.setText(user.getEmail());

                } else {
                    new Notification("Not Found!").setVisible(true);
                }
            }
        });
    }
    public void saveUser(JButton btn, User user){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new EditEmployeeDao().saveUser(user) == 1){
                    new Notification("Save successfully!").setVisible(true);
                } else {
                    new Notification("Save failed!").setVisible(true);
                }
            }
        });
    }

    public void deleteUser(JButton btn, User user, JPanel panel){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new EditEmployeeDao().deleteUser(user) == 1){
                    new Notification("Delete successfully!").setVisible(true);
                    panel.setVisible(false);

                } else {
                    new Notification("Delete failed!").setVisible(true);
                }
            }
        });
    }
}
