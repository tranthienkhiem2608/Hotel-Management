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

import net.proteanit.sql.DbUtils;
import java.sql.*;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblCountry;
    private JLabel lblRoom;
    private JLabel lblStatus;
    private JLabel lblNewLabel_1;

    /**
     * Launch the application.
     */
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
    public void close()
    {
        this.dispose();
    }
    /**
     * Create the frame.
     * @throws SQLException
     */
    public CustomerInfo() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 900, 450);
        contentPane.add(table);

//      Sử dụng db
//
//        JButton btnLoadData = new JButton("Load Data");
//        btnLoadData.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                try{
//                    conn c  = new conn();
//
//                    String displayCustomersql = "select * from Customer";
//                    ResultSet rs = c.s.executeQuery(displayCustomersql);
//                    table.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                catch(Exception e)
//                {
//                    e.printStackTrace();
//                }
//            }
//
//
//        });
//        btnLoadData.setBounds(300, 510, 120, 30);
//        btnLoadData.setBackground(Color.BLACK);
//        btnLoadData.setForeground(Color.WHITE);
//        contentPane.add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ManagerDashboard().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(550, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        lblId = new JLabel("ID");
        lblId.setBounds(40, 20, 46, 16);
        lblId.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(125, 20, 46, 16);
        l1.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(240, 20, 46, 16);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(360, 20, 46, 16);
        lblGender.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblGender);

        lblCountry = new JLabel("Country");
        lblCountry.setBounds(480, 20, 46, 16);
        lblCountry.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblCountry);

        lblRoom = new JLabel("Room");
        lblRoom.setBounds(600, 20, 46, 16);
        lblRoom.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblRoom);

        lblStatus = new JLabel("Check-in Status");
        lblStatus.setBounds(680, 20, 100, 16);
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(lblStatus);

        lblNewLabel_1 = new JLabel("Deposit");
        lblNewLabel_1.setBounds(850, 20, 100, 16);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
}
