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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOutController {

    public Customer btnCheckCustomer(JButton btn, Customer customer, JTextArea txt_RoomNumber, JTextArea txt_Time, JTextArea txt_TimeCheckOut,JTextArea txt_deposit , JTextArea totalPrice){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new CheckOutDao().checkCustomer(customer, totalPrice) == null) {
                    new Notification("Customer not found").setVisible(true);

                } else {
                    txt_RoomNumber.setText(String.valueOf(customer.getRoomNumber()));
                    txt_Time.setText(customer.getCheckInDate() + " " + customer.getCheckInTime());
                    txt_deposit.setText(String.valueOf(customer.getDeposit()));
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date time = new Date();
                    txt_TimeCheckOut.setText(customer.getCheckOutDate() + " " + timeFormat.format(time));
                    customer.setCheckOutTime(time);
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
