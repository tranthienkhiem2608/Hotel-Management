package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.NewCustomerController;
import com.hotelManagementSystem.controller.UpdateRoomController;
import com.hotelManagementSystem.entity.Room;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {
    private JPanel p1;

    private JTextField txt_Price;

    private JTextField txt_BedType;

    private Room room;

    private JComboBox c1;

    public JPanel getP1() {
        return p1;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateRoom frame = new UpdateRoom();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close(){
        this.dispose();
    }


    public UpdateRoom() {initComponent();    }
    private void initComponent(){
        room = new Room();
        p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(p1);
        p1.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/roomview.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(460,25,600,550);
        add(l1);

        JLabel lblUpdateRoomStatus = new JLabel("UPDATE ROOM");
        lblUpdateRoomStatus.setFont(new Font("Arial", Font.BOLD, 35));
        lblUpdateRoomStatus.setForeground(Color.BLACK);
        lblUpdateRoomStatus.setBounds(90, 15, 600, 50);
        p1.add(lblUpdateRoomStatus);

        JLabel lblNewLabel = new JLabel("Room ID:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(20, 130, 150, 27);
        p1.add(lblNewLabel);

        c1 = new JComboBox();
        p1.add(c1);
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(300, 130, 80, 20);
        new UpdateRoomController().refreshBtn(btnRefresh, c1);
        p1.add(btnRefresh);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
            while(rs.next()){
                c1.addItem(rs.getString("roomNumber"));
            }
            c1.setBounds(150, 130, 140, 20);
            String selectedItem = (String) c1.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                c1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedItem = (String) c1.getSelectedItem();
                        room.setRoomNumber(Integer.parseInt(selectedItem));
                    }
                });
            }

        }catch (Exception e){}

        JLabel lblRoomId = new JLabel("Price:");
        lblRoomId.setFont(new Font("Arial", Font.PLAIN, 18));
        lblRoomId.setForeground(Color.BLACK);
        lblRoomId.setBounds(20, 190, 150, 27);
        p1.add(lblRoomId);

        txt_Price = new JTextField();
        txt_Price.setBounds(150, 190, 140, 20);
        txt_Price.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(txt_Price.getText().length() > 0) {
                    room.setPrice(Integer.parseInt(txt_Price.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(txt_Price.getText().length() > 0) {
                    room.setPrice(Integer.parseInt(txt_Price.getText()));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(txt_Price.getText().length() > 0) {
                    room.setPrice(Integer.parseInt(txt_Price.getText()));
                }
            }
        });
        p1.add(txt_Price);

        JLabel lblAvailability = new JLabel("Bed type:");
        lblAvailability.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAvailability.setForeground(Color.BLACK);
        lblAvailability.setBounds(20, 250, 150, 27);
        p1.add(lblAvailability);

        txt_BedType = new JTextField();
        txt_BedType.setBounds(150, 250, 140, 20);
        txt_BedType.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(txt_BedType.getText().length() > 0) {
                    room.setBedType(txt_BedType.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(txt_BedType.getText().length() > 0) {
                    room.setBedType(txt_BedType.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(txt_BedType.getText().length() > 0) {
                    room.setBedType(txt_BedType.getText());
                }
            }
        });
        p1.add(txt_BedType);

        JButton b1 = new JButton("CHECK");
        b1.setBounds(90, 360, 100, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        new UpdateRoomController().btnCheckRoom(b1, room, txt_Price, txt_BedType);
        p1.add(b1);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(210, 360, 100, 40);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        new UpdateRoomController().btnUpdate(btnUpdate, room);
        p1.add(btnUpdate);

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#fcf6f0"), getWidth(), getHeight(), Color.decode("#fcf6f0"));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setBounds(0, 0, 1200, 600);
        p1.add(gradientPanel);
    }
}