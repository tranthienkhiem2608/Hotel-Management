package com.hotelManagementSystem.app;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class EmployeeDashboard extends JFrame {

    private JLabel l1;
    private JPanel p1, p2;
    private JTextArea t1, t2;
    private  JButton logoutBtn, newCustomerBtn, viewBtn, customerBtn, chechInOutBtn, updateRoomBtn, pickUpServiceBtn, searchRoomBtn;
    private ImageIcon logoutIcon;
    private  Image logoutImage;

    EmployeeDashboard() {
        setSize(1400, 800);
        setLocation(200, 100);
        setLayout(null);


        p1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#17181D"), getWidth(), getHeight(), Color.decode("#292C35"));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        p1.setBounds(0, 0, 1400, 100);
        p1.setLayout(null);
        add(p1);
        logoutIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logout.png"));
        logoutImage = logoutIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        logoutBtn = new JButton(new ImageIcon(logoutImage));
        logoutBtn.setBorder(null);
        logoutBtn.setBounds(1300, 30, 30, 30);
        logoutBtn.setBackground(Color.decode("#272a32"));
        logoutBtn.addActionListener(e -> {
            new Login();
            dispose();
        });
        p1.add(logoutBtn);

        t1 = new JTextArea("Employee Dashboard");
        t1.setBounds(10, 0, 300, 40);
        t1.setFont(new Font("serif", Font.BOLD, 30));
        t1.setForeground(Color.decode("#e09145"));
        t1.setBackground(Color.decode("#1b1c22"));
        t1.setEditable(false);
        p1.add(t1);

        l1 = new JLabel("Welcome to the system, ");
        l1.setBounds(15, 40, 300, 50);
        l1.setFont(new Font("serif", Font.ITALIC, 20));
        l1.setForeground(Color.decode("#f0f5f5"));
        l1.setBackground(Color.decode("#1b1c22"));
        p1.add(l1);

        t2 = new JTextArea("User");
        t2.setBounds(195, 12, 200, 25);
        t2.setFont(new Font("serif", Font.ITALIC, 20));
        t2.setForeground(Color.decode("#b3530b"));
        t2.setBackground(Color.decode("#1b1c22"));
        t2.setEditable(true);
        try{
            Conn c = new Conn();
            Login l = new Login();
            l.setVisible(false);
            String username = l.getUsername();
            String password = l.getPassword();
            ResultSet rs = c.s.executeQuery("select * from users where username = '"+username+"' and password = '"+password+"'");
            try {
                if (rs.next()) {
                    t2.setText(rs.getString("username"));
                } else {
                    t2.setText("null");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){

        }

        l1.add(t2);


        p2 = new JPanel();
        p2.setBounds(0, 100, 250, 800);
        p2.setBackground(Color.decode("#292c35"));
        p2.setLayout(null);
        add(p2);

        newCustomerBtn = new JButton("New Customer");
        newCustomerBtn.setBounds(0, 0, 250, 50);
        newCustomerBtn.setBorder(null);
        newCustomerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        newCustomerBtn.setBackground(Color.decode("#292c35"));
        newCustomerBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(newCustomerBtn);

        viewBtn = new JButton("View Customer");
        viewBtn.setBounds(0, 50, 250, 50);
        viewBtn.setBorder(null);
        viewBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        viewBtn.setBackground(Color.decode("#292c35"));
        viewBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(viewBtn);

        customerBtn = new JButton("Customer Info");
        customerBtn.setBounds(0, 100, 250, 50);
        customerBtn.setBorder(null);
        customerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        customerBtn.setBackground(Color.decode("#292c35"));
        customerBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(customerBtn);

        chechInOutBtn = new JButton("Check In/Out");
        chechInOutBtn.setBounds(0, 150, 250, 50);
        chechInOutBtn.setBorder(null);
        chechInOutBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chechInOutBtn.setBackground(Color.decode("#292c35"));
        chechInOutBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(chechInOutBtn);

        updateRoomBtn = new JButton("Update Room");
        updateRoomBtn.setBounds(0, 200, 250, 50);
        updateRoomBtn.setBorder(null);
        updateRoomBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        updateRoomBtn.setBackground(Color.decode("#292c35"));
        updateRoomBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(updateRoomBtn);

        pickUpServiceBtn = new JButton("Pick Up Service");
        pickUpServiceBtn.setBounds(0, 250, 250, 50);
        pickUpServiceBtn.setBorder(null);
        pickUpServiceBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        pickUpServiceBtn.setBackground(Color.decode("#292c35"));
        pickUpServiceBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(pickUpServiceBtn);

        searchRoomBtn = new JButton("Search Room");
        searchRoomBtn.setBounds(0, 300, 250, 50);
        searchRoomBtn.setBorder(null);
        searchRoomBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        searchRoomBtn.setBackground(Color.decode("#292c35"));
        searchRoomBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(searchRoomBtn);





        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#c9d2d4"), getWidth(), getHeight(), Color.decode("#ddecf0"));
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
        new EmployeeDashboard();
    }
}
