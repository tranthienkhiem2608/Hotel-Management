package com.hotelManagementSystem.views;

import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.dao.*;
import com.hotelManagementSystem.controller.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class ForgotPassword extends JFrame {

    private ImageIcon i1,ib1, backBut, checkBut;
    private Image img1, imgButton1, imgButton2;
    private JLabel  l1, l2, phoneLabel, answerLabel, passwordLabel, confirmPasswordLabel, usernameLabel;
    private static JLabel resultUsernameLabel;
    private JTextField phoneField, answerField, passwordField, confirmPasswordField;
    private JButton comfirmBtn, backBtn, checkBtn;
    private JTextArea t1;


    private static User user;
    private static Account account;
    public ForgotPassword(){
        initComponent();
        setLocationRelativeTo(null);

    }

    private void initComponent() {
        setSize(1400, 800);
        setLayout(null);
        user = new User();
        account = new Account();

        backBut = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        imgButton1 = backBut.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        backBtn = new JButton(new ImageIcon(imgButton1));
        backBtn.setBounds(10, 10, 30, 30);
        backBtn.setBorder(null);
        backBtn.setBackground(Color.decode("#292C35"));
        // witre add action listener
        new LoginController().changeToLogin(backBtn,this);
        add(backBtn);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(100, 150, 100, 30);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(230, 150, 220, 30);
        phoneField.setBackground(Color.decode("#e6f2f2"));
        phoneField.setFont(new Font("Arial", Font.PLAIN, 15));
        phoneField.setForeground(Color.decode("#1a1a1a"));
        phoneField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                user.setPhone(phoneField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                user.setPhone(phoneField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                user.setPhone(phoneField.getText());
            }
        });
        add(phoneField);

        t1 = new JTextArea("Security Question: What is your favourite food?");
        t1.setBounds(100, 200, 350, 20);
        t1.setBackground(Color.decode("#FCD9B8"));
        t1.setFont(new Font("Arial", Font.ITALIC, 15));
        t1.setForeground(Color.decode("#1a1a1a"));
        t1.setEditable(false);
        add(t1);

        answerLabel = new JLabel("Answer");
        answerLabel.setBounds(100, 220, 100, 30);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(answerLabel);

        answerField = new JTextField();
        answerField.setBounds(230, 220, 220, 30);
        answerField.setBackground(Color.decode("#e6f2f2"));
        answerField.setFont(new Font("Arial", Font.PLAIN, 15));
        answerField.setForeground(Color.decode("#1a1a1a"));
        answerField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                account.setKeyAnswer(answerField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                account.setKeyAnswer(answerField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setKeyAnswer(answerField.getText());
            }
        });
        add(answerField);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(100, 270, 100, 30);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(usernameLabel);

        resultUsernameLabel = new JLabel(" ");
        resultUsernameLabel.setBounds(230, 270, 100, 30);
        resultUsernameLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        resultUsernameLabel.setForeground(Color.decode("#1a1a1a"));
        add(resultUsernameLabel);


        checkBut = new ImageIcon(ClassLoader.getSystemResource("icons/checkIcon.png"));
        checkBtn = new JButton(new ImageIcon(checkBut.getImage().getScaledInstance(45, 40, Image.SCALE_DEFAULT)));
        checkBtn.setBounds(420, 270, 46, 46);
        checkBtn.setBorder(null);
        checkBtn.setBackground(Color.decode("#fcd9b8"));
        // witre add action listener
        new ForgotPasswordController().checkUser(checkBtn, user, account, resultUsernameLabel);
        add(checkBtn);


        passwordLabel = new JLabel("New password");
        passwordLabel.setBounds(100, 320, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(230, 320, 220, 30);
        passwordField.setBackground(Color.decode("#e6f2f2"));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setForeground(Color.decode("#1a1a1a"));
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                account.setPassword(passwordField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                account.setPassword(passwordField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setPassword(passwordField.getText());
            }
        });
        add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm password");
        confirmPasswordLabel.setBounds(100, 370, 200, 30);
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(confirmPasswordLabel);

        confirmPasswordField = new JTextField();
        confirmPasswordField.setBounds(230, 370, 220, 30);
        confirmPasswordField.setBackground(Color.decode("#e6f2f2"));
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        confirmPasswordField.setForeground(Color.decode("#1a1a1a"));
        confirmPasswordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                account.setConfirmPassword(confirmPasswordField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                account.setConfirmPassword(confirmPasswordField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                account.setConfirmPassword(confirmPasswordField.getText());
            }
        });
        add(confirmPasswordField);


        comfirmBtn = new JButton("Confirm");
        comfirmBtn.setBounds(130, 470, 280, 40);
        comfirmBtn.setBackground(Color.decode("#000000"));
        comfirmBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        comfirmBtn.setForeground(Color.decode("#ffffff"));
        new ForgotPasswordController().changePasswword(comfirmBtn, user, account, this);
        add(comfirmBtn);
        getRootPane().setDefaultButton(comfirmBtn);


        JPanel panelForm = new JPanel();
        panelForm.setBounds(80, 100, 400, 550);
        panelForm.setBackground(Color.decode("#FCD9B8"));
        add(panelForm);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logologin.png"));
        img1 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ib1 = new ImageIcon(img1);
        l1 = new JLabel(ib1);
        l1.setBounds(800, 200, 400, 400);
        add(l1);

        JPanel panel = new JPanel();
        l2 = new JLabel("Forgot Password");
        l2.setBounds(600, 300, 800, 100);
        l2.setFont(new Font("Arial", Font.BOLD, 40));
        l2.setForeground(Color.decode("#E09145"));
        panel.add(l2);
        panel.setBounds(600, 0, 800, 800);
        panel.setBackground(Color.decode("#17181D"));
        add(panel);

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
        add(gradientPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgotPassword().setVisible(true);
    }
}