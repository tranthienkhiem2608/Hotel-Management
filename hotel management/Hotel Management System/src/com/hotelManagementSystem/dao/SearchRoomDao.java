package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class SearchRoomDao {
    private final Conn conn = new Conn();

    public void showRoom(JTable table, Room room){
        String query = "select * from room where bedType = '"+room.getBedType()+"'";
        String query1 = "select * from Room where availability = 'available' AND bedType = '"+room.getBedType()+"'";
        String query2 = "select * from Room where availability = 'occupied' AND bedType = '"+room.getBedType()+"'";
        String query3 = "Select * from Room";
        String query4 = "select * from Room where availability = 'available'";
        String query5 = "select * from Room where availability = 'occupied'";
        try{
            if(room.getBedType() == "All") {
                if (room.getAvailability() == "available") {
                    ResultSet rs1 = conn.getStatment().executeQuery(query4);
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                } else if (room.getAvailability() == "occupied") {
                    ResultSet rs2 = conn.getStatment().executeQuery(query5);
                    table.setModel(DbUtils.resultSetToTableModel(rs2));
                } else {
                    ResultSet rs = conn.getStatment().executeQuery(query3);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }else {

                if (room.getAvailability() == "available") {
                    ResultSet rs1 = conn.getStatment().executeQuery(query1);
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                } else if (room.getAvailability() == "occupied") {
                    ResultSet rs2 = conn.getStatment().executeQuery(query2);
                    table.setModel(DbUtils.resultSetToTableModel(rs2));
                } else {
                    ResultSet rs = conn.getStatment().executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
    }
}
