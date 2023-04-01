package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Driver;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DriverInfoDao {

    private Driver driver;
    private Conn conn = new Conn();

    public void viewDriverInfo(JTable table, DefaultTableModel tableModel, JComboBox comboBox) {
        driver = new Driver();

        try {
            comboBox.removeAllItems();
            ResultSet rs1 = conn.s.executeQuery("select * from drivers");
            while(rs1.next()){
                comboBox.addItem(rs1.getString("carBrand"));
            }

            String query = "SELECT * FROM drivers";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                driver.setName(rs.getString("name"));
                driver.setAge(rs.getInt("age"));
                driver.setGender(rs.getString("gender"));
                driver.setPhone(rs.getString("phone"));
                driver.setCarBrand(rs.getString("carBrand"));
                driver.setAvailable(rs.getString("available"));
                driver.setLocation(rs.getString("location"));
                Object[] rowData = {driver.getName(), driver.getAge(), driver.getGender(), driver.getPhone(), driver.getCarBrand(), driver.getAvailable(), driver.getLocation()};
                tableModel.addRow(rowData);
            }
            table.setModel(tableModel);
            table.setRowHeight(30);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }

    }

    public void findDriver(Driver driver, JTable table, DefaultTableModel tableModel) {
        try {
            String query = "SELECT * FROM drivers WHERE carBrand = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1,  driver.getCarBrand());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                driver.setName(rs.getString("name"));
                driver.setAge(rs.getInt("age"));
                driver.setGender(rs.getString("gender"));
                driver.setPhone(rs.getString("phone"));
                driver.setCarBrand(rs.getString("carBrand"));
                driver.setAvailable(rs.getString("available"));
                driver.setLocation(rs.getString("location"));
                Object[] rowData = {driver.getName(), driver.getAge(), driver.getGender(), driver.getPhone(), driver.getCarBrand(), driver.getAvailable(), driver.getLocation()};
                tableModel.addRow(rowData);
            }
            table.setModel(tableModel);
            table.setRowHeight(30);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            conn.closeConnection();
        }
    }
}
