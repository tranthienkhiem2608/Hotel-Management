package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.HistoryCustomerDao;
import com.hotelManagementSystem.entity.HistoryCus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HistoryCustomerController {
    public void btnRefresh(JButton btn, JTable table, DefaultTableModel model){
        btn.addActionListener(e -> {
            model.setRowCount(0);
            new HistoryCustomerDao().viewCustomerInfo(table, model);
        });
    }

    public void btnSearch(JButton btn, JTable table, DefaultTableModel model, HistoryCus historyCustomer){
        btn.addActionListener(e -> {
            model.setRowCount(0);
            new HistoryCustomerDao().searchCustomerByName(table, model, historyCustomer);
        });
    }
}
