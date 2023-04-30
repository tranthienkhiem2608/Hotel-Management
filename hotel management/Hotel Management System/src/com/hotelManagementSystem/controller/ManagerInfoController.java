package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.EmployeeInfoDao;
import com.hotelManagementSystem.dao.ManagerInfoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerInfoController {
    public void refreshBtn(JButton btn, JTable table, DefaultTableModel model){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                new ManagerInfoDao().showManager(table, model);
            }
        });
    }
}
