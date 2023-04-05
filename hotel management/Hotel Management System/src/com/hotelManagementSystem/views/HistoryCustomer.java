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

        JLabel lblPickUpService = new JLabel("HISTORY");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 30));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(460, 10, 600, 50);
        p1.add(lblPickUpService);

        table = new JTable();
        table.setBounds(50, 50, 1000, 450);;
        table.setModel(tableModel);
        table.enableInputMethods(false);
        p1.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 65, 1000, 450);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scrollPane);

        try{
            HistoryCustomerDao customerInfoDao = new HistoryCustomerDao();
            customerInfoDao.viewCustomerInfo(table, tableModel);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(600, 515, 120, 30);
        btnRefresh.setBackground(Color.BLACK);
        btnRefresh.setForeground(Color.WHITE);
        new HistoryCustomerController().btnRefresh(btnRefresh, table, tableModel);
        p1.add(btnRefresh);

        textField = new JTextField();
        textField.setBounds(50, 515, 250, 30);
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
        btnSearch.setBounds(320, 515, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new HistoryCustomerController().btnSearch(btnSearch, table, tableModel, historyCustomer);
        p1.add(btnSearch);

        getContentPane().setBackground(Color.WHITE);
    }
}
