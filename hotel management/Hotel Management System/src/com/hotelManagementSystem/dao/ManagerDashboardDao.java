package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hotelManagementSystem.views.ManagerDashboard;

import javax.swing.*;

public class ManagerDashboardDao {

    public void setTextNameUser(String id, JTextArea txtName){
        String query = "SELECT users.*, account.* FROM users JOIN account ON users.id = account.id WHERE users.id = ?";
        Conn conn = new Conn();
        try{
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                txtName.setText(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }
}
