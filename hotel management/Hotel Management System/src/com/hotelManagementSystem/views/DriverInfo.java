package com.hotelManagementSystem.views;


import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class DriverInfo extends JFrame {
    private JPanel contentPane;
    private JTable table;
    Choice c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DriverInfo frame = new DriverInfo();
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

    /**
     * Create the frame.
     * @throws SQLException
     */
    public DriverInfo() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPickUpService = new JLabel("DRIVER INFORMATION");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 50));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(200, 10, 600, 50);
        contentPane.add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTypeOfCar.setForeground(Color.black);
        lblTypeOfCar.setBounds(100, 100, 150, 27);
        contentPane.add(lblTypeOfCar);


        c1 = new Choice();
//        Su dung DB
//        try{
//            conn c = new conn();
//            ResultSet rs = c.s.executeQuery("select * from driver");
//            while(rs.next()){
//                c1.add(rs.getString("carBrand"));
//            }
//        }catch(Exception e){ }
        c1.setBounds(270, 100, 140, 20);
        contentPane.add(c1);



        JLabel lblInfo = new JLabel("Name");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblInfo.setForeground(Color.black);
        lblInfo.setBounds(50, 150, 100, 27);
        contentPane.add(lblInfo);


        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setForeground(Color.black);
        lblNewLabel.setBounds(180, 150, 100, 27);
        contentPane.add(lblNewLabel);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Arial", Font.PLAIN, 20));
        lblGender.setForeground(Color.black);
        lblGender.setBounds(310, 150, 100, 27);
        contentPane.add(lblGender);

        JLabel lblTypeOfDriver = new JLabel("Phone");
        lblTypeOfDriver.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTypeOfDriver.setForeground(Color.black);
        lblTypeOfDriver.setBounds(440, 150, 100, 27);
        contentPane.add(lblTypeOfDriver);

        JLabel lblDateOfThe = new JLabel("Car Brand");
        lblDateOfThe.setFont(new Font("Arial", Font.PLAIN, 20));
        lblDateOfThe.setForeground(Color.black);
        lblDateOfThe.setBounds(570, 150, 100, 27);
        contentPane.add(lblDateOfThe);

        JLabel lblAirport = new JLabel("Available");
        lblAirport.setFont(new Font("Arial", Font.PLAIN, 20));
        lblAirport.setForeground(Color.black);
        lblAirport.setBounds(700, 150, 100, 27);
        contentPane.add(lblAirport);

        JLabel lblAvailable = new JLabel("Location");
        lblAvailable.setFont(new Font("Arial", Font.PLAIN, 20));
        lblAvailable.setForeground(Color.black);
        lblAvailable.setBounds(830, 150, 100, 27);
        contentPane.add(lblAvailable);

        JButton btnRegister = new JButton("Load Data");
//        Su dung DB
//        btnRegister.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                String SQL = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
//                try{
//
//                    conn c = new conn();
//                    rs = c.s.executeQuery(SQL);
//                    table.setModel(DbUtils.resultSetToTableModel(rs));
//
//
//
//                }catch (SQLException ss)
//                {
//                    ss.printStackTrace();
//                }
//
//
//            }
//        });
        btnRegister.setBounds(220, 500, 180, 50);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        contentPane.add(btnRegister);

        JButton btnExit = new JButton("Back");
//        btnExit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                new ManagerDashboard().setVisible(true);
//                setVisible(false);
//            }
//        });
        btnExit.setBounds(600, 500, 180, 50);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        table.setBounds(30, 190, 900, 300);
        contentPane.add(table);

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
        gradientPanel.setBounds(0, 0, 1000, 600);
        contentPane.add(gradientPanel);
    }
}
