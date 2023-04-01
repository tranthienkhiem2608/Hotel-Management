package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.AddDriversDao;
import com.hotelManagementSystem.entity.Driver;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;

public class AddDriversController {
    public void addDriversBtn(JButton btn, Driver driver){
        btn.addActionListener(e -> {
            System.out.println(driver.getName() + " " + driver.getAge() + " " + driver.getGender() + " " + driver.getPhone() + " " + driver.getCarBrand() + " " + driver.getAvailable() + " " + driver.getLocation());
            int flag = new AddDriversDao().addDrivers(driver);
            if(flag == 1){
                new Notification("Add driver successfully!").setVisible(true);
            } else if (flag == 2) {
                new Notification("Driver already exists!").setVisible(true);
            } else {
                new Notification("Add driver failed!").setVisible(true);
            }
        });

    }
}
