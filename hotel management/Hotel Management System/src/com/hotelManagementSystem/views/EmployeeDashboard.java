package com.hotelManagementSystem.views;

import com.hotelManagementSystem.controller.EmployeeDashboardController;
import com.hotelManagementSystem.controller.ManagerDashboardController;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.dao.EmployeeDashboardDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDashboard extends JFrame {

    private JLabel l1;
    private JPanel p1, p2;
    private static JPanel p3, p4, p5, p6, p7, p8, p9, p10;
    private JTextArea t1;
    private static JTextArea t2;
    private  JButton logoutBtn, newCustomerBtn, viewBtn, customerBtn,profileBtn, chechInOutBtn, updateRoomBtn, pickUpServiceBtn, searchRoomBtn, chatBtn;
    private ImageIcon logoutIcon;
    private  Image logoutImage;
    private static JLabel labelListBtnCheckInOut;
    private static String UserName;
    public EmployeeDashboard() {
        initComponent();
        setLocationRelativeTo(null);

    }
    public static JPanel getP3() {
        return p3;
    }
    public static void setP3(JPanel p) {
        p3 = p;
    }

    private void initComponent() {
        setSize(1400, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        t2.setEditable(false);
        try{

            Login l = new Login();
            l.setVisible(false);
            UserName = new EmployeeDashboardDao().setTextNameUser(l.getIDLogin());
            t2.setText(UserName);

        }catch(Exception e){

        }

        l1.add(t2);



        p2 = new JPanel();
        p2.setBounds(0, 100, 250, 800);
        p2.setBackground(Color.decode("#292c35"));
        p2.setLayout(null);
        add(p2);

        p3 = new JPanel();
        p3.setBounds(265, 130, 1100, 600);
        p3.setBackground(Color.decode("#d5e1e4"));
        p3.setLayout(null);
        add(p3);

        p4 = new JPanel();
        p4.setBounds(265, 130, 1100, 600);
        p4.setBackground(Color.decode("#d5e1e4"));
        p4.setVisible(false);
        p4.setLayout(null);
        add(p4);

        p5 = new JPanel();
        p5.setBounds(265, 130, 1100, 600);
        p5.setBackground(Color.decode("#d5e1e4"));
        p5.setVisible(false);
        p5.setLayout(null);
        add(p5);

        p6 = new JPanel();
        p6.setBounds(265, 130, 1100, 600);
        p6.setVisible(false);
        p6.setLayout(null);
        add(p6);

        p7 = new JPanel();
        p7.setBounds(265, 130, 1100, 600);
        p7.setVisible(false);
        p7.setLayout(null);
        add(p7);

        p8 = new JPanel();
        p8.setBounds(265, 130, 1100, 600);
        p8.setVisible(false);
        p8.setLayout(null);
        add(p8);

        p9 = new JPanel();
        p9.setBounds(265, 130, 1100, 600);
        p9.setVisible(false);
        p9.setLayout(null);
        add(p9);

        p10 = new JPanel();
        p10.setBounds(265, 130, 1100, 600);

        p10.setVisible(false);
        p10.setLayout(null);
        add(p10);



        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("icons/editUser.jpg"));
        Image profileImage = profileIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        profileBtn = new JButton(new ImageIcon(profileImage));
        profileBtn.setBorder(null);
        profileBtn.setBounds(1250, 30, 30, 30);
        profileBtn.setBackground(Color.decode("#272a32"));
        new EmployeeDashboardController().profileBtn(profileBtn, p7, p3, p4, p5, p6, p8, p9, p10);
        p1.add(profileBtn);


        newCustomerBtn = new JButton("New Customer");
        newCustomerBtn.setBounds(0, 0, 250, 50);
        newCustomerBtn.setBorder(null);
        newCustomerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        newCustomerBtn.setBackground(Color.decode("#292c35"));
        newCustomerBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().newCustomerBtn(newCustomerBtn, p3, p4, p5, p6, p7, p8, p9, p10);
        p2.add(newCustomerBtn);

        viewBtn = new JButton("Update Customer");
        viewBtn.setBounds(0, 50, 250, 50);
        viewBtn.setBorder(null);
        viewBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        viewBtn.setBackground(Color.decode("#292c35"));
        viewBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().updateCustomerBtn(viewBtn,p5, p3, p4, p6, p7, p8, p9, p10);
        p2.add(viewBtn);

        customerBtn = new JButton("Customer Info");
        customerBtn.setBounds(0, 100, 250, 50);
        customerBtn.setBorder(null);
        customerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        customerBtn.setBackground(Color.decode("#292c35"));
        customerBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().customerInfoBtn(customerBtn, p4, p3, p5, p6, p7, p8, p9, p10);
        p2.add(customerBtn);

        labelListBtnCheckInOut = new JLabel();
        labelListBtnCheckInOut.setBounds(250, 260, 140, 60);
        labelListBtnCheckInOut.setBackground(Color.decode("#b8b8b8"));
        labelListBtnCheckInOut.setLayout(null);
        labelListBtnCheckInOut.setVisible(false);
        add(labelListBtnCheckInOut);


        chechInOutBtn = new JButton("Check Out");
        chechInOutBtn.setBounds(0, 150, 250, 50);
        chechInOutBtn.setBorder(null);
        chechInOutBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chechInOutBtn.setBackground(Color.decode("#292c35"));
        chechInOutBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().checkInOutBtn(chechInOutBtn, p8, p3, p4, p5, p6, p7, p9, p10);
        p2.add(chechInOutBtn);

        updateRoomBtn = new JButton("History");
        updateRoomBtn.setBounds(0, 200, 250, 50);
        updateRoomBtn.setBorder(null);
        updateRoomBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        updateRoomBtn.setBackground(Color.decode("#292c35"));
        updateRoomBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().historyBtn(updateRoomBtn, p9, p3, p4, p5, p6, p7, p8, p10);
        p2.add(updateRoomBtn);

        pickUpServiceBtn = new JButton("Driver Info");
        pickUpServiceBtn.setBounds(0, 250, 250, 50);
        pickUpServiceBtn.setBorder(null);
        pickUpServiceBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        pickUpServiceBtn.setBackground(Color.decode("#292c35"));
        pickUpServiceBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().driverInfoBtn(pickUpServiceBtn, p10, p3, p4, p5, p6, p7, p8, p9);
        p2.add(pickUpServiceBtn);

        searchRoomBtn = new JButton("Search Room");
        searchRoomBtn.setBounds(0, 300, 250, 50);
        searchRoomBtn.setBorder(null);
        searchRoomBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        searchRoomBtn.setBackground(Color.decode("#292c35"));
        searchRoomBtn.setForeground(Color.decode("#f0f5f5"));
        new EmployeeDashboardController().checkSearchRoomBtn(searchRoomBtn, p6, p4, p5, p3, p7, p8, p9, p10);
        p2.add(searchRoomBtn);

        ImageIcon chatBut = new ImageIcon(ClassLoader.getSystemResource("icons/chat_ic.png"));
        Image chat1 = chatBut.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        chatBtn = new JButton(new ImageIcon(chat1));
        chatBtn.setBounds(100, 600, 50, 50);
        chatBtn.setBorder(null);
        chatBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chatBtn.setBackground(Color.decode("#292c35"));
        chatBtn.setForeground(Color.decode("#f0f5f5"));
        p2.add(chatBtn);




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
