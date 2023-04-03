package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.CheckOutDao;
import com.hotelManagementSystem.dao.UpdateCheckDao;
import com.hotelManagementSystem.entity.Customer;
import com.hotelManagementSystem.views.CheckOut;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutController {

    public Customer btnCheckCustomer(JButton btn, Customer customer, JTextArea txt_RoomNumber, JTextArea txt_Time){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new CheckOutDao().checkCustomer(customer) == null) {
                    new Notification("Customer not found").setVisible(true);

                } else {
                    txt_RoomNumber.setText(String.valueOf(customer.getRoomNumber()));
                    txt_Time.setText(customer.getCheckInDate() + " " + customer.getCheckInTime());
                }

            }
        });
        return customer;

    }

    public void btnCheckOut(JButton btn, Customer cusstomer){

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cusstomer.getDeposit() + " " + cusstomer.getRoomNumber() + " " + cusstomer.getCheckInDate() + " " + cusstomer.getCheckInTime() + " " + cusstomer.getCheckOutDate() + " " + cusstomer.getCheckOutTime());
                int flag = new CheckOutDao().checkOut(cusstomer);
                if(flag == 1){
                    new Notification("Check out successfully").setVisible(true);
                } else if (flag ==2) {
                    new Notification("DEPOSIT IS NOT ENOUGH").setVisible(true);
                } else{
                    new Notification("Check out failed").setVisible(true);
                }
            }
        });
    }

    public void refreshBtn(JButton btn, JComboBox comboBox){
        btn.addActionListener(e -> {
            comboBox.removeAllItems();
            new CheckOutDao().refreshID(comboBox);
        });
    }
}
