package com.hotelManagementSystem.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame{
    private JLabel user, pass, l1, l2;
    private JTextField username;
    private JPasswordField password;
    private JButton login, backBtn, forgotBtn, signupBtn;
    private ImageIcon i1, i2, i3, ib1, ib2, ib3, backBut;
    private  Image img1, img2, img3, imgButton1;
    private JTextArea t1;
    private JPanel p1;
    private static String  usernameLogin, passwordLogin;


    public String getUsername(){
        return usernameLogin;
    }
    public void setUsername(String tmp){
        usernameLogin = tmp;
    }
    public String getPassword(){
        return passwordLogin;
    }

    public void setPassword(String tmp) {
        passwordLogin = tmp;
    }
    Login(){
        setSize(1400, 800);
        setLocation(200,100);
        setLayout(null);

        p1 = new JPanel();
        p1.setBounds(0, 0, 1400, 800);
        p1.setLayout(null);
        add(p1);

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
                new HotelManagementSys().setVisible(true);
                dispose();
                //set color button
            }
        });
        p1.add(backBtn);

        user = new JLabel("Username");
        user.setBounds(100, 270, 100, 30);
        user.setFont(new Font("Arial", Font.PLAIN, 20));
        user.setForeground(Color.decode("#f0f5f5"));
        p1.add(user);

        username = new JTextField();
        username.setBounds(200, 270, 220, 30);
        username.setBackground(Color.decode("#e6f2f2"));
        username.setFont(new Font("serif", Font.PLAIN, 15));
        username.setForeground(Color.decode("#1a1a1a"));
        p1.add(username);

        pass = new JLabel("Password");
        pass.setBounds(100, 320, 100, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setForeground(Color.decode("#f0f5f5"));
        p1.add(pass);

        password = new JPasswordField();
        password.setBounds(200, 320, 220, 30);
        password.setFont(new Font("serif", Font.PLAIN, 15));
        password.setBackground(Color.decode("#e6f2f2"));
        password.setForeground(Color.decode("#1a1a1a"));
        p1.add(password);

        forgotBtn = new JButton("Forgot Password?");
        forgotBtn.setBounds(300, 360, 150, 20);
        forgotBtn.setBorder(null);
        forgotBtn.setFont(new Font("Arial", Font.BOLD, 15));
        forgotBtn.setBackground(Color.decode("#292C35"));
        forgotBtn.setForeground(Color.decode("#c44231"));
        forgotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Change password in database");
                dispose();
            }
        });
        p1.add(forgotBtn);

        login = new JButton("Login");
        login.setBounds(180, 400, 180, 50);
        login.setFont(new Font("Arial", Font.BOLD, 15));
        login.setBackground(Color.decode("#000000"));
        login.setForeground(Color.decode("#ffffff"));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                String pass = password.getText();
                setUsername(user);
                setPassword(pass);
                try{
                    Conn c = new Conn();
                    String query = "select * from Users where username = '"+user+"' and password = '"+pass+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    try {
                        if(rs.next()){
                            // check if user is manager or employee
                            String userType = rs.getString("type");
                            if(userType.equals("Manager")){
                                new ManagerDashboard().setVisible(true);
                                dispose();
                            }
                            else{
                                new EmployeeDashboard().setVisible(true);
                                dispose();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                            setVisible(true);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        p1.add(login);

        t1 = new JTextArea("Don't have an account?");
        t1.setBounds(140, 460, 180, 50);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        t1.setBackground(Color.decode("#292C35"));
        t1.setForeground(Color.decode("#f0f5f5"));
        t1.setEditable(false);
        p1.add(t1);


        signupBtn = new JButton("Sign Up");
        signupBtn.setBounds(320, 460, 60, 20);
        signupBtn.setBorder(null);
        signupBtn.setFont(new Font("Arial", Font.BOLD, 15));
        signupBtn.setBackground(Color.decode("#292C35"));
        signupBtn.setForeground(Color.decode("#f5994e"));
        //set text located to the left of the button
        signupBtn.setHorizontalAlignment(SwingConstants.LEFT);
        signupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp().setVisible(true);
                dispose();
            }
        });
        p1.add(signupBtn);


        i3 = new ImageIcon(ClassLoader.getSystemResource("icons/logologin.png"));
        img3 = i3.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ib3 = new ImageIcon(img3);
        l1 = new JLabel(ib3);
        l1.setBounds(800, 200, 400, 400);
        p1.add(l1);

        JPanel panel = new JPanel();
        l2 = new JLabel("LOGIN");

        l2.setBounds(600, 300, 800, 100);
        l2.setFont(new Font("Arial", Font.BOLD, 50));
        l2.setForeground(Color.decode("#E09145"));
        panel.add(l2);
        panel.setBounds(600, 0, 800, 800);
        panel.setBackground(Color.decode("#17181D"));
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
        gradientPanel.setBounds(0, 0, 1400, 800);
        p1.add(gradientPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

}
