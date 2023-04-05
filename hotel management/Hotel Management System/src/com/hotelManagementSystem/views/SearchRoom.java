package com.hotelManagementSystem.views;


import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.SearchRoomController;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.hotelManagementSystem.entity.Room;
import com.hotelManagementSystem.dao.SearchRoomDao;

public class SearchRoom extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static JPanel p1;
    private JTextField txt_Type;
    private JTable table;
    Choice c1;
    JComboBox comboBox, comboBox_1;
    private Room room;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchRoom frame = new SearchRoom();
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

    public JPanel getP1() {
        return p1;
    }

    public SearchRoom() {
        initComponent();
        setLocationRelativeTo(null);
    }
    private void initComponent() {
        p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(p1);
        p1.setSize(1100,600);
        p1.setLayout(null);
        room = new Room();

        JLabel lblPickUpService = new JLabel("SEARCH ROOM");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 30));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(390, 10, 600, 50);
        p1.add(lblPickUpService);


        JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
        lblRoomAvailable.setBounds(50, 100, 130, 27);
        lblRoomAvailable.setFont(new Font("Arial", Font.BOLD, 14));
        p1.add(lblRoomAvailable);


        comboBox = new JComboBox(new String[] { " ", "All","Single Bed", "Double Bed", "King bed"});
        comboBox.setBounds(170, 102, 150, 20);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setBedType((String) comboBox.getSelectedItem());
            }
        });
        p1.add(comboBox);

        JLabel lblAvailable = new JLabel("Availability:");
        lblAvailable.setBounds(360, 100, 100, 27);
        lblAvailable.setFont(new Font("Arial", Font.BOLD, 14));
        p1.add(lblAvailable);

        comboBox_1 = new JComboBox(new String[] { " ", "All", "Available", "Occupied"});
        comboBox_1.setBounds(450, 102, 150, 20);
        comboBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setAvailability((String) comboBox_1.getSelectedItem());
            }
        });
        p1.add(comboBox_1);

        String[] columnNames = {"Room Number", "Bed Type", "Availability", "Price", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(50, 190, 1000, 400);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.decode("#292c35"));
        p1.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 140, 1000, 450);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scrollPane);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(650, 90, 100, 40);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new SearchRoomController().searchRoom(btnSearch, table, room, tableModel);
        p1.add(btnSearch);

        getContentPane().setBackground(Color.WHITE);
    }
}
