package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.UpdateCheckDao;
import com.hotelManagementSystem.entity.Customer;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;

public class UpdateCheckController {

    public void btnCheckOut(JButton btn, Customer customer, JTextField txtRoomNumber ,JTextField txtName, JTextArea txtDateTime, JTextField txtDeposit, JTextField txtPayment){
        btn.addActionListener(e -> {
            int price = 0;
            int payment = 0;
            if(new UpdateCheckDao().getCustomerInfo(customer) == null){
                new Notification("Customer not found").setVisible(true);
            }else{
                price = new UpdateCheckDao().getPriceRoom(customer);
                txtRoomNumber.setText(String.valueOf(customer.getRoomNumber()));
                txtName.setText(customer.getName());
                txtDateTime.setText(customer.getCheckInDate() + " " + customer.getCheckInTime());
                payment = price - customer.getDeposit();
                System.out.println(price + " " + customer.getDeposit() + " " + payment);
                txtDeposit.setText(String.valueOf(customer.getDeposit()));
                txtPayment.setText(String.valueOf(payment));
            }
        });
    }

    public void btnUpdate(JButton btn, Customer customer){
        btn.addActionListener(e -> {
            if(new UpdateCheckDao().updateCustomer(customer) == 1){
                new Notification("Update successfully").setVisible(true);
            }else{
                new Notification("Update failed").setVisible(true);
            }
        });
    }
}
