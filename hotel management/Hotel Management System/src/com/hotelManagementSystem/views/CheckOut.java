package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.CheckOutController;
import com.hotelManagementSystem.controller.LoginController;
import com.hotelManagementSystem.controller.UpdateCheckController;
import com.hotelManagementSystem.entity.Customer;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{

    PreparedStatement pst = null;
    private JPanel p1;
    private JLabel t1;
    private JComboBox comboBox;
    private Customer customer, customer1;
    private JButton btnCheckCustomer;
    private JTextArea txt_Time, txt_RoomNumber, txt_TimeCheckOut;

    Choice c1;

    public JPanel getP1() {
        return p1;
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CheckOut frame = new CheckOut();
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

    public CheckOut() {
        p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(p1);
        p1.setLayout(null);
        customer = new Customer();
        customer1 = new Customer();

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 253,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(500,120,450,253);
        add(l1);

        JLabel lblCheckOut = new JLabel("CHECK OUT ");
        lblCheckOut.setFont(new Font("Arial", Font.BOLD, 50));
        lblCheckOut.setForeground(Color.decode("#E09145"));
        lblCheckOut.setBounds(300, 20, 500, 50);
        p1.add(lblCheckOut);

        JLabel lblName = new JLabel("Number :");
        lblName.setFont(new Font("Arial", Font.PLAIN, 20));
        lblName.setForeground(Color.decode("#f0f5f5"));
        lblName.setBounds(20, 120, 100, 27);
        p1.add(lblName);


        comboBox = new JComboBox();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                comboBox.addItem(rs.getString("numberID"));
            }
            comboBox.setBounds(200, 120, 150, 20);
            String selectedItem = (String) comboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                comboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        customer.setNumberID((String) comboBox.getSelectedItem());
                    }
                });
            }
            p1.add(comboBox);
        }catch (Exception e){

        }
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(400, 120, 80, 20);
        new CheckOutController().refreshBtn(btnRefresh, comboBox);
        p1.add(btnRefresh);



        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRoomNumber.setForeground(Color.decode("#f0f5f5"));
        lblRoomNumber.setBounds(20, 190, 150, 27);
        p1.add(lblRoomNumber);

        txt_RoomNumber = new JTextArea();
        txt_RoomNumber.setBounds(200, 190, 150, 20);
        txt_RoomNumber.setEditable(false);
        p1.add(txt_RoomNumber);

        JLabel lblCheckIn = new JLabel("Checkin Time:");
        lblCheckIn.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckIn.setForeground(Color.decode("#f0f5f5"));
        lblCheckIn.setBounds(20, 260, 150, 27);
        p1.add(lblCheckIn);

        txt_Time = new JTextArea();
        txt_Time.setBounds(248, 235, 140, 20);
        txt_Time.setEditable(false);
        txt_Time.setText("0/0/0 00:00:00");
        p1.add(txt_Time);



        ImageIcon backBut = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image imgButton1 = backBut.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        btnCheckCustomer = new JButton(new ImageIcon(imgButton1));
        btnCheckCustomer.setBounds(370, 120, 20, 20);
        btnCheckCustomer.setBorder(null);
        btnCheckCustomer.setBackground(Color.decode("#292C35"));
        customer1 =  new CheckOutController().btnCheckCustomer(btnCheckCustomer, customer, txt_RoomNumber, txt_Time);
        p1.add(btnCheckCustomer);

        JLabel lblCheckOut1 = new JLabel("Checkout Time:");
        lblCheckOut1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckOut1.setForeground(Color.decode("#f0f5f5"));
        lblCheckOut1.setBounds(20, 330, 150, 20);
        p1.add(lblCheckOut1);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        //time format
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date time = new Date();

        txt_TimeCheckOut = new JTextArea();
        txt_TimeCheckOut.setBounds(248, 305, 140, 20);
        txt_TimeCheckOut.setEditable(false);
        txt_TimeCheckOut.setText(dateFormat.format(date) + " " + timeFormat.format(time));
        p1.add(txt_TimeCheckOut);
        customer1.setCheckOutDate(date);
        customer1.setCheckOutTime(time);

        JButton btnCheckOut = new JButton("Check Out");
//        Su dung DB
//        btnCheckOut.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String id = c1.getSelectedItem();
//                String s1 = t1.getText();
//                String deleteSQL = "Delete from customer where number = "+id;
//                String q2 = "update room set availability = 'Available' where room_number = "+s1;
//
//
//                conn c = new conn();
//
//                try{
//
//
//                    c.s.executeUpdate(deleteSQL);
//                    c.s.executeUpdate(q2);
//                    JOptionPane.showMessageDialog(null, "Check Out Successful");
//        Date date = new Date();
//        lblCheckOutTime.setText("" +date)");      //  153, 154 tao đột biến --> Ao chình
//                    new Reception().setVisible(true);
//                    setVisible(false);
//                }catch(SQLException e1){
//                    System.out.println(e1.getMessage());
//                }
//            }
//        });
        new CheckOutController().btnCheckOut(btnCheckOut, customer1);
        btnCheckOut.setBounds(220, 400, 180, 50);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        p1.add(btnCheckOut);



        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#292C35"), getWidth(), getHeight(), Color.decode("#292C35"));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setBounds(0, 0, 1000, 600);
        p1.add(gradientPanel);
    }

}
