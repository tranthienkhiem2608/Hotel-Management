package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerInfoDao {
    private Customer customer;
    private final Conn conn = new Conn();

    public void viewCustomerInfo(JTable table, DefaultTableModel tableModel){
        customer = new Customer();
        String dateTime ="";
        String dateTimeOut = "";

        try{
            String query = "SELECT * FROM customer";
            String query1 = "SELECT room.price FROM customer JOIN room ON customer.roomNumber = room.roomNumber WHERE customer.roomNumber = ? ";

            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
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
                    PreparedStatement pstmt1 = conn.getConnection().prepareStatement(query1);
                    pstmt1.setInt(1, customer.getRoomNumber());
                    ResultSet rs1 = pstmt1.executeQuery();
                    long diff = customer.getCheckOutDate().getTime() - customer.getCheckInDate().getTime();
                    int diffDays = (int) (diff / (1000 * 60 * 60 * 24));
                    int price = 0;
                    while (rs1.next()) {
                        price = rs1.getInt("price") * diffDays;
                    }
                    dateTime = customer.getCheckInDate().toString() + " " + customer.getCheckInTime().toString();
                    dateTimeOut = customer.getCheckOutDate().toString() + " " + customer.getCheckOutTime().toString();
                    Object[] rowData = {customer.getDocument(), customer.getNumberID(), customer.getName(), customer.getGender(), customer.getPhone(), customer.getRoomNumber(), dateTime, dateTimeOut, price, customer.getDeposit()};
                    tableModel.addRow(rowData);

                }

            table.setModel(tableModel);
            table.setRowHeight(30);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }

    }

    public void searchCustomerByName(JTable table, DefaultTableModel model, Customer customer){
        String dateTime ="";
        String dateTimeOut = "";
        try{
            String query = "SELECT * FROM customer WHERE name LIKE ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, "%" + customer.getName() + "%");
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
                dateTime = customer.getCheckInDate().toString() + " " + customer.getCheckInTime().toString();
                dateTimeOut = customer.getCheckOutDate().toString() + " " + customer.getCheckOutTime().toString();
                Object[] rowData = {customer.getDocument(), customer.getNumberID(), customer.getName(), customer.getGender(), customer.getPhone(), customer.getRoomNumber(), dateTime, dateTimeOut, customer.getDeposit()};
                model.addRow(rowData);

            }
            table.setModel(model);
            table.setRowHeight(30);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }
}
