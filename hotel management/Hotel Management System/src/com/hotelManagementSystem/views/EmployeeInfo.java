/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelManagementSystem.views;
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
    Connection conn = null;
    private static JPanel p1;
    private JTable table;
    private JLabel lblID;
    private JLabel lblName;
    private JLabel lblAge;
    private JLabel lblJob;
    private JLabel lblSalary;
    private JLabel lblGender;


    public JPanel getP1() {
        return p1;
    }

    public EmployeeInfo(){
        initComponent();
    }

    private void initComponent(){
        //conn = Javaconnect.getDBConnection();
        p1 = new JPanel();
        p1.setSize(1000, 600);
        setContentPane(p1);
        p1.setLayout(null);

        String[] columnNames = {"ID", "Name", "Age", "Gender", "Position", "Salary", "Phone", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(0, 34, 1000, 500);
        p1.add(table);
        try{
            EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();
            employeeInfoDao.showEmployee(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }


        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(550, 540, 120, 30);
        btnEdit.setBackground(Color.BLACK);
        btnEdit.setForeground(Color.WHITE);
        new EmployeeInfoController().ChangeToEdit(btnEdit);
        p1.add(btnEdit);

        getContentPane().setBackground(Color.WHITE);
        lblID = new JLabel("ID");
        lblID.setBounds(40, 20, 46, 16);
        lblID.setBorder(null);
        lblID.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblID);

        lblName = new JLabel("Name");
        lblName.setBounds(125, 20, 46, 16);
        lblName.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblName);

        lblAge = new JLabel("Age");
        lblAge.setBounds(240, 20, 46, 16);
        lblAge.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblAge);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(340, 20, 46, 16);
        lblGender.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblGender);

        lblJob = new JLabel("Job");
        lblJob.setBounds(480, 20, 86, 16);
        lblJob.setBorder(null);
        lblJob.setFont(new Font("Arial", Font.PLAIN, 13));
        lblJob.setBackground(Color.decode("#292c35"));
        lblJob.setForeground(Color.decode("#000000"));
        p1.add(lblJob);

        lblSalary = new JLabel("Salary");
        lblSalary.setBounds(600, 20, 86, 16);
        lblSalary.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(lblSalary);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(700, 20, 86, 16);
        l2.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(l2);

        JLabel l3 = new JLabel("Email");
        l3.setBounds(850, 20, 86, 16);
        l3.setFont(new Font("Arial", Font.PLAIN, 13));
        p1.add(l3);

        getContentPane().setBackground(Color.cyan);

    }
}