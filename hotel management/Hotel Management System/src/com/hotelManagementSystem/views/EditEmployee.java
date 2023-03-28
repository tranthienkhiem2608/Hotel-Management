package com.hotelManagementSystem.views;

import com.hotelManagementSystem.controller.EditEmployeeController;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class EditEmployee extends JFrame{
    private static JPanel p1, p2;
    private static User user, user1;
    private JTextField t1,t2,t3,t4, t5, t6, t7;
    private static String idSearch;
    JButton b1,b2;

    public JPanel getP1(){
        return p1;
    }
    public EditEmployee() {
        initComponent();
    }
    private void initComponent() {
        setSize(1000, 600);
        setLocation(200, 100);
        p1 = new JPanel();
        p1.setSize(1000, 600);
        p1.setLocation(100, 100);
        p1.setLayout(null);
        add(p1);
        user = new User();
        user1 = new User();

        p2 = new JPanel();
        p2.setBounds(100, 170, 700, 370);
        p2.setBackground(Color.decode("#fcd9b8"));
        p2.setLayout(null);
        p2.setVisible(false);
        p1.add(p2);



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
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        t1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user.setId(t1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user.setId(t1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setId(t1.getText());
            }
        });
        p1.add(t1);



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/edit.png"));
        Image img4 = i4.getImage().getScaledInstance(128, 126, Image.SCALE_DEFAULT);
        ImageIcon ib4 = new ImageIcon(img4);
        JLabel l4 = new JLabel(ib4);
        l4.setBounds(800, 70, 128, 126);
        p1.add(l4);



        JLabel lblID = new JLabel("ID");
        lblID.setBounds(50, 20, 100, 30);
        lblID.setFont(new Font("Arial", Font.BOLD, 17));
        lblID.setForeground(Color.decode("#000000"));
        p2.add(lblID);


        t2 = new JTextField();
        t2.setBounds(100, 20, 100, 27);
        t2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setId(t2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setId(t2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setId(t2.getText());
            }
        });
        p2.add(t2);

        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(350, 20, 100, 27);
        textArea1.setEditable(false);
        p2.add(textArea1);

        JLabel l7 = new JLabel("Name");
        l7.setForeground(Color.decode("#000000"));
        l7.setFont(new Font("Arial", Font.BOLD, 17));
        l7.setBounds(50, 60, 100, 30);
        p2.add(l7);

        t3 = new JTextField();
        t3.setText(user.getName());
        t3.setBounds(100, 60, 100, 27);
        t3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setName(t3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setName(t3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setName(t3.getText());
            }
        });
        p2.add(t3);
        JTextArea textArea2 = new JTextArea();
        textArea2.setBounds(350, 60, 100, 27);
        textArea2.setEditable(false);
        p2.add(textArea2);

        JLabel l8 = new JLabel("Age");
        l8.setForeground(Color.decode("#000000"));
        l8.setFont(new Font("Arial", Font.BOLD, 17));
        l8.setBounds(50, 100, 100, 30);
        p2.add(l8);

        t4 = new JTextField();
        t4.setBounds(100, 100, 100, 27);
        t4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setAge(Integer.parseInt(t4.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setAge(Integer.parseInt(t4.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setAge(Integer.parseInt(t4.getText()));
            }
        });
        p2.add(t4);

        JTextArea textArea3 = new JTextArea();
        textArea3.setBounds(350, 100, 100, 27);
        textArea3.setText(String.valueOf(user.getAge()));
        textArea3.setEditable(false);
        p2.add(textArea3);


        JLabel l9 = new JLabel("Gender");
        l9.setForeground(Color.decode("#000000"));
        l9.setFont(new Font("Arial", Font.BOLD, 17));
        l9.setBounds(50, 140, 100, 30);
        p2.add(l9);

        JRadioButton NewRadioButton = new JRadioButton("male");
        NewRadioButton.setForeground(Color.decode("#000000"));
        NewRadioButton.setBackground(Color.decode("#fcd9b8"));
        NewRadioButton.setBounds(120, 140, 70, 27);
        p2.add(NewRadioButton);

        JRadioButton Female = new JRadioButton("female");
        Female.setForeground(Color.decode("#000000"));
        Female.setBackground(Color.decode("#fcd9b8"));
        Female.setBounds(190, 140, 70, 27);
        p2.add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        bg.add(Female);
        if(bg.getSelection() == Female.getModel()){
            user1.setGender("female");
        }else {
            user1.setGender("male");
        }

        JTextArea textArea4 = new JTextArea();
        textArea4.setBounds(350, 140, 100, 27);
        textArea4.setEditable(false);
        p2.add(textArea4);

        JLabel l10 = new JLabel("Job");
        l10.setForeground(Color.decode("#000000"));
        l10.setFont(new Font("Arial", Font.BOLD, 17));
        l10.setBounds(50, 180, 100, 30);
        p2.add(l10);

        JComboBox comboBox = new JComboBox(new String[] {"receptionist", "manager", "waiter", "housekeeping", "room service", "security"});
        comboBox.setBounds(100, 180, 150, 27);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.setPosition(comboBox.getSelectedItem().toString());
            }
        });
        p2.add(comboBox);

        JTextArea textArea5 = new JTextArea();
        textArea5.setBounds(350, 180, 100, 27);
        textArea5.setText(user.getPosition());
        textArea5.setEditable(false);
        p2.add(textArea5);

        JLabel l11 = new JLabel("Salary");
        l11.setForeground(Color.decode("#000000"));
        l11.setFont(new Font("Arial", Font.BOLD, 17));
        l11.setBounds(50, 220, 100, 30);
        p2.add(l11);

        t5 = new JTextField();
        t5.setBounds(100, 220, 100, 27);
        t5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setSalary(t5.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setSalary(t5.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setSalary(t5.getText());
            }
        });
        p2.add(t5);

        JTextArea textArea6 = new JTextArea();
        textArea6.setBounds(350, 220, 100, 27);
        textArea6.setText(String.valueOf(user.getSalary()));
        textArea6.setEditable(false);
        p2.add(textArea6);

        JLabel l12 = new JLabel("Phone");
        l12.setForeground(Color.decode("#000000"));
        l12.setFont(new Font("Arial", Font.BOLD, 17));
        l12.setBounds(50, 260, 100, 30);
        p2.add(l12);

        t6 = new JTextField();
        t6.setBounds(100, 260, 100, 27);
        t6.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setPhone(t6.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setPhone(t6.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setPhone(t6.getText());
            }
        });
        p2.add(t6);

        JTextArea textArea7 = new JTextArea();
        textArea7.setBounds(350, 260, 100, 27);
        textArea7.setText(user.getPhone());
        textArea7.setEditable(false);
        p2.add(textArea7);


        JLabel l13 = new JLabel("Email");
        l13.setForeground(Color.decode("#000000"));
        l13.setFont(new Font("Arial", Font.BOLD, 17));
        l13.setBounds(50, 300, 100, 30);
        p2.add(l13);

        t7 = new JTextField();
        t7.setBounds(100, 300, 100, 27);
        t7.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user1.setEmail(t7.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user1.setEmail(t7.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user1.setEmail(t7.getText());
            }
        });
        p2.add(t7);

        JTextArea textArea8 = new JTextArea();
        textArea8.setBounds(350, 300, 100, 27);
        textArea8.setText(user.getEmail());
        textArea8.setEditable(false);
        p2.add(textArea8);


        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/save.png"));
        Image img5 = i5.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        ImageIcon ib5 = new ImageIcon(img5);
        JButton l5 = new JButton(ib5);
        l5.setBackground(Color.decode("#292C35"));
        l5.setBounds(650, 300, 48, 48);
        new EditEmployeeController().saveUser(l5, user1);
        p2.add(l5);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image img6 = i6.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ib6 = new ImageIcon(img6);
        JButton l6 = new JButton(ib6);
        l6.setBackground(Color.decode("#fcd9b8"));
        l6.setBounds(650, 0, 50, 50);
        new EditEmployeeController().deleteUser(l6, user, p2);
        p2.add(l6);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
        Image img3 = i3.getImage().getScaledInstance(27, 27, Image.SCALE_DEFAULT);
        ImageIcon ib3 = new ImageIcon(img3);
        JButton l3 = new JButton(ib3);
        l3.setBackground(Color.decode("#292C35"));
        l3.setBounds(370, 120, 27, 27);
        new EditEmployeeController().searchIdUser(l3, user, p2, textArea1,textArea2,textArea3,textArea4,textArea5, textArea6,textArea7,textArea8);
        p1.add(l3);

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
