package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.ProfileUserController;
import com.hotelManagementSystem.dao.ManagerDashboardDao;
import com.hotelManagementSystem.dao.ProfileUserDao;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.controller.AddUserController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileUser extends JFrame{

    private static JPanel p1;
    private JTextField t1,t2,t3,t4, t5, t6;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    Choice c1;
    private  Account account;
    private User user;


    public JPanel getP1(){
        return p1;
    }
    public ProfileUser() {
        initComponent();
//        setLocationRelativeTo(null);

    }
    private void initComponent() {
        p1 = new JPanel();
        p1.setSize(900, 600);
        p1.setLocation(100, 100);
        setContentPane(p1);
        p1.setLayout(null);
        account = new Account();
        user = new User();

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/editInfo.jpg"));
        Image i3 = i1.getImage().getScaledInstance(530, 530,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(450,40,700,550);
        add(l15);

        JLabel l10 = new JLabel("EDIT USER INFORMATION");
        l10.setFont(new Font("Arial", Font.BOLD, 35));
        l10.setBounds(35, 30, 442, 35);
        p1.add(l10);


        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.decode("#17181D"));
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setBounds(70, 130, 150, 27);
        p1.add(l2);

        t2 = new JTextField();
        t2.setBounds(210, 130, 150, 27);
        t2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t2.getText().length() > 0) {
                    t2.setBackground(Color.decode("#E0E0E0"));
                    user.setName(t2.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t2.getText().length() == 0) {
                    t2.setBackground(Color.WHITE);
                    user.setName(t2.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setName(t2.getText());
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        p1.add(t2);

        JLabel l3 = new JLabel("Age");
        l3.setFont(new Font("Arial", Font.BOLD, 17));
        l3.setForeground(Color.decode("#17181D"));
        l3.setBounds(70, 180, 150, 27);
        p1.add(l3);

        t3 = new JTextField();
        t3.setBounds(210, 180, 150, 27);
        t3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t3.getText().length() > 0) {
                    t3.setBackground(Color.decode("#E0E0E0"));
                    user.setAge(Integer.parseInt(t3.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t3.getText().length() == 0) {
                    t3.setBackground(Color.WHITE);
                    user.setAge(0);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setAge(Integer.parseInt(t3.getText()));
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        p1.add(t3);

        JLabel l4 = new JLabel("Gender");
        l4.setFont(new Font("Arial", Font.BOLD, 17));
        l4.setForeground(Color.decode("#17181D"));
        l4.setBounds(70, 230, 150, 27);
        p1.add(l4);


        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(210, 230, 70, 27);
        p1.add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 230, 70, 27);
        p1.add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        bg.add(Female);
        if(bg.getSelection() == Female.getModel()){
            user.setGender("female");
        }else {
            user.setGender("male");
        }


        JLabel l8 = new JLabel("Phone");
        l8.setFont(new Font("Arial", Font.BOLD, 17));
        l8.setForeground(Color.decode("#17181D"));
        l8.setBounds(70, 280, 150, 27);
        p1.add(l8);

        t5 = new JTextField();
        t5.setBounds(210, 280, 150, 27);
        t5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t5.getText().length() > 0) {
                    t5.setBackground(Color.decode("#E0E0E0"));
                    user.setPhone(t5.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t5.getText().length() == 0) {
                    t5.setBackground(Color.WHITE);
                    user.setPhone(t5.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setPhone(t5.getText());
            }
        });
        p1.add(t5);

        JLabel l9 = new JLabel("Email");
        l9.setFont(new Font("Arial", Font.BOLD, 17));
        l9.setForeground(Color.decode("#17181D"));
        l9.setBounds(70, 330, 150, 27);
        p1.add(l9);

        t6 = new JTextField();
        t6.setBounds(210, 330, 150, 27);
        t6.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t6.getText().length() > 0) {
                    t6.setBackground(Color.decode("#E0E0E0"));
                    user.setEmail(t6.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t6.getText().length() == 0) {
                    t6.setBackground(Color.WHITE);
                    user.setEmail(t6.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setEmail(t6.getText());
            }
        });
        p1.add(t6);

        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Arial", Font.BOLD, 17));
        l5.setForeground(Color.decode("#17181D"));
        l5.setBounds(70, 380, 150, 27);
        p1.add(l5);

        t4 = new JTextField();
        t4.setBounds(210, 380, 150, 27);
        t4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (t4.getText().length() > 0) {
                    t4.setBackground(Color.decode("#E0E0E0"));
                    account.setPassword(t4.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (t4.getText().length() == 0) {
                    t4.setBackground(Color.WHITE);
                    account.setPassword(t4.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setPassword(t4.getText());
            }
        });
        p1.add(t4);

        JButton b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 450, 111, 33);
        new ProfileUserController().updateBtn(b1,account, user);
        p1.add(b1);
        p1.setBackground(Color.WHITE);
    }


}