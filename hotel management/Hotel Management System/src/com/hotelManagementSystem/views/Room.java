package com.hotelManagementSystem.views;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import com.hotelManagementSystem.dao.RoomDao;
public class Room extends javax.swing.JFrame {

    private static JPanel p1;
    private static JTable table;
    private JLabel lblAvailability;
    private JLabel lblCleanStatus;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblId;

    public JTable getTable() {
        return table;
    }

    public JPanel getP1() {
        return p1;
    }

    public Room() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

            p1 = new JPanel();
        p1.setSize(1100, 600);
        p1.setLocation(0,0);
            setContentPane(p1);
        p1.setLayout(null);

            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/roomview.jpg"));
            Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel l1 = new JLabel(i2);
            l1.setBounds(500,0,600,600);
            add(l1);

            String[] columnNames = {"Room ID", "Availability", "Clean Status", "Price", "Bed Type"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//
            table = new JTable();
            table.setBounds(0, 40, 500, 500);;
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
            p1.add(table);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 40, 500, 500);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            p1.add(scrollPane);


        try{
            RoomDao roomDao = new RoomDao();
            roomDao.showRoom(table, tableModel);
        }catch (Exception e){
            e.printStackTrace();
        }

            JButton editBtn = new JButton("Refresh");
            editBtn.setBounds(180, 550, 120, 30);
            editBtn.setBackground(Color.BLACK);
            editBtn.setForeground(Color.WHITE);
            new RoomDao().showRoom(table, tableModel);
        p1.add(editBtn);


        }
}


