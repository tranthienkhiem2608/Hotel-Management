package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateCheckDao {
    private Conn conn = new Conn();
    public Customer getCustomerInfo(Customer customer){
        try{
            String query = "SELECT * FROM customer WHERE numberID = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, customer.getNumberID());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                customer.setDocument(rs.getString("document"));
                customer.setNumberID(rs.getString("numberID"));
                customer.setName(rs.getString("name"));
                customer.setGender(rs.getString("gender"));
                customer.setPhone(rs.getString("phone"));
                customer.setRoomNumber(rs.getInt("roomNumber"));
                customer.setCheckInDate(rs.getDate("checkInDate"));
                customer.setCheckInTime(rs.getTime("checkInTime"));
                customer.setCheckOutDate(rs.getDate("checkOutDate"));
                customer.setCheckOutTime(rs.getTime("checkOutTime"));
                customer.setDeposit(rs.getInt("deposit"));
            }
            return customer;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
        return null;
    }

    public int getPriceRoom(Customer customer){
        try{
            String query = "SELECT price FROM room WHERE roomNumber = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, customer.getRoomNumber());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                return rs.getInt("price");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
        return 0;
    }


    public int updateCustomer(Customer customer){
        try {
            String query = "UPDATE customer SET name = ?, roomNumber = ?, deposit = ? WHERE numberID = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, customer.getName());
            pstmt.setInt(2, customer.getRoomNumber());
            pstmt.setInt(3, customer.getDeposit());
            pstmt.setString(4, customer.getNumberID());
            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        } finally {
            conn.closeConnection();
        }
    }

    public void refreshID(JComboBox comboBox){

        try{
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                comboBox.addItem(rs.getString("numberID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
    }
}
