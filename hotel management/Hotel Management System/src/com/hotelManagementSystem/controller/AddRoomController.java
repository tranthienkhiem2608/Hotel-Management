package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.AddRoomDao;
import com.hotelManagementSystem.entity.Room;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomController {
    public void addRoomBtn(JButton btn, Room room){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(room.getRoomNumber() + " " + room.getAvailability() + " " + room.getCleaningStatus() + " " + room.getPrice() + " " + room.getBedType());
                int flag = new AddRoomDao().addRoom(room);
                if(flag == 1){
                    new Notification("Add room successfully!").setVisible(true);
                } else if (flag == 2) {
                    new Notification("Room already exists!").setVisible(true);
                } else {
                    new Notification("Add room failed!").setVisible(true);
                }
            }
        });
}}
