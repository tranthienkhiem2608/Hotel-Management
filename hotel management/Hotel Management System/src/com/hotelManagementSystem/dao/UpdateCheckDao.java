package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateCheckDao {

    public Customer getCustomerInfo(Customer customer){
        try{
            Conn conn = new Conn();
            String query = "SELECT * FROM customer WHERE numberID = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, customer.getNumberID());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                customer.setDocument(rs.getString("document"));
                customer.setNumberID(rs.getString("numberID"));
                customer.setName(rs.getString("name"));
                customer.setGender(rs.getString("gender"));
                customer.setCountry(rs.getString("country"));
                customer.setRoomNumber(rs.getInt("roomNumber"));
                customer.setCheckInDate(rs.getDate("checkInDate"));
                customer.setCheckInTime(rs.getTime("checkInTime"));
                customer.setDeposit(rs.getInt("deposit"));
            }
            return customer;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getPriceRoom(Customer customer){
        try{
            Conn conn = new Conn();
            String query = "SELECT price FROM room WHERE roomNumber = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, customer.getRoomNumber());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                return rs.getInt("price");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


    public int updateCustomer(Customer customer){
        try {
            Conn conn = new Conn();
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
        }
    }
}
