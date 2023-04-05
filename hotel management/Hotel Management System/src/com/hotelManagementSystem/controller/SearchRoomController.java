package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.dao.SearchRoomDao;
import com.hotelManagementSystem.entity.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchRoomController {

    public void searchRoom(JButton searchRoomButton, JTable table, Room room, DefaultTableModel model){
        searchRoomButton.addActionListener(e -> {
            model.setRowCount(0);
            System.out.println(room.getBedType() + " " + room.getAvailability());
            SearchRoomDao searchRoomDao = new SearchRoomDao();
            searchRoomDao.showRoom(table, room, model);
        });

    }
}
