package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateRoomDao {
    private final Conn conn = new Conn();

    public Room getRoomInfo(Room room){
        try{

            String query = "SELECT * FROM room WHERE roomNumber = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, room.getRoomNumber());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setAvailability(rs.getString("availability"));
                room.setCleaningStatus(rs.getString("cleaningStatus"));
                room.setBedType(rs.getString("bedType"));
                room.setPrice(rs.getInt("price"));
            }
            return room;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int updateRoom(Room room){
        try {

            String query = "UPDATE room SET price = ?, bedType = ? WHERE roomNumber = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, room.getPrice());
            pstmt.setString(2, room.getBedType());
            pstmt.setInt(3, room.getRoomNumber());
            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public void refreshRoom(JComboBox comboBox){
        String query = "SELECT roomNumber FROM room WHERE availability = 'available'";
        try{
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            comboBox.removeAllItems();
            while(rs.next()){
                comboBox.addItem(rs.getInt("roomNumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
    }
}
