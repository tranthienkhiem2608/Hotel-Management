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

        JLabel lblPickUpService = new JLabel("CUSTOMER INFORMATION");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 30));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(300, 10, 600, 50);
        p1.add(lblPickUpService);

        table = new JTable();
        table.setBounds(50, 50, 1000, 450);;
        table.setModel(tableModel);
        table.enableInputMethods(false);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        p1.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 65, 1000, 450);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scrollPane);

        try{
            CustomerInfoDao customerInfoDao = new CustomerInfoDao();
            customerInfoDao.viewCustomerInfo(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(600, 515, 120, 30);
        btnRefresh.setBackground(Color.BLACK);
        btnRefresh.setForeground(Color.WHITE);
        new CustomerInfoController().btnRefresh(btnRefresh, table, tableModel);
        p1.add(btnRefresh);

        textField = new JTextField();
        textField.setBounds(50, 515, 250, 30);
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
        btnSearch.setBounds(320, 515, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new CustomerInfoController().btnSearch(btnSearch, table, tableModel, customer);
        p1.add(btnSearch);

        getContentPane().setBackground(Color.WHITE);
    }
}
