package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.EmployeeInfoDao;
import com.hotelManagementSystem.views.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeInfoController {

    public void ChangeToEdit(JButton btn, String userID){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditEmployee(userID).setVisible(true);
            }
        });
    }

    public void refreshBtn(JButton btn, JTable table, DefaultTableModel model){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                new EmployeeInfoDao().showEmployee(table, model);
            }
        });
    }
}
