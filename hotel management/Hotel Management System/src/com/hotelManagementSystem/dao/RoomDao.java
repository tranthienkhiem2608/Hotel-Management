package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class RoomDao {

    public void showRoom(JTable table){
        try{
            Conn conn = new Conn();
            String query = "select * from room";
            ResultSet rs = conn.getStatment().executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
