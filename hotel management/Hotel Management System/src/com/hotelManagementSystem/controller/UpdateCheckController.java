package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.UpdateCheckDao;
import com.hotelManagementSystem.entity.Customer;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;

public class UpdateCheckController {

    public void btnCheckOut(JButton btn, Customer customer, JTextField txtRoomNumber ,JTextField txtName, JTextArea txtDateTime, JTextArea txtDateTimeOut, JTextField txtDeposit, JTextField txtPayment){
        btn.addActionListener(e -> {
            int price = 0;
            int payment = 0;
            if(new UpdateCheckDao().getCustomerInfo(customer) == null){
                new Notification("Customer not found").setVisible(true);
            }else{
                price = new UpdateCheckDao().getPriceRoom(customer);
                long milliseconds1 = customer.getCheckInDate().getTime();
                long milliseconds2 = customer.getCheckOutDate().getTime();
//                System.out.println(customer.getCheckInDate() + " " + customer.getCheckInTime());
                long diff = milliseconds2 - milliseconds1;
                long diffDays = diff / (24 * 60 * 60 * 1000);
                price = (int) (price * diffDays);


                txtRoomNumber.setText(String.valueOf(customer.getRoomNumber()));
                txtName.setText(customer.getName());
                txtDateTime.setText(customer.getCheckInDate() + " " + customer.getCheckInTime());
                txtDateTimeOut.setText(customer.getCheckOutDate() + " " + customer.getCheckOutTime());
                payment = price - customer.getDeposit();
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

    public void refreshBtn(JButton btn, JComboBox comboBox){
        btn.addActionListener(e -> {
            comboBox.removeAllItems();
            new UpdateCheckDao().refreshID(comboBox);
        });
    }
}
