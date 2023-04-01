package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.entity.Driver;
import com.hotelManagementSystem.dao.DriverInfoDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverInfoController {

    public void btnFind(JButton btn, JTable table, DefaultTableModel tableModel, Driver driver){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                System.out.println(driver.getCarBrand());
                DriverInfoDao driverInfoDao = new DriverInfoDao();
                driverInfoDao.findDriver(driver, table, tableModel);
            }
        });
    }

    public void btnRefresh(JButton btn, JTable table, JComboBox comboBox, DefaultTableModel tableModel){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                DriverInfoDao driverInfoDao = new DriverInfoDao();
                driverInfoDao.viewDriverInfo(table, tableModel, comboBox);
            }
        });
    }
}
