package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hotelManagementSystem.views.ManagerDashboard;

import javax.swing.*;

public class ManagerDashboardDao {
    private final Conn conn = new Conn();

    public String setTextNameUser(String id){
        String query = "SELECT users.*, account.* FROM users JOIN account ON users.id = account.id WHERE users.id = ?";
        try{
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getString("name");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
        return null;
    }
}
