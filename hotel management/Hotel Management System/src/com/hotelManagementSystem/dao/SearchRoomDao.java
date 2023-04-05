package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;

public class SearchRoomDao {
    private final Conn conn = new Conn();

    public void showRoom(JTable table, Room room, DefaultTableModel model){
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

                    while (rs1.next()) {
                        room.setRoomNumber(rs1.getInt("roomNumber"));
                        room.setAvailability(rs1.getString("availability"));
                        room.setCleaningStatus(rs1.getString("cleaningStatus"));
                        room.setPrice(rs1.getInt("price"));
                        room.setBedType(rs1.getString("bedType"));
                        Object[] rowData = {room.getRoomNumber(), room.getAvailability(), room.getCleaningStatus(), room.getPrice(), room.getBedType()};
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                } else if (room.getAvailability() == "occupied") {
                    ResultSet rs2 = conn.getStatment().executeQuery(query5);
                    while (rs2.next()) {
                        room.setRoomNumber(rs2.getInt("roomNumber"));
                        room.setAvailability(rs2.getString("availability"));
                        room.setCleaningStatus(rs2.getString("cleaningStatus"));
                        room.setPrice(rs2.getInt("price"));
                        room.setBedType(rs2.getString("bedType"));
                        Object[] rowData = {room.getRoomNumber(), room.getAvailability(), room.getCleaningStatus(), room.getPrice(), room.getBedType()};
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                } else {
                    ResultSet rs = conn.getStatment().executeQuery(query3);
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
                }
            }else {

                if (room.getAvailability() == "available") {
                    ResultSet rs1 = conn.getStatment().executeQuery(query1);
                    while (rs1.next()) {
                        room.setRoomNumber(rs1.getInt("roomNumber"));
                        room.setAvailability(rs1.getString("availability"));
                        room.setCleaningStatus(rs1.getString("cleaningStatus"));
                        room.setPrice(rs1.getInt("price"));
                        room.setBedType(rs1.getString("bedType"));
                        Object[] rowData = {room.getRoomNumber(), room.getAvailability(), room.getCleaningStatus(), room.getPrice(), room.getBedType()};
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                } else if (room.getAvailability() == "occupied") {
                    ResultSet rs2 = conn.getStatment().executeQuery(query2);
                    while (rs2.next()) {
                        room.setRoomNumber(rs2.getInt("roomNumber"));
                        room.setAvailability(rs2.getString("availability"));
                        room.setCleaningStatus(rs2.getString("cleaningStatus"));
                        room.setPrice(rs2.getInt("price"));
                        room.setBedType(rs2.getString("bedType"));
                        Object[] rowData = {room.getRoomNumber(), room.getAvailability(), room.getCleaningStatus(), room.getPrice(), room.getBedType()};
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                } else {
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
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
    }
}
