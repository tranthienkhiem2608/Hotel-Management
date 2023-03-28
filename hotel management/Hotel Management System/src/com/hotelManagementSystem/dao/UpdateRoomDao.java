package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateRoomDao {
    public Room getRoomInfo(Room room){
        try{
            Conn conn = new Conn();
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
            Conn conn = new Conn();
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
}
