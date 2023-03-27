package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.NewCustomerDao;
import com.hotelManagementSystem.entity.Customer;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;


public class NewCustomerController {
    public void addNewCustomer(JButton btn, Customer customer){
        btn.addActionListener(e -> {
            System.out.println(customer.getDocument() + " " + customer.getNumberID() + " " + customer.getName() + " " + customer.getGender() + " " + customer.getCountry() + " " + customer.getRoomNumber() + " " + customer.getCheckInTime() + " " + customer.getDeposit());
            int flag = new NewCustomerDao().addNewCustomer(customer);
            if(flag == 1){
                new Notification("Customer added successfully").setVisible(true);
            } else {
                new Notification("Customer added failed").setVisible(true);
            }
        });
    }

    }
