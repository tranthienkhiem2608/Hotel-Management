package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Customer;
import com.hotelManagementSystem.controller.NewCustomerController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import java.util.*;
import java.time.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;


public class NewCustomer extends JFrame{

    public static void main(String[] args) {

        new NewCustomer().setVisible(true);

    }

    private static JPanel p1;
    private JTextField t1,t2,t3,t5,t6;
    private JTextArea t4;
    JComboBox comboBox, comboBox_1;
    JRadioButton r1,r2;
    Choice c1;
    String[] listRoom;

    Customer customer;

    public JPanel getP1(){
        return p1;
    }
    public NewCustomer() {
        initComponent();
//        setLocationRelativeTo(null);
    }
    public void initComponent(){

        p1 = new JPanel();
        setContentPane(p1);
        p1.setLayout(null);
        customer = new Customer();

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(600,20,400,500);
        p1.add(l1);

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Arial", Font.BOLD, 30));
        lblName.setBounds(60, 11, 350, 53);
        p1.add(lblName);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 14);
        setFont(new Font("Arial", Font.BOLD, 20));
        p1.add(lblId);

        comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setDocument((String) comboBox.getSelectedItem());
            }
        });
        p1.add(comboBox);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 111, 200, 14);
        setFont(new Font("Arial", Font.BOLD, 20));
        p1.add(l2);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        t1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customer.setNumberID(t1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customer.setNumberID(t1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customer.setNumberID(t1.getText());
            }
        });
        p1.add(t1);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        setFont(new Font("Arial", Font.BOLD, 20));
        p1.add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        t2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customer.setName(t2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customer.setName(t2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customer.setName(t2.getText());
            }
        });
        p1.add(t2);



        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        setFont(new Font("Arial", Font.BOLD, 20));
        p1.add(lblGender);

        r1 = new JRadioButton("male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setGender("male");
            }
        });
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setGender("female");
            }
        });
        add(r2);


        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(35, 231, 200, 14);
        setFont(new Font("Arial", Font.BOLD, 20));
        p1.add(lblPhone);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        p1.add(lblReserveRoomNumber);



        comboBox_1 = new JComboBox();
        p1.add(comboBox_1);
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(430, 271, 80, 20);
        new NewCustomerController().refreshBtn(btnRefresh, comboBox_1);
        p1.add(btnRefresh);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability = 'Available'");
            while(rs.next()){
                comboBox_1.addItem(rs.getString("roomNumber"));
            }
        comboBox_1.setBounds(271, 271, 150, 20);
            String selectedItem = (String) comboBox_1.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                comboBox_1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedItem = (String) comboBox_1.getSelectedItem();
                        customer.setRoomNumber(Integer.parseInt(selectedItem));
                    }
                });
            }


            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date time = new Date();

            JLabel lblCheckInStatus = new JLabel("Checked-In : ");
            lblCheckInStatus.setBounds(35, 316, 200, 17);
            setFont(new Font("Arial", Font.BOLD, 20));
            p1.add(lblCheckInStatus);
            t4 = new JTextArea();
            t4.setBounds(271, 316, 200, 20);
            t4.setText(dateFormat.format(date) + " " + timeFormat.format(time));
            t4.setEditable(false);
            p1.add(t4);
            customer.setCheckInDate(date);
            customer.setCheckInTime(time);

            JLabel lblCheckOutStatus = new JLabel("Checked-Out : ");
            lblCheckOutStatus.setBounds(35, 359, 200, 17);
            setFont(new Font("Arial", Font.BOLD, 20));
            p1.add(lblCheckOutStatus);

            JDateChooser dateChooser = new JDateChooser();
            dateChooser.setBounds(271, 359, 150, 20);
            dateChooser.setDateFormatString("yyyy-MM-dd");
            dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if("date".equals(evt.getPropertyName())){
                        customer.setCheckOutDate(dateChooser.getDate());
                    }
                }
            });
            p1.add(dateChooser);

            Date outDate = new Date();
            outDate.setHours(12);
            outDate.setMinutes(0);
            outDate.setSeconds(0);
            customer.setCheckOutTime(outDate);


        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 402, 200, 14);
            setFont(new Font("Arial", Font.BOLD, 20));
            p1.add(lblDeposite);


        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        t3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customer.setPhone(t3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customer.setPhone(t3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customer.setPhone(t3.getText());
            }
        });

        p1.add(t3);



        t6 = new JTextField();
        t6.setBounds(271, 402, 150, 20);
        t6.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //convert to int
                customer.setDeposit(Integer.parseInt(t6.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customer.setDeposit(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customer.setDeposit(Integer.parseInt(t6.getText()));
            }
        });
        p1.add(t6);



        JButton btnNewButton = new JButton("Add");

        btnNewButton.setBounds(170, 450, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        new NewCustomerController().addNewCustomer(btnNewButton,  customer);
            p1.add(btnNewButton);



        getContentPane().setBackground(Color.WHITE);
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



