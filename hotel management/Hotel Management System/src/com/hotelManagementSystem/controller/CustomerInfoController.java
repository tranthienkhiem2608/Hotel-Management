package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.CustomerInfoDao;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerInfoController {

    public void btnRefresh(JButton btn, JTable table, DefaultTableModel model){
        btn.addActionListener(e -> {
            model.setRowCount(0);
            new CustomerInfoDao().viewCustomerInfo(table, model);
        });
    }

    public void btnSearch(JButton btn, JTable table, DefaultTableModel model, Customer customer){
        btn.addActionListener(e -> {
            model.setRowCount(0);
            new CustomerInfoDao().searchCustomerByName(table, model, customer);
        });
    }
}
