package com.hotelManagementSystem.views;


import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

        JTextArea lblSearchForRoom = new JTextArea("Search For Room");
        lblSearchForRoom.setFont(new Font("serif", Font.BOLD, 30));
        lblSearchForRoom.setBounds(0, 10, 1100, 50);
        lblSearchForRoom.setForeground(Color.decode("#e09145"));
        lblSearchForRoom.setBackground(Color.decode("#1b1c22"));
        lblSearchForRoom.setEditable(false);
        p1.add(lblSearchForRoom);

        JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
        lblRoomAvailable.setBounds(10, 100, 100, 27);
        p1.add(lblRoomAvailable);


        comboBox = new JComboBox(new String[] { "All","Single Bed", "Double Bed", "King bed"});
        comboBox.setBounds(130, 100, 150, 20);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setBedType((String) comboBox.getSelectedItem());
            }
        });
        p1.add(comboBox);

        JLabel lblAvailable = new JLabel("Availability:");
        lblAvailable.setBounds(400, 100, 100, 27);
        //lblRoomAvailable.setFont(new Font("Arial", Font.PLAIN, 14));
        p1.add(lblAvailable);

        comboBox_1 = new JComboBox(new String[] { "all", "available", "occupied"});
        comboBox_1.setBounds(510, 100, 150, 20);
        comboBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setAvailability((String) comboBox_1.getSelectedItem());
            }
        });
        p1.add(comboBox_1);



        JLabel lblRoomType = new JLabel("Room Number");
        lblRoomType.setBounds(70, 150, 150, 27);
        p1.add(lblRoomType);

        JLabel lblRoomAvailable_1 = new JLabel("Availability");
        lblRoomAvailable_1.setBounds(270, 150, 150, 27);
        p1.add(lblRoomAvailable_1);

        JLabel lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(470, 150, 150, 27);
        p1.add(lblCleanStatus);

        JLabel lblPrice_1 = new JLabel("Price");
        lblPrice_1.setBounds(670, 150, 150, 27);
        p1.add(lblPrice_1);

        JLabel l1 = new JLabel("Bed Type");
        l1.setBounds(870, 150, 150, 27);
        p1.add(l1);



        table = new JTable();
        table.setBounds(50, 190, 1000, 400);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.decode("#292c35"));
        p1.add(table);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(900, 85, 150, 50);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        new SearchRoomController().searchRoom(btnSearch, table, room);
        p1.add(btnSearch);

        getContentPane().setBackground(Color.WHITE);
    }
}
