package com.hotelManagementSystem.views;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Date;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JLabel t1;
    Choice c1;

    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     * @throws SQLException
     */
    public CheckOut() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
        contentPane.add(lblCheckOut);

        JLabel lblName = new JLabel("Number :");
        lblName.setFont(new Font("Arial", Font.PLAIN, 20));
        lblName.setForeground(Color.decode("#f0f5f5"));
        lblName.setBounds(20, 120, 100, 27);
        contentPane.add(lblName);

        c1 = new Choice();
//        try{
//            conn c = new conn();
//            ResultSet rs = c.s.executeQuery("select * from customer");
//            while(rs.next()){
//                c1.add(rs.getString("number"));
//            }
//        }catch(Exception e){ }
        c1.setBounds(200, 120, 150, 20);
        contentPane.add(c1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setForeground(Color.decode("#292C35"));
        l2.setBounds(370,120,20,20);
        add(l2);

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRoomNumber.setForeground(Color.decode("#f0f5f5"));
        lblRoomNumber.setBounds(20, 190, 150, 27);
        contentPane.add(lblRoomNumber);

        t1 = new JLabel();
        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setForeground(Color.decode("#f0f5f5"));
        t1.setBounds(200, 190, 150, 20);
        contentPane.add(t1);
//          Su dung DB
//                l2.addActionListener(new ActionListener(){
//
//                    public void actionPerformed(ActionEvent ae){
//                        System.out.println("Hi");
//                        try{
//
//                            conn c = new conn();
//                            String number = c1.getSelectedItem();
//                            ResultSet rs = c.s.executeQuery("select * from customer where number = "+number);
//
//                            if(rs.next()){
//                                System.out.println("clicked");
//                                t1.setText(rs.getString("room_number"));
//                                  lblCheckInTime.setText(rs.getString("checkintime"));
//                            }
//                        }catch(Exception e){ }
//                    }
//                });

        JLabel lblCheckIn = new JLabel("Checkin Time:");
        lblCheckIn.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckIn.setForeground(Color.decode("#f0f5f5"));
        lblCheckIn.setBounds(20, 260, 150, 27);
        contentPane.add(lblCheckIn);

        JLabel lblCheckInTime = new JLabel();
        lblCheckInTime.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckInTime.setForeground(Color.decode("#f0f5f5"));
        lblCheckInTime.setBounds(200, 260, 250, 20);
        contentPane.add(lblCheckInTime);

        JLabel lblCheckOut1 = new JLabel("Checkout Time:");
        lblCheckOut1.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckOut1.setForeground(Color.decode("#f0f5f5"));
        lblCheckOut1.setBounds(20, 330, 150, 20);
        contentPane.add(lblCheckOut1);

        Date date = new Date();                       //Trong video 128, 129
        JLabel lblCheckOutTime = new JLabel(""+date);
//        JLabel lblCheckOutTime = new JLabel();
        lblCheckOutTime.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCheckOutTime.setForeground(Color.decode("#f0f5f5"));
        lblCheckOutTime.setBounds(200, 330, 300, 20);
        contentPane.add(lblCheckOutTime);


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
        btnCheckOut.setBounds(220, 400, 180, 50);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        contentPane.add(btnCheckOut);

        JButton btnExit = new JButton("Back");
//        btnExit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new ManagerDashboard().setVisible(true);
//                setVisible(false);
//            }
//        });
        btnExit.setBounds(600, 400, 180, 50);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


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
        contentPane.add(gradientPanel);
    }

}
