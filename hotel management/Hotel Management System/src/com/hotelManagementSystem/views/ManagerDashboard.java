package com.hotelManagementSystem.views;
import com.hotelManagementSystem.conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import com.hotelManagementSystem.entity.User;

public class ManagerDashboard extends JFrame{

    private JLabel l1;
    private JPanel p1, p2;
    private JTextArea t1, t2;
    private  JButton logoutBtn, addBtn, viewBtn, customerBtn, employeeBtn, managerBtn, updateStatusBtn, searchRoomBtn, statisticsBtn, historyBtn;
    private ImageIcon logoutIcon;
    private  Image logoutImage;

     public ManagerDashboard() {
        initComponent();
        setLocationRelativeTo(null);

    }

    private void initComponent() {
        setSize(1400, 800);
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

        t1 = new JTextArea("Manager Dashboard");
        t1.setBounds(10, 0, 300, 40);
        t1.setFont(new Font("serif", Font.BOLD, 30));
        t1.setForeground(Color.decode("#e09145"));
        t1.setBackground(Color.decode("#1b1c22"));
        t1.setEditable(false);
        p1.add(t1);

        l1 = new JLabel("Welcome to the system, ");
        l1.setBounds(10, 40, 300, 50);
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
            Login l = new Login();
            l.setVisible(false);
            t2.setText(l.getUsernameLogin());


        }catch(Exception e){

        }
        l1.add(t2);


        p2 = new JPanel();
        p2.setBounds(0, 100, 250, 800);
        p2.setBackground(Color.decode("#292c35"));
        p2.setLayout(null);
        add(p2);

        addBtn = new JButton("Add Room");
        addBtn.setBounds(0, 0, 250, 50);
        addBtn.setBorder(null);
        addBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        addBtn.setBackground(Color.decode("#292c35"));
        addBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(addBtn);

        viewBtn = new JButton("View Room");
        viewBtn.setBounds(0, 50, 250, 50);
        viewBtn.setBorder(null);
        viewBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        viewBtn.setBackground(Color.decode("#292c35"));
        viewBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(viewBtn);

        customerBtn = new JButton("Customer info");
        customerBtn.setBounds(0, 100, 250, 50);
        customerBtn.setBorder(null);
        customerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        customerBtn.setBackground(Color.decode("#292c35"));
        customerBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(customerBtn);

        employeeBtn = new JButton("Employee info");
        employeeBtn.setBounds(0, 150, 250, 50);
        employeeBtn.setBorder(null);
        employeeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        employeeBtn.setBackground(Color.decode("#292c35"));
        employeeBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(employeeBtn);

        managerBtn = new JButton("Manager info");
        managerBtn.setBounds(0, 200, 250, 50);
        managerBtn.setBorder(null);
        managerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        managerBtn.setBackground(Color.decode("#292c35"));
        managerBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(managerBtn);

        updateStatusBtn = new JButton("Update Status");
        updateStatusBtn.setBounds(0, 250, 250, 50);
        updateStatusBtn.setBorder(null);
        updateStatusBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        updateStatusBtn.setBackground(Color.decode("#292c35"));
        updateStatusBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(updateStatusBtn);

        searchRoomBtn = new JButton("Search");
        searchRoomBtn.setBounds(0, 300, 250, 50);
        searchRoomBtn.setBorder(null);
        searchRoomBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        searchRoomBtn.setBackground(Color.decode("#292c35"));
        searchRoomBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(searchRoomBtn);

        statisticsBtn = new JButton("Statistics");
        statisticsBtn.setBounds(0, 350, 250, 50);
        statisticsBtn.setBorder(null);
        statisticsBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        statisticsBtn.setBackground(Color.decode("#292c35"));
        statisticsBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(statisticsBtn);

        historyBtn = new JButton("History");
        historyBtn.setBounds(0, 400, 250, 50);
        historyBtn.setBorder(null);
        historyBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        historyBtn.setBackground(Color.decode("#292c35"));
        historyBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(historyBtn);




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
        new ManagerDashboard();
    }
}
