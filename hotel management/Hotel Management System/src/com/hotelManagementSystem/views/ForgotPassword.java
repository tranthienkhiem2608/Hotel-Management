package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class ForgotPassword extends JFrame {

    private ImageIcon i1,ib1, backBut, checkBut;
    private Image img1, imgButton1, imgButton2;
    private JLabel  l1, l2, phoneLabel, answerLabel, passwordLabel, confirmPasswordLabel, usernameLabel, resultUsernameLabel;
    private JTextField phoneField, answerField, passwordField, confirmPasswordField;
    private JButton comfirmBtn, backBtn, checkBtn;
    private JTextArea t1;

    private Conn c;
    private ResultSet rs;

    private String phone, answer, query, password, confirmPassword;
    public ForgotPassword(){
        initComponent();
        setLocationRelativeTo(null);

    }

    private void initComponent() {
        setSize(1400, 800);
        setLayout(null);

        backBut = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        imgButton1 = backBut.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        backBtn = new JButton(new ImageIcon(imgButton1));
        backBtn.setBounds(10, 10, 30, 30);
        backBtn.setBorder(null);
        backBtn.setBackground(Color.decode("#292C35"));
        // witre add action listener
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
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
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phone = phoneField.getText();
                answer = answerField.getText();
                query = "select * from users where phone = '"+phone+"' and answer = '"+answer+"'";
                try{
                    c = new Conn();
                    rs = c.getStatment().executeQuery(query);
                    if(rs.next()){
                        resultUsernameLabel.setText(rs.getString("username"));
                        resultUsernameLabel.setForeground(Color.decode("#069e20"));
                    }else{
                        resultUsernameLabel.setText("not found");
                        resultUsernameLabel.setForeground(Color.decode("#a30f0f"));
                        new Notification("Wrong phone or answer");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
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
        add(confirmPasswordField);

        comfirmBtn = new JButton("Confirm");
        comfirmBtn.setBounds(130, 470, 280, 40);
        comfirmBtn.setBackground(Color.decode("#000000"));
        comfirmBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        comfirmBtn.setForeground(Color.decode("#ffffff"));
        comfirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password = passwordField.getText();
                confirmPassword = confirmPasswordField.getText();
                String tmp = "0";
                if(password.equals(confirmPassword)){
                    query = "update users set password = '"+password+"' where username = '"+resultUsernameLabel.getText()+"'";
                    try{
                        c = new Conn();
                        c.getStatment().executeUpdate(query);
                        setVisible(false);
                        new Login().setVisible(true);
                        new Notification( "Password changed successfully");
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }else{
                    setVisible(true);
                    new Notification( "Password not matched");
                }
            }
        });
        add(comfirmBtn);


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