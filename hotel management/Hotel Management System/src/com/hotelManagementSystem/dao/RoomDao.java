package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class RoomDao {
    private final Conn conn = new Conn();
    private Room room;
    public void showRoom(JTable table, DefaultTableModel model){
        room = new Room();
        try{
            String query = "select * from room";
            ResultSet rs = conn.getStatment().executeQuery(query);
            while (rs.next()) {
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setAvailability(rs.getString("availability"));
                room.setCleaningStatus(rs.getString("cleaningStatus"));
                room.setPrice(rs.getInt("price"));
                room.setBedType(rs.getString("bedType"));
                Object[] rowData = {room.getRoomNumber(), room.getAvailability(), room.getCleaningStatus(), room.getPrice(), room.getBedType()};
                model.addRow(rowData);
            }
            table.setModel(model);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }

    }
}
