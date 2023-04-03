package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.HistoryCus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryCustomerDao {

    private HistoryCus historyCustomer;
    private Conn conn = new Conn();
    public void viewCustomerInfo (JTable table, DefaultTableModel tableModel){

        historyCustomer = new HistoryCus();
        String dateTimeIn ="";
        String dateTimeOut ="";
        try{
            String query = "SELECT * FROM HistoryCustomer";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                historyCustomer.setDocument(rs.getString("document"));
                historyCustomer.setNumberID(rs.getString("numberID"));
                historyCustomer.setName(rs.getString("name"));
                historyCustomer.setGender(rs.getString("gender"));
                historyCustomer.setPhone(rs.getString("phone"));
                historyCustomer.setRoomNumber(rs.getInt("roomNumber"));
                historyCustomer.setCheckInDate(rs.getDate("checkInDate"));
                historyCustomer.setCheckInTime(rs.getTime("checkInTime"));
                historyCustomer.setCheckOutDate(rs.getDate("checkOutDate"));
                historyCustomer.setCheckOutTime(rs.getTime("checkOutTime"));
                historyCustomer.setDeposit(rs.getInt("deposit"));
                dateTimeIn = historyCustomer.getCheckInDate().toString() + " " + historyCustomer.getCheckInTime().toString();
                dateTimeOut = historyCustomer.getCheckOutDate().toString() + " " + historyCustomer.getCheckOutTime().toString();
                Object[] rowData = {historyCustomer.getDocument(), historyCustomer.getNumberID(), historyCustomer.getName(), historyCustomer.getGender(), historyCustomer.getPhone(), historyCustomer.getRoomNumber(), dateTimeIn, dateTimeOut, historyCustomer.getDeposit()};
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

    public void searchCustomerByName(JTable table, DefaultTableModel model, HistoryCus historyCustomer){
        String dateTime ="";
        String dateTimeOut ="";
        try{
            String query = "SELECT * FROM HistoryCustomer WHERE name LIKE ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, "%" + historyCustomer.getName() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                historyCustomer.setDocument(rs.getString("document"));
                historyCustomer.setNumberID(rs.getString("numberID"));
                historyCustomer.setName(rs.getString("name"));
                historyCustomer.setGender(rs.getString("gender"));
                historyCustomer.setPhone(rs.getString("phone"));
                historyCustomer.setRoomNumber(rs.getInt("roomNumber"));
                historyCustomer.setCheckInDate(rs.getDate("checkInDate"));
                historyCustomer.setCheckInTime(rs.getTime("checkInTime"));
                historyCustomer.setCheckOutDate(rs.getDate("checkOutDate"));
                historyCustomer.setCheckOutTime(rs.getTime("checkOutTime"));
                historyCustomer.setDeposit(rs.getInt("deposit"));
                dateTime = historyCustomer.getCheckInDate().toString() + " " + historyCustomer.getCheckInTime().toString();
                dateTimeOut = historyCustomer.getCheckOutDate().toString() + " " + historyCustomer.getCheckOutTime().toString();
                Object[] rowData = {historyCustomer.getDocument(), historyCustomer.getNumberID(), historyCustomer.getName(), historyCustomer.getGender(), historyCustomer.getPhone(), historyCustomer.getRoomNumber(), dateTime, dateTimeOut, historyCustomer.getDeposit()};
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
