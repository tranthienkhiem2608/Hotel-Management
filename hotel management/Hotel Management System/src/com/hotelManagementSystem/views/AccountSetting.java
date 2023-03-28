package com.hotelManagementSystem.views;

import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.controller.AccountSettingController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class AccountSetting extends JFrame {
    private JButton btnConfirm;
    private JPanel p1;
    public AccountSetting(User user) {
        initComponents(user);
    }
    private static Account account;

    private void initComponents(User user) {
        setSize(1400, 800);
        setLocation(200,100);
        setLayout(null);


        account = new Account();
        p1 = new JPanel();
        p1.setBounds(0, 0, 1400, 800);
        p1.setLayout(null);
        add(p1);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/logologin.png"));
        Image img3 = i3.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon ib3 = new ImageIcon(img3);
        JLabel l1 = new JLabel(ib3);
        l1.setBounds(800, 200, 400, 400);
        p1.add(l1);

        JPanel panel = new JPanel();
        JLabel l2 = new JLabel("ACCOUNT SETTING");

        l2.setBounds(600, 300, 800, 100);
        l2.setFont(new Font("Arial", Font.BOLD, 50));
        l2.setForeground(Color.decode("#E09145"));
        panel.add(l2);
        panel.setBounds(600, 0, 800, 800);
        panel.setBackground(Color.decode("#17181D"));
        p1.add(panel);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(100, 100, 100, 30);
        lblName.setFont(new Font("Arial", Font.PLAIN, 20));
        lblName.setForeground(Color.decode("#f0f5f5"));
        p1.add(lblName);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(100, 150, 100, 30);
        lblID.setFont(new Font("Arial", Font.PLAIN, 20));
        lblID.setForeground(Color.decode("#f0f5f5"));
        p1.add(lblID);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(100, 200, 100, 30);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPassword.setForeground(Color.decode("#f0f5f5"));
        p1.add(lblPassword);


        JLabel lblKeyAnswer = new JLabel("Key Answer");
        lblKeyAnswer.setBounds(100, 250, 130, 30);
        lblKeyAnswer.setFont(new Font("Arial", Font.PLAIN, 20));
        lblKeyAnswer.setForeground(Color.decode("#f0f5f5"));
        p1.add(lblKeyAnswer);

        JTextArea txtName = new JTextArea(user.getName());
        txtName.setBounds(220, 100, 200, 30);
        txtName.setFont(new Font("serif", Font.PLAIN, 15));
        txtName.setBackground(Color.decode("#292c35"));
        txtName.setForeground(Color.decode("#f5410a"));
        txtName.setEditable(false);
        p1.add(txtName);

        JTextArea txtID = new JTextArea(user.getId());
        txtID.setBounds(220, 150, 200, 30);
        txtID.setFont(new Font("serif", Font.PLAIN, 15));
        txtID.setBackground(Color.decode("#292c35"));
        txtID.setForeground(Color.decode("#f5410a"));
        txtID.setEditable(false);
        p1.add(txtID);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(220, 200, 200, 30);
        txtPassword.setFont(new Font("serif", Font.PLAIN, 15));
        txtPassword.setBackground(Color.decode("#e6f2f2"));
        txtPassword.setForeground(Color.decode("#1a1a1a"));
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                account.setPassword(txtPassword.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                account.setPassword(txtPassword.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setPassword(txtPassword.getText());
            }
        });
        p1.add(txtPassword);


        JTextField txtKeyAnswer = new JTextField();
        txtKeyAnswer.setBounds(220, 250, 200, 30);
        txtKeyAnswer.setFont(new Font("serif", Font.PLAIN, 15));
        txtKeyAnswer.setBackground(Color.decode("#e6f2f2"));
        txtKeyAnswer.setForeground(Color.decode("#1a1a1a"));
        txtKeyAnswer.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                account.setKeyAnswer(txtKeyAnswer.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                account.setKeyAnswer(txtKeyAnswer.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setKeyAnswer(txtKeyAnswer.getText());
            }
        });
        p1.add(txtKeyAnswer);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(180, 350, 180, 50);
        btnConfirm.setFont(new Font("Arial", Font.BOLD, 15));
        btnConfirm.setBackground(Color.decode("#000000"));
        btnConfirm.setForeground(Color.decode("#ffffff"));
        new AccountSettingController().confirmChangePassword(btnConfirm, user, account, this);
        p1.add(btnConfirm);

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
        gradientPanel.setBounds(0, 0, 1400, 800);
        p1.add(gradientPanel);


    }
//    public static void main(String[] args) {
//        new AccountSetting(new User()).setVisible(true);
//    }
}