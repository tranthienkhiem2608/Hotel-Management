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

        String[] columnNames = {"ID", "Name", "Age", "Gender", "Position", "Salary", "Phone", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(50, 50, 1000, 500);;
        p1.add(table);
        try{
            EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();
            employeeInfoDao.showEmployee(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefesh = new JButton("REFRESH");
        btnRefesh.setBounds(400, 560, 120, 30);
        btnRefesh.setBackground(Color.BLACK);
        btnRefesh.setForeground(Color.WHITE);
        p1.add(btnRefesh);

        getContentPane().setBackground(Color.WHITE);

        JButton btnExit = new JButton("EDIT");
        btnExit.setBounds(550, 560, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        new EmployeeInfoController().ChangeToEdit(btnExit);
        p1.add(btnExit);

        getContentPane().setBackground(Color.WHITE);

        lblID = new JLabel("ID");
        lblID.setBounds(100, 20, 46, 16);
        lblID.setBorder(null);
        lblID.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(lblID);

        lblName = new JLabel("Name");
        lblName.setBounds(215, 20, 46, 16);
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(lblName);

        lblAge = new JLabel("Age");
        lblAge.setBounds(345, 20, 46, 16);
        lblAge.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(lblAge);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(455, 20, 54, 16);
        lblGender.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(lblGender);

        lblJob = new JLabel("Job");
        lblJob.setBounds(595, 20, 46, 16);
        lblJob.setBorder(null);
        lblJob.setFont(new Font("Arial", Font.BOLD, 15));
        lblJob.setBackground(Color.decode("#292c35"));
        lblJob.setForeground(Color.decode("#000000"));
        p2.add(lblJob);

        lblSalary= new JLabel("Salary");
        lblSalary.setBounds(700, 20, 46, 16);
        lblSalary.setBorder(null);
        lblSalary.setFont(new Font("Arial", Font.BOLD, 15));
        lblSalary.setBackground(Color.decode("#292c35"));
        lblSalary.setForeground(Color.decode("#00000"));
        p2.add(lblSalary);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(825, 20, 46, 16);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(l2);

        JLabel l3 = new JLabel("Email");
        l3.setBounds(955, 20, 46, 16);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        p2.add(l3);

        //getContentPane().setBackground(Color.WHITE);
    }
}