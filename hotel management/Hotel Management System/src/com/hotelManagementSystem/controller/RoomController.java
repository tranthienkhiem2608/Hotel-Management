package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.RoomDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomController {
    public void btnRefesh(JButton btn , JTable table, DefaultTableModel model){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomDao roomDao = new RoomDao();
                roomDao.showRoom(table, model); ;
            }
        });
    }

}
