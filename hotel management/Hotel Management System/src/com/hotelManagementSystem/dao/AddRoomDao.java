package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.entity.Room;
import com.hotelManagementSystem.conn.*;

import java.sql.ResultSet;

public class AddRoomDao {

    private final Conn conn = new Conn();

    public int addRoom(Room room){
        try{
            String query1 = "select * from Room where roomNumber = '" + room.getRoomNumber() + "'";
            ResultSet rs = conn.getStatment().executeQuery(query1);
            if(!rs.next()) {
                String query2 = "insert into Room values('" + room.getRoomNumber() + "', '" + room.getAvailability() + "', '" + room.getCleaningStatus() + "', '" + room.getPrice() + "', '" + room.getBedType() + "')";
                conn.getStatment().executeUpdate(query2);
                return 1;
            }else {
                return 2;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }
}
