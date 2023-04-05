package com.hotelManagementSystem.views;


import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.DriverInfoController;
import com.hotelManagementSystem.dao.CustomerInfoDao;
import com.hotelManagementSystem.dao.DriverInfoDao;
import com.hotelManagementSystem.entity.Driver;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

public class DriverInfo extends JFrame {
    private static JPanel p1;
    private JTable table;
    private JComboBox comboBox;
    private Driver driver;
    Choice c1;

    /**
     * Launch the application.
     */
    public JPanel getP1() {
        return p1;
    }
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

    public DriverInfo() {
        p1 = new JPanel();
        setContentPane(p1);
        p1.setLayout(null);
        driver = new Driver();

        JLabel lblPickUpService = new JLabel("DRIVER INFORMATION");
        lblPickUpService.setFont(new Font("Arial", Font.BOLD, 30));
        lblPickUpService.setForeground(Color.black);
        lblPickUpService.setBounds(350, 10, 600, 50);
        p1.add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car:");
        lblTypeOfCar.setFont(new Font("Arial", Font.BOLD, 16));
        lblTypeOfCar.setForeground(Color.black);
        lblTypeOfCar.setBounds(100, 80, 150, 27);
        p1.add(lblTypeOfCar);

        comboBox = new JComboBox();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while(rs.next()){
                comboBox.addItem(rs.getString("carBrand"));
            }
            comboBox.setBounds(220, 83, 150, 20);
            String selectedItem = (String) comboBox.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
                comboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        driver.setCarBrand((String) comboBox.getSelectedItem());
                    }
                });
            }
            p1.add(comboBox);
        }catch (Exception e){

        }
        String[] columnNames = {"Name", "Age", "Gender", "Phone", "Car Brand", "Available", "Location"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable();
        table.setBounds(30, 270, 900, 200);
        table.setModel(tableModel);
        table.enableInputMethods(false);
        p1.add(table);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(60, 120, 1000, 450);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p1.add(scrollPane);

        try{
            DriverInfoDao driverInfoDao = new DriverInfoDao();
            driverInfoDao.viewDriverInfo(table, tableModel, comboBox);

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton btnRegister = new JButton("Find");
        btnRegister.setBounds(400, 83, 100, 20);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        new DriverInfoController().btnFind(btnRegister ,table, tableModel, driver);
        p1.add(btnRegister);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(450, 500, 180, 50);
        btnRefresh.setBackground(Color.BLACK);
        btnRefresh.setForeground(Color.WHITE);
        new DriverInfoController().btnRefresh(btnRefresh, table,comboBox, tableModel);
        p1.add(btnRefresh);



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
