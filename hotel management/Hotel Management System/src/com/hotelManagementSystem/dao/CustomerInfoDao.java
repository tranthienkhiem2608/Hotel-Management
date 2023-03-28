package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerInfoDao {
    private Customer customer;
    public void viewCustomerInfo(JTable table, DefaultTableModel tableModel){
        customer = new Customer();
        String dateTime ="";
        Conn conn = new Conn();
        try{
            String query = "SELECT * FROM customer";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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
                dateTime = customer.getCheckInDate().toString() + " " + customer.getCheckInTime().toString();
                Object[] rowData = {customer.getDocument(), customer.getNumberID(), customer.getName(), customer.getGender(), customer.getCountry(), customer.getRoomNumber(), dateTime, customer.getDeposit()};
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
        Conn conn = new Conn();
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
                customer.setCountry(rs.getString("country"));
                customer.setRoomNumber(rs.getInt("roomNumber"));
                customer.setCheckInDate(rs.getDate("checkInDate"));
                customer.setCheckInTime(rs.getTime("checkInTime"));
                customer.setDeposit(rs.getInt("deposit"));
                dateTime = customer.getCheckInDate().toString() + " " + customer.getCheckInTime().toString();
                Object[] rowData = {customer.getDocument(), customer.getNumberID(), customer.getName(), customer.getGender(), customer.getCountry(), customer.getRoomNumber(), dateTime, customer.getDeposit()};
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
