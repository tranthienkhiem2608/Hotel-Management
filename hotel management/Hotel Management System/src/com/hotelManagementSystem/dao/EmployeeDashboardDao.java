package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hotelManagementSystem.views.EmployeeDashboard;

import javax.swing.*;

public class EmployeeDashboardDao {
    public void setTextNameUser(String id, JTextArea txtName){
        Conn conn = new Conn();
        String query = "SELECT users.*, account.* FROM users JOIN account ON users.id = account.id WHERE users.id = ?";
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
