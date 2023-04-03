package com.hotelManagementSystem.views;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


import com.hotelManagementSystem.controller.CustomerInfoController;
import com.hotelManagementSystem.dao.CustomerInfoDao;
import com.hotelManagementSystem.entity.Customer;
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

    private  static JPanel p1;
    private JButton btnSearch;
    private JTextField textField;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblPhone;
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

        String[] columnNames = {"ID", "Number", "Name", "Gender", "Phone", "Room", "Check-in", "Check-out","Price Room", "Deposit"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(50, 50, 1000, 450);;
        table.setModel(tableModel);
        table.enableInputMethods(false);
        p1.add(table);

        try{
            CustomerInfoDao customerInfoDao = new CustomerInfoDao();
            customerInfoDao.viewCustomerInfo(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(320, 500, 120, 30);
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
        btnSearch.setBounds(600, 500, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new CustomerInfoController().btnSearch(btnSearch, table, tableModel, customer);
        p1.add(btnSearch);



        lblId = new JLabel("ID");
        lblId.setBounds(100, 20, 50, 16);
        lblId.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(215, 20, 50, 16);
        l1.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(345, 20, 50, 16);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(455, 20, 50, 16);
        lblGender.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblGender);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(590, 20, 50, 16);
        lblPhone.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblPhone);

        lblRoom = new JLabel("Room");
        lblRoom.setBounds(715, 20, 50, 16);
        lblRoom.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblRoom);

        lblStatus = new JLabel("Check-in");
        lblStatus.setBounds(830, 20, 50, 16);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblStatus);

        JLabel lblNewLabel_2 = new JLabel("Check-out");
        lblNewLabel_2.setBounds(955, 20, 50, 16);
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblNewLabel_2);

        lblNewLabel_1 = new JLabel("Deposit");
        lblNewLabel_1.setBounds(980, 20, 50, 16);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
}
