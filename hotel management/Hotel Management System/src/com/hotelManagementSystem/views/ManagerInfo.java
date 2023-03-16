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

import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerInfo extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAge;
    private JLabel lblJob;
    private JLabel lblGender;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerInfo frame = new ManagerInfo();
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
    public ManagerInfo() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(430, 200, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

//      Sử dụng db
//        JButton btnLoadData = new JButton("Load Data");
//        btnLoadData.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    conn c = new conn();
//                    String displayCustomersql = "select * from Employee where job = 'Manager'";
//                    ResultSet rs = c.s.executeQuery(displayCustomersql);
//                    table.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                catch(Exception e1){
//                    e1.printStackTrace();
//                }
//            }
//
//        });
//        btnLoadData.setBounds(350, 500, 120, 30);
//        btnLoadData.setBackground(Color.BLACK);
//        btnLoadData.setForeground(Color.WHITE);
//        contentPane.add(btnLoadData);
//
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

        getContentPane().setBackground(Color.WHITE);
        lblID = new JLabel("ID");
        lblID.setBounds(40, 20, 46, 16);
        lblID.setBorder(null);
        lblID.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblID);

        lblName = new JLabel("Name");
        lblName.setBounds(125, 20, 46, 16);
        lblName.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblName);

        lblAge = new JLabel("Age");
        lblAge.setBounds(240, 20, 46, 16);
        lblAge.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblAge);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(340, 20, 46, 16);
        lblGender.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(lblGender);

        lblJob = new JLabel("Job");
        lblJob.setBounds(480, 20, 86, 16);
        lblJob.setBorder(null);
        lblJob.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJob.setBackground(Color.decode("#292c35"));
        lblJob.setForeground(Color.decode("#f0f5f5"));
        contentPane.add(lblJob);

        JButton l1 = new JButton("Salary");
        l1.setBounds(550, 20, 86, 16);
        l1.setBorder(null);
        l1.setFont(new Font("Arial", Font.PLAIN, 13));
        l1.setBackground(Color.decode("#292c35"));
        l1.setForeground(Color.decode("#f0f5f5"));
        contentPane.add(l1);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(700, 20, 86, 16);
        l2.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(l2);

        JLabel l3 = new JLabel("Email");
        l3.setBounds(850, 20, 86, 16);
        l3.setFont(new Font("Arial", Font.PLAIN, 13));
        contentPane.add(l3);

        //getContentPane().setBackground(Color.WHITE);
    }
}
