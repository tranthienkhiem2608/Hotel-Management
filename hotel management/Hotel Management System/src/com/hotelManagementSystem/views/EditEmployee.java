package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.AccountSettingController;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class EditEmployee extends JFrame{
    private static JPanel p1;
    private JTextField t1,t2,t3,t4, t5, t6, t7;
    JButton b1,b2;

    public JPanel getP1(){
        return p1;
    }
    public EditEmployee() throws SQLException {
        initComponent(); //throws SQLException;
    }
    private void initComponent() throws SQLException {
        setSize(1000, 600);
        p1 = new JPanel();
        p1.setSize(1000, 600);
        p1.setLocation(100, 100);
        p1.setLayout(null);
        add(p1);

        JLabel l2 = new JLabel("EDIT EMPLOYEE");
        l2.setBounds(200, 10, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 50));
        l2.setForeground(Color.decode("#E09145"));
        p1.add(l2);

        JLabel l1 = new JLabel("ID");
        l1.setForeground(Color.decode("#f0f5f5"));
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBounds(100, 120, 50, 27);
        p1.add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 120, 200, 27);
        p1.add(t1);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
        Image img3 = i3.getImage().getScaledInstance(27, 27, Image.SCALE_DEFAULT);
        ImageIcon ib3 = new ImageIcon(img3);
        JButton l3 = new JButton(ib3);
        l3.setBackground(Color.decode("#292C35"));
        l3.setBounds(370, 120, 27, 27);
        p1.add(l3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/edit.png"));
        Image img4 = i4.getImage().getScaledInstance(128, 126, Image.SCALE_DEFAULT);
        ImageIcon ib4 = new ImageIcon(img4);
        JLabel l4 = new JLabel(ib4);
        l4.setBounds(750, 70, 128, 126);
        p1.add(l4);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/save.png"));
        Image img5 = i5.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        ImageIcon ib5 = new ImageIcon(img5);
        JButton l5 = new JButton(ib5);
        l5.setBackground(Color.decode("#292C35"));
        l5.setBounds(720, 492, 48, 48);
        p1.add(l5);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image img6 = i6.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ib6 = new ImageIcon(img6);
        JButton l6 = new JButton(ib6);
        l6.setBackground(Color.decode("#fcd9b8"));
        l6.setBounds(650, 170, 50, 50);
        p1.add(l6);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(110, 190, 100, 30);
        lblID.setFont(new Font("Arial", Font.BOLD, 17));
        lblID.setForeground(Color.decode("#000000"));
        p1.add(lblID);

        t2 = new JTextField();
        t2.setBounds(200, 190, 200, 27);
        p1.add(t2);

        JLabel l7 = new JLabel("Name");
        l7.setForeground(Color.decode("#000000"));
        l7.setFont(new Font("Arial", Font.BOLD, 17));
        l7.setBounds(110, 230, 100, 30);
        p1.add(l7);

        t3 = new JTextField();
        t3.setBounds(200, 230, 200, 27);
        p1.add(t3);

        JLabel l8 = new JLabel("Age");
        l8.setForeground(Color.decode("#000000"));
        l8.setFont(new Font("Arial", Font.BOLD, 17));
        l8.setBounds(110, 270, 100, 30);
        p1.add(l8);

        t4 = new JTextField();
        t4.setBounds(200, 270, 200, 27);
        p1.add(t4);

        JLabel l9 = new JLabel("Gender");
        l9.setForeground(Color.decode("#000000"));
        l9.setFont(new Font("Arial", Font.BOLD, 17));
        l9.setBounds(110, 310, 100, 30);
        p1.add(l9);

        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setForeground(Color.decode("#000000"));
        NewRadioButton.setBackground(Color.decode("#fcd9b8"));
        NewRadioButton.setBounds(200, 310, 70, 27);
        p1.add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setForeground(Color.decode("#000000"));
        Female.setBackground(Color.decode("#fcd9b8"));
        Female.setBounds(270, 310, 70, 27);
        p1.add(Female);

        JLabel l10 = new JLabel("Job");
        l10.setForeground(Color.decode("#000000"));
        l10.setFont(new Font("Arial", Font.BOLD, 17));
        l10.setBounds(110, 350, 100, 30);
        p1.add(l10);

        JComboBox comboBox = new JComboBox(new String[] {"receptionist", "manager", "waiter", "housekeeping", "room service", "security"});
        comboBox.setBounds(200, 350, 150, 27);
        p1.add(comboBox);

        JLabel l11 = new JLabel("Salary");
        l11.setForeground(Color.decode("#000000"));
        l11.setFont(new Font("Arial", Font.BOLD, 17));
        l11.setBounds(110, 390, 100, 30);
        p1.add(l11);

        t5 = new JTextField();
        t5.setBounds(200, 390, 200, 27);
        p1.add(t5);

        JLabel l12 = new JLabel("Phone");
        l12.setForeground(Color.decode("#000000"));
        l12.setFont(new Font("Arial", Font.BOLD, 17));
        l12.setBounds(110, 430, 100, 30);
        p1.add(l12);

        t6 = new JTextField();
        t6.setBounds(200, 430, 200, 27);
        p1.add(t6);

        JLabel l13 = new JLabel("Email");
        l13.setForeground(Color.decode("#000000"));
        l13.setFont(new Font("Arial", Font.BOLD, 17));
        l13.setBounds(110, 470, 100, 30);
        p1.add(l13);

        t7 = new JTextField();
        t7.setBounds(200, 470, 200, 27);
        p1.add(t7);

        JPanel panel = new JPanel();
        panel.setBounds(100, 170, 600, 370);
        panel.setBackground(Color.decode("#fcd9b8"));
        p1.add(panel);

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

        setVisible(true);
    }


    public static void main(String[] args) throws SQLException {
        new EditEmployee() ;
    }
}
