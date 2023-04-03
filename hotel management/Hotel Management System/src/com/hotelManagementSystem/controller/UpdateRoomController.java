package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.NewCustomerDao;
import com.hotelManagementSystem.dao.UpdateRoomDao;
import com.hotelManagementSystem.entity.Room;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.awt.*;

public class UpdateRoomController {
    public void btnCheckRoom(JButton btn, Room room, JTextField t1 , JTextField t2){
        btn.addActionListener(e -> {
            System.out.println(room.getRoomNumber());
            if(new UpdateRoomDao().getRoomInfo(room) == null){
                new Notification("Customer not found").setVisible(true);
            }else{
                t1.setText(String.valueOf(room.getPrice()));
                t2.setText(room.getBedType());
            }
        });
    }

    public void btnUpdate(JButton btn, Room room){
        btn.addActionListener(e -> {
            if(new UpdateRoomDao().updateRoom(room) == 1){
                new Notification("Update successfully").setVisible(true);
            }else{
                new Notification("Update failed").setVisible(true);
            }
        });
    }

    public void refreshBtn(JButton btn, JComboBox comboBox){
        btn.addActionListener(e -> {
            comboBox.removeAllItems();
            new UpdateRoomDao().refreshRoom(comboBox);
        });
    }
}
