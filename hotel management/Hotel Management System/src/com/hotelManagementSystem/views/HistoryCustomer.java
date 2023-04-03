package com.hotelManagementSystem.views;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;


import com.hotelManagementSystem.controller.CustomerInfoController;
import com.hotelManagementSystem.controller.HistoryCustomerController;
import com.hotelManagementSystem.dao.CustomerInfoDao;
import com.hotelManagementSystem.dao.HistoryCustomerDao;
import com.hotelManagementSystem.entity.HistoryCus;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class HistoryCustomer extends JFrame {

    private  static JPanel p1;
    private JButton btnSearch;
    private JTextField textField;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblGender;
    private JTable table;
    private JLabel lblPhone;
    private JLabel lblRoom;
    private JLabel lblStatus, lblStatusOut;
    private JLabel lblNewLabel_1;
    private HistoryCus historyCustomer;

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
    public HistoryCustomer(){
        initComponent();
    }

    private void initComponent(){
        p1 = new JPanel();
        p1.setSize(1000, 600);
        setContentPane(p1);
        p1.setLayout(null);
        historyCustomer = new HistoryCus();


        String[] columnNames = {"ID", "Number", "Name", "Gender", "Phone", "Room", "Check-in", "Check-out", "Deposit"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(50, 50, 1000, 450);;
        table.setModel(tableModel);
        table.enableInputMethods(false);
        p1.add(table);

        try{
            HistoryCustomerDao customerInfoDao = new HistoryCustomerDao();
            customerInfoDao.viewCustomerInfo(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(320, 500, 120, 30);
        btnRefresh.setBackground(Color.BLACK);
        btnRefresh.setForeground(Color.WHITE);
        new HistoryCustomerController().btnRefresh(btnRefresh, table, tableModel);
        p1.add(btnRefresh);

        textField = new JTextField();
        textField.setBounds(40, 500, 250, 30);
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                historyCustomer.setName(textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                historyCustomer.setName(textField.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                historyCustomer.setName(textField.getText());

            }
        });
        p1.add(textField);

        //clear table previous data


        btnSearch = new JButton("Search");
        btnSearch.setBounds(600, 500, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new HistoryCustomerController().btnSearch(btnSearch, table, tableModel, historyCustomer);
        p1.add(btnSearch);



        lblId = new JLabel("ID");
        lblId.setBounds(100, 20, 50, 16);
        lblId.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblId);

        JLabel l1 = new JLabel("Number");
        l1.setBounds(100, 20, 50, 16);
        l1.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(l1);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(200, 20, 50, 16);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblNewLabel);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(300, 20, 50, 16);
        lblGender.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblGender);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(400, 20, 50, 16);
        lblPhone.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblPhone);

        lblRoom = new JLabel("Room");
        lblRoom.setBounds(500, 20, 50, 16);
        lblRoom.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblRoom);

        lblStatus = new JLabel("Check-in");
        lblStatus.setBounds(600, 20, 50, 16);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblStatus);

        lblStatusOut = new JLabel("Check-out");
        lblStatusOut.setBounds(700, 20, 50, 16);
        lblStatusOut.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblStatusOut);

        lblNewLabel_1 = new JLabel("Deposit");
        lblNewLabel_1.setBounds(800, 20, 50, 16);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        p1.add(lblNewLabel_1);

        getContentPane().setBackground(Color.WHITE);
    }
}
