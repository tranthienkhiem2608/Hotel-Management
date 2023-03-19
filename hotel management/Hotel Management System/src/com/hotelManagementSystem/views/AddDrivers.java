package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotelManagementSystem.controller.AddDriversController;
import com.hotelManagementSystem.entity.Driver;

public class AddDrivers extends JFrame {

    private static JPanel p1;
    private JTextField t1,t2,t3,t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    private Driver driver;


    public JPanel getP1(){
        return p1;
    }
    public AddDrivers() {
        initComponent();
//        setLocationRelativeTo(null);

    }
    private void initComponent() {
        p1 = new JPanel();
        p1.setSize(900, 600);
        p1.setLocation(100, 100);
        setContentPane(p1);
        p1.setLayout(null);
        driver = new Driver();

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/drivers.jpg"));
        Image i3 = i1.getImage().getScaledInstance(480, 480,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(380,30,500,450);
        add(l15);

        JLabel l10 = new JLabel("ADD DRIVER");
        l10.setFont(new Font("Arial", Font.BOLD, 35));
        l10.setBounds(525, 30, 442, 35);
        p1.add(l10);



        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.decode("#17181D"));
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setBounds(60, 80, 150, 27);
        p1.add(l1);


        t1 = new JTextField();
        t1.setBounds(174, 80, 150, 27);
        t1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                driver.setName(t1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                driver.setName(t1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                driver.setName(t1.getText());
            }
        });
        p1.add(t1);


        JLabel l2 = new JLabel("Age");
        l2.setForeground(Color.decode("#17181D"));
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setBounds(60, 130, 150, 27);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(174, 130, 150, 27);
        t2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                driver.setAge(Integer.parseInt(t2.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                driver.setAge(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                driver.setAge(Integer.parseInt(t2.getText()));
            }
        });
        p1.add(t2);


        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Arial", Font.BOLD, 17));
        Gender.setBounds(60, 180, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(170, 180, 70, 27);
        p1.add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(240, 180, 70, 27);
        p1.add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        if(bg.getSelection() == Female.getModel()){
            driver.setGender("female");
        }else {
            driver.setGender("male");
        }
        bg.add(Female);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(Color.decode("#17181D"));
        l4.setFont(new Font("Arial", Font.BOLD, 17));
        l4.setBounds(60, 230, 150, 27);
        p1.add(l4);

        t3 = new JTextField();
        t3.setBounds(174, 230, 150, 27);
        t3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                driver.setCarCompany(t3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                driver.setCarCompany(t3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                driver.setCarCompany(t3.getText());
            }
        });
        p1.add(t3);

        JLabel l5 = new JLabel("Car Brand");
        l5.setForeground(Color.decode("#17181D"));
        l5.setFont(new Font("Arial", Font.BOLD, 17));
        l5.setBounds(60, 280, 150, 27);
        p1.add(l5);


        t4 = new JTextField();
        t4.setBounds(174, 280, 150, 27);
        t4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                driver.setCarBrand(t4.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                driver.setCarBrand(t4.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                driver.setCarBrand(t4.getText());
            }
        });
        p1.add(t4);


        JLabel l6 = new JLabel("Available");
        l6.setForeground(Color.decode("#17181D"));
        l6.setFont(new Font("Arial", Font.BOLD, 17));
        l6.setBounds(60, 330, 150, 27);
        p1.add(l6);

        comboBox = new JComboBox(new String[] { "yes", "no" });
        comboBox.setBounds(174, 330, 150, 27);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driver.setAvailable((String) comboBox.getSelectedItem());
            }
        });
        p1.add(comboBox);


        JLabel l7 = new JLabel("Location");
        l7.setForeground(Color.decode("#17181D"));
        l7.setFont(new Font("Arial", Font.BOLD, 17));
        l7.setBounds(60, 380, 150, 27);
        p1.add(l7);


        t5 = new JTextField();
        t5.setBounds(174, 380, 150, 27);
        t5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                driver.setLocation(t5.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                driver.setLocation(t5.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                driver.setLocation(t5.getText());
            }
        });
        p1.add(t5);



        b1 = new JButton("ADD");
        b1.setBounds(80, 430, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        new AddDriversController().addDriversBtn(b1, driver);
        p1.add(b1);
        getRootPane().setDefaultButton(b1);

    }

}