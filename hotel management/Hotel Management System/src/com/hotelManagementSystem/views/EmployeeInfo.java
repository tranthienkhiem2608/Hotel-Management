/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelManagementSystem.views;
import com.hotelManagementSystem.controller.EmployeeDashboardController;
import com.hotelManagementSystem.controller.EmployeeInfoController;
import com.hotelManagementSystem.dao.EmployeeInfoDao;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTable;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class EmployeeInfo extends JFrame {
    private static JPanel p1;
    private JTable table;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAge;
    private JLabel lblJob, p2;
    private JLabel lblSalary;
    private JLabel lblGender;


    public JPanel getP1() {
        return p1;
    }

    public EmployeeInfo(){
        initComponent();
    }

    private void initComponent(){
        p1 = new JPanel();
        p1.setSize(1000, 600);
        p1.setBackground(Color.decode("#fcf6f0"));
        setContentPane(p1);
        p1.setLayout(null);

        p2 = new JLabel();
        p2.setSize(1000, 50);
        setContentPane(p2);
        p2.setLayout(null);
        p1.add(p2);

        JLabel lblPickUpService = new JLabel("EMPLOYEE INFORMATION");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 40));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(300, 10, 600, 50);
        p1.add(lblPickUpService);

        String[] columnNames = {"ID", "Name", "Age", "Gender", "Position", "Salary", "Phone", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(50, 50, 1000, 500);;
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        p1.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 65, 1000, 450);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scrollPane);

        try{
            EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();
            employeeInfoDao.showEmployee(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefesh = new JButton("REFRESH");
        btnRefesh.setBounds(400, 550, 120, 30);
        btnRefesh.setBackground(Color.BLACK);
        btnRefesh.setForeground(Color.WHITE);
        p1.add(btnRefesh);

        getContentPane().setBackground(Color.WHITE);

        JButton btnExit = new JButton("EDIT");
        btnExit.setBounds(550, 550, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        new EmployeeInfoController().ChangeToEdit(btnExit);
        p1.add(btnExit);

        getContentPane().setBackground(Color.WHITE);


        //getContentPane().setBackground(Color.WHITE);
    }
}