package com.hotelManagementSystem.controller;

import com.hotelManagementSystem.dao.SearchRoomDao;
import com.hotelManagementSystem.entity.Room;

import javax.swing.*;

public class SearchRoomController {

    public void searchRoom(JButton searchRoomButton, JTable table, Room room){
        searchRoomButton.addActionListener(e -> {
            System.out.println(room.getBedType() + " " + room.getAvailability());
            SearchRoomDao searchRoomDao = new SearchRoomDao();
            searchRoomDao.showRoom(table, room);
        });

    }
}
