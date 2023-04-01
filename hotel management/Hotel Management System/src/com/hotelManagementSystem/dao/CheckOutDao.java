package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckOutDao {
    private Conn conn = new Conn();

    public Customer checkCustomer(Customer customer){
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


    public int checkOut(Customer customer){
        //check deposit of customer with price of room at room number
        long diff = customer.getCheckOutDate().getTime() - customer.getCheckInDate().getTime();
        int diffDays = (int) (diff / (1000 * 60 * 60 * 24));
        String query = "SELECT price FROM room WHERE roomNumber = ?";
        String query1 = "SELECT customer.*, room.* FROM customer JOIN room ON customer.roomNumber = room.roomNumber WHERE customer.roomNumber = ? AND customer.deposit = ?";
        String query2 = "Delete from customer where numberID = "+customer.getNumberID();
        String query3 = "update room set availability = 'available' where roomNumber = "+ customer.getRoomNumber();
        String query4 = "INSERT INTO HistoryCustomer (document, numberID, name, gender, phone, roomNumber,checkindate, checkintime,checkoutdate, checkouttime, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            int price = 0;
            PreparedStatement pstmt4 = conn.getConnection().prepareStatement(query);
            pstmt4.setInt(1, customer.getRoomNumber());
            ResultSet rs1 = pstmt4.executeQuery();
            if(rs1.next()){
                int priceRoom = rs1.getInt("price");
                price = priceRoom * diffDays;
            }
            else {
                JOptionPane.showMessageDialog(null, "Room number is not exist");
            }
            System.out.println(price + " " + customer.getDeposit());
            if (price <= customer.getDeposit()){
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query1);
                pstmt.setString(1, customer.getNumberID());
                pstmt.setString(2, Integer.toString(customer.getDeposit()));
                ResultSet rs = pstmt.executeQuery();
                if (!rs.next()) {
                    java.sql.Date sqlDateIn = new java.sql.Date(customer.getCheckInDate().getTime());
                    java.sql.Time sqlTimeIn = new java.sql.Time(customer.getCheckInTime().getTime());
                    java.sql.Date sqlDateOut = new java.sql.Date(customer.getCheckOutDate().getTime());
                    java.sql.Time sqlTimeOut = new java.sql.Time(customer.getCheckOutTime().getTime());
                    PreparedStatement pstmt3 = conn.getConnection().prepareStatement(query4);
                    pstmt3.setString(1, customer.getDocument());
                    pstmt3.setString(2, customer.getNumberID());
                    pstmt3.setString(3, customer.getName());
                    pstmt3.setString(4, customer.getGender());
                    pstmt3.setString(5, customer.getPhone());
                    pstmt3.setInt(6, customer.getRoomNumber());
                    pstmt3.setDate(7, sqlDateIn);
                    pstmt3.setTime(8, sqlTimeIn);
                    pstmt3.setDate(9, sqlDateOut);
                    pstmt3.setTime(10, sqlTimeOut);
                    pstmt3.setInt(11, customer.getDeposit());
                    pstmt3.executeUpdate();
                    PreparedStatement pstmt1 = conn.getConnection().prepareStatement(query2);
                    pstmt1.executeUpdate();
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query3);
                    pstmt2.executeUpdate();
                    return 1;
                } else {
                    return 2;
                }
            }
            else {
                return 2;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
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
