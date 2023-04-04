package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import net.proteanit.sql.DbUtils;
import com.hotelManagementSystem.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerInfoDao {
    private User user;
    private final Conn conn = new Conn();

    public void showManager(JTable table, DefaultTableModel tableModel){
        user = new User();

        try{

            String query = "select * from users where position = 'manager'";
            PreparedStatement stmt  = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setPosition(rs.getString("position"));
                user.setSalary(rs.getString("salary"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                Object[] rowData = {user.getId(), user.getName(), user.getAge(), user.getGender(), user.getPosition(), user.getSalary(), user.getPhone(), user.getEmail()};
                tableModel.addRow(rowData);
            }
            table.setModel(tableModel);
            table.setRowHeight(30);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }

    }
}
