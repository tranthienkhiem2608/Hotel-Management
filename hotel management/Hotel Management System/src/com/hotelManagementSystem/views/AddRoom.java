package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Room;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.hotelManagementSystem.controller.AddRoomController;


public class AddRoom extends JFrame{

    private static JPanel p1;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;
    private Room room;


    public JPanel getP1(){
        return p1;
    }

    public AddRoom() {
        initComponent();
//        setLocationRelativeTo(null);

    }

    private void initComponent() {
        p1 = new JPanel();
        p1.setSize(900, 600);
        p1.setLocation(100, 100);
        setContentPane(p1);
        p1.setLayout(null);
        room = new Room();

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/rooms.jpg"));
        Image i3 = i1.getImage().getScaledInstance(650, 550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,50,700,550);
        add(l15);

        JLabel l10 = new JLabel("ADD ROOM");
        l10.setFont(new Font("Arial", Font.BOLD, 35));
        l10.setBounds(105, 30, 442, 35);
        p1.add(l10);



        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(Color.decode("#17181D"));
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setBounds(60, 130, 150, 27);
        p1.add(l1);


        t4 = new JTextField();
        t4.setBounds(200, 130, 150, 27);
        t4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t4.getText().length() > 0) {
                    t4.setBackground(Color.decode("#E0E0E0"));
                    room.setRoomNumber(Integer.parseInt(t4.getText()));

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t4.getText().length() == 0) {
                    t4.setBackground(Color.decode("#FFCDD2"));
                    room.setRoomNumber(0);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (t4.getText().length() > 0) {
                    t4.setBackground(Color.decode("#E0E0E0"));
                    room.setRoomNumber(Integer.parseInt(t4.getText()));
                }
            }
        });
        p1.add(t4);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(Color.decode("#17181D"));
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setBounds(60, 180, 150, 27);
        p1.add(l2);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(200, 180, 150, 27);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setAvailability((String) comboBox.getSelectedItem());
            }
        });
        p1.add(comboBox);


        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(Color.decode("#17181D"));
        l3.setFont(new Font("Arial", Font.BOLD, 17));
        l3.setBounds(60, 230, 150, 27);
        p1.add(l3);

        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_2.setBounds(200, 230, 150, 27);
        comboBox_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setCleaningStatus((String) comboBox_2.getSelectedItem());
            }
        });
        p1.add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(Color.decode("#17181D"));
        l4.setFont(new Font("Arial", Font.BOLD, 17));
        l4.setBounds(64, 280, 150, 27);
        p1.add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 280, 150, 27);
        t2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t2.getText().length() > 0) {
                    t2.setBackground(Color.decode("#E0E0E0"));
                    room.setPrice(Integer.parseInt(t2.getText()));

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t2.getText().length() == 0) {
                    t2.setBackground(Color.decode("#FFCDD2"));
                    room.setPrice(0);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (t2.getText().length() > 0) {
                    t2.setBackground(Color.decode("#E0E0E0"));
                    room.setPrice(Integer.parseInt(t2.getText()));
                }
            }
        });
        p1.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(Color.decode("#17181D"));
        l5.setFont(new Font("Arial", Font.BOLD, 17));
        l5.setBounds(64, 330, 150, 27);
        p1.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed", "King bed"});
        comboBox_3.setBounds(200, 330, 150, 27);
        comboBox_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.setBedType((String) comboBox_3.getSelectedItem());
            }
        });
        p1.add(comboBox_3);


        b1 = new JButton("ADD");
        b1.setBounds(140, 400, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        new AddRoomController().addRoomBtn(b1, room);
        p1.add(b1);
        getRootPane().setDefaultButton(b1);

        p1.setBackground(Color.WHITE);

    }

}
