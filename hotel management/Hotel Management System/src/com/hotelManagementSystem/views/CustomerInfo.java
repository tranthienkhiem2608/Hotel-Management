package com.hotelManagementSystem.views;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotelManagementSystem.controller.CustomerInfoController;
import com.hotelManagementSystem.dao.CustomerInfoDao;
import com.hotelManagementSystem.dao.EmployeeInfoDao;
import com.hotelManagementSystem.entity.Customer;
import net.proteanit.sql.DbUtils;
import java.sql.*;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
    Connection conn = null;
    private  static JPanel p1;
    private JButton btnSearch;
    private JTextField textField;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblCountry;
    private JLabel lblRoom;
    private JLabel lblStatus;
    private JLabel lblNewLabel_1;
    private Customer customer;

    public JPanel getP1() {
        return p1;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerInfo frame = new CustomerInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public CustomerInfo(){
        initComponent();
    }

    private void initComponent(){
        p1 = new JPanel();
        p1.setSize(1000, 600);
        setContentPane(p1);
        p1.setLayout(null);
        customer = new Customer();

        String[] columnNames = {"ID", "Number", "Name", "Gender", "Country", "Room", "Check-in Status", "Deposit"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(0, 40, 950, 450);
        table.enableInputMethods(false);
        p1.add(table);

        try{
            CustomerInfoDao customerInfoDao = new CustomerInfoDao();
            customerInfoDao.viewCustomerInfo(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(500, 500, 120, 30);
        btnRefresh.setBackground(Color.BLACK);
        btnRefresh.setForeground(Color.WHITE);
        new CustomerInfoController().btnRefresh(btnRefresh, table, tableModel);
        p1.add(btnRefresh);

        textField = new JTextField();
        textField.setBounds(40, 500, 250, 30);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customer.setName(textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customer.setName(textField.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customer.setName(textField.getText());

            }
        });
        p1.add(textField);

        //clear table previous data


        btnSearch = new JButton("Search");
        btnSearch.setBounds(300, 500, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new CustomerInfoController().btnSearch(btnSearch, table, tableModel, customer);
        p1.add(btnSearch);



        lblId = new JLabel("ID");
        lblId.setBounds(40, 20, 46, 16);
        lblId.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(125, 20, 46, 16);
        l1.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(240, 20, 46, 16);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(360, 20, 46, 16);
        lblGender.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblGender);

        lblCountry = new JLabel("Country");
        lblCountry.setBounds(480, 20, 46, 16);
        lblCountry.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblCountry);

        lblRoom = new JLabel("Room");
        lblRoom.setBounds(600, 20, 46, 16);
        lblRoom.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblRoom);

        lblStatus = new JLabel("Check-in Status");
        lblStatus.setBounds(680, 20, 100, 16);
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
        p1.add(lblStatus);

        lblNewLabel_1 = new JLabel("Deposit");
        lblNewLabel_1.setBounds(850, 20, 100, 16);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
}
