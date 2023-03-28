/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.hotelManagementSystem.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotelManagementSystem.controller.LoginController;


public class HotelManagementSys extends JFrame {

    private ImageIcon i1, i3, i4, i5, i6, i7;
    private Image img1, img2, img3, img4, img5, img6;
    private JButton b1;
    private JLabel  l1, l3, l4, l5, l6, l7;
    private JPanel p1;
    public HotelManagementSys(){
        intitComponents();
        setLocationRelativeTo(null);

    }

    private void intitComponents() {
        setSize(1400, 800);
        setLayout(null);

        p1 = new JPanel();
        p1.setBounds(0, 0, 1400, 800);
        p1.setLayout(null);
        add(p1);

        i7 = new ImageIcon(ClassLoader.getSystemResource("icons/logohotel.jpg"));
        img6 = i7.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        l7 = new JLabel(new ImageIcon(img6));
        l7.setBounds(455, 210, 500, 350);
        p1.add(l7);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
        img1 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        l1 = new JLabel(new ImageIcon(img1));
        l1.setBounds(35, 45, 700, 350);
        p1.add(l1);

        i3 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel2.jpg"));
        img2 = i3.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        l3 = new JLabel(new ImageIcon(img2));
        l3.setBounds(680, 45, 700, 350);
        p1.add(l3);

        i4 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel3.jpg"));
        img3 = i4.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        l4 = new JLabel(new ImageIcon(img3));
        l4.setBounds(35, 390, 700, 350);
        p1.add(l4);

        i5 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel4.jpg"));
        img4 = i5.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        l5 = new JLabel(new ImageIcon(img4));
        l5.setBounds(680, 390, 700, 350);
        p1.add(l5);

        i6 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome2.jpg"));
        img5 = i6.getImage().getScaledInstance(500, 50, Image.SCALE_DEFAULT);
        l6 = new JLabel(new ImageIcon(img5));
        l6.setBounds(0, -60, 500, 200);
        p1.add(l6);


        b1 = new JButton("Login");
        b1.setBorder(null);
        b1.setBounds(1250, 20, 48, 23);
        b1.setBackground(Color.decode("#23252D"));
        b1.setForeground(Color.decode("#f5994e"));

        b1.setFont(new Font("serif", Font.BOLD, 20));
        new LoginController().changeToLogin(b1, this);
        p1.add(b1);;

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#17181D"), getWidth(), getHeight(), Color.decode("#292C35"));

                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setBounds(0, 0, 1400, 800);
        p1.add(gradientPanel);
        setVisible(true);

    }
//    public static void main(String[] args) {
//        new HotelManagementSys();
//    }

}
