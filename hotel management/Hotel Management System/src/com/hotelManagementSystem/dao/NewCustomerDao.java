package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

public class NewCustomerDao {
    private final Conn conn = new Conn();

    public int addNewCustomer(Customer customer) {

        try{
            java.sql.Date sqlDate = new java.sql.Date(customer.getCheckInDate().getTime());
            java.sql.Time sqlTime = new java.sql.Time(customer.getCheckInTime().getTime());
            java.sql.Date sqlDate2 = new java.sql.Date(customer.getCheckOutDate().getTime());
            java.sql.Time sqlTime2 = new java.sql.Time(customer.getCheckOutTime().getTime());
            String query = "INSERT INTO customer (document, numberID, name, gender, phone, roomNumber,checkindate, checkintime,checkoutdate, checkouttime, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, customer.getDocument());
            pstmt.setString(2, customer.getNumberID());
            pstmt.setString(3, customer.getName());
            pstmt.setString(4, customer.getGender());
            pstmt.setString(5, customer.getPhone());
            pstmt.setInt(6, customer.getRoomNumber());
            pstmt.setDate(7, sqlDate);
            pstmt.setTime(8, sqlTime);
            pstmt.setDate(9, sqlDate2);
            pstmt.setTime(10, sqlTime2);
            pstmt.setInt(11, customer.getDeposit());
            int flag = pstmt.executeUpdate();
            String query2 = "UPDATE room SET availability = 'occupied' WHERE roomNumber = ?";
            PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
            pstmt2.setInt(1, customer.getRoomNumber());
            int flag2 = pstmt2.executeUpdate();
            if(flag == 1 && flag2 == 1) {
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }

    public void refreshRoom(JComboBox comboBox){
        String query = "SELECT roomNumber FROM room WHERE availability = 'available'";
        try{
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
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
