package com.hotelManagementSystem.views;
import ChatSys.Client.Client;
import ChatSys.Server.Server;
import com.hotelManagementSystem.conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.controller.ManagerDashboardController;
import com.hotelManagementSystem.dao.ManagerDashboardDao;


public class ManagerDashboard extends JFrame{

    private JLabel l1;
    private static JLabel labelListBtnAđd, labelListBtnEmployee;
    private JPanel p1, p2;
    private static JPanel p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private JTextArea t1;
    private static JTextArea t2;
    private static String UserName = "User";

    private  JButton logoutBtn, addBtn, viewBtn, customerBtn, employeeBtn, profileBtn, updateStatusBtn, statisticsBtn, historyBtn, driverBtn, chatBtn;
    private ImageIcon logoutIcon;
    private  Image logoutImage;
    private String[] buttonLabels = {"Room", "User", "Driver"}, buttonLabels2 = {"Employee", "Manager"};
    private JList<String> buttonList, buttonList2;



     public ManagerDashboard() {
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
        logoutBtn.setBounds(1300, 30, 30, 30
        );
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
            UserName = new ManagerDashboardDao().setTextNameUser(l.getIDLogin());
            t2.setText(UserName);
        }catch(Exception e){

        }
        l1.add(t2);

        p2 = new JPanel();
        p2.setBounds(0, 100, 250, 800);
        p2.setBackground(Color.decode("#292c35"));
        p2.setLayout(null);
        add(p2);


        labelListBtnAđd = new JLabel();
        labelListBtnAđd.setBounds(250, 100, 140, 80);
        labelListBtnAđd.setBackground(Color.decode("#b8b8b8"));
        labelListBtnAđd.setLayout(null);
        labelListBtnAđd.setVisible(false);
        add(labelListBtnAđd);

        labelListBtnEmployee = new JLabel();
        labelListBtnEmployee.setBounds(250, 260, 140, 60);
        labelListBtnEmployee.setBackground(Color.decode("#b8b8b8"));
        labelListBtnEmployee.setLayout(null);
        labelListBtnEmployee.setVisible(false);
        add(labelListBtnEmployee);

        p3 = new JPanel();
        p3.setBounds(265, 130, 1100, 600);
        p3.setBackground(Color.decode("#ffffff"));
        p3.setLayout(null);
        add(p3);

        p4 = new JPanel();
        p4.setBounds(265, 130, 1100, 600);
        p4.setBackground(Color.decode("#ffffff"));
        p4.setLayout(null);
        add(p4);

        p5 = new JPanel();
        p5.setBounds(265, 130, 1100, 600);
        p5.setBackground(Color.decode("#ffffff"));
        p5.setLayout(null);
        add(p5);

        p6 = new JPanel();
        p6.setBounds(265, 130, 1100, 600);
        p6.setBackground(Color.decode("#ffffff"));
        p6.setLayout(null);
        p6.setVisible(false);
        add(p6);

        p7 = new JPanel();
        p7.setBounds(265, 130, 1100, 600);
        p7.setBackground(Color.decode("#d5e1e4"));
        p7.setLayout(null);
        p7.setVisible(false);
        add(p7);

        p8 = new JPanel();
        p8.setBounds(265, 130, 1100, 600);
        p8.setBackground(Color.decode("#d5e1e4"));
        p8.setLayout(null);
        p8.setVisible(false);
        add(p8);

        p9 = new JPanel();
        p9.setBounds(265, 130, 1100, 600);
        p9.setBackground(Color.decode("#d5e1e4"));
        p9.setLayout(null);
        p9.setVisible(false);
        add(p9);

        p10 = new JPanel();
        p10.setBounds(265, 130, 1100, 600);
        p10.setBackground(Color.decode("#d5e1e4"));
        p10.setLayout(null);
        p10.setVisible(false);
        add(p10);

        p11 = new JPanel();
        p11.setBounds(265, 130, 1100, 600);
        p11.setBackground(Color.decode("#d5e1e4"));
        p11.setLayout(null);
        p11.setVisible(false);
        add(p11);


        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("icons/editUser.jpg"));
        Image profileImage = profileIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        profileBtn = new JButton(new ImageIcon(profileImage));
        profileBtn.setBorder(null);
        profileBtn.setBounds(1250, 30, 30, 30);
        profileBtn.setBackground(Color.decode("#272a32"));
        new ManagerDashboardController().BtnProfileUser(profileBtn, labelListBtnAđd, labelListBtnEmployee,p3,p4, p5,p6, p7, p8, p9, p10, p11);
        p1.add(profileBtn);



        buttonList = new JList<>(buttonLabels);
        buttonList.setBounds(0, 0, 140, 120);
        buttonList.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonList.setBackground(Color.decode("#a3a3a3"));
        buttonList.setForeground(Color.decode("#2b2b2b"));
        // check selected item
        new ManagerDashboardController().checkSelectBtnListAdd(buttonList, labelListBtnAđd, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        labelListBtnAđd.add(buttonList);


        buttonList2 = new JList<>(buttonLabels2);
        buttonList2.setBounds(0, 0, 140, 120);
        buttonList2.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonList2.setBackground(Color.decode("#a3a3a3"));
        buttonList2.setForeground(Color.decode("#2b2b2b"));
        // check selected item
        new ManagerDashboardController().checkSelectBtnListEmployee(buttonList2, labelListBtnEmployee, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        labelListBtnEmployee.add(buttonList2);

        addBtn = new JButton("Add");
        addBtn.setBounds(0, 0, 250, 50);
        addBtn.setBorder(null);
        addBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        addBtn.setBackground(Color.decode("#292c35"));
        addBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkAddBtn(addBtn, labelListBtnAđd, labelListBtnEmployee);
        p2.add(addBtn);


        viewBtn = new JButton("View Room");
        viewBtn.setBounds(0, 50, 250, 50);
        viewBtn.setBorder(null);
        viewBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        viewBtn.setBackground(Color.decode("#292c35"));
        viewBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkViewBtn(viewBtn,labelListBtnAđd, labelListBtnEmployee, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        p2.add(viewBtn);

        customerBtn = new JButton("Customer Info");
        customerBtn.setBounds(0, 100, 250, 50);
        customerBtn.setBorder(null);
        customerBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        customerBtn.setBackground(Color.decode("#292c35"));
        customerBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkCustomerInfoBtn(customerBtn,labelListBtnAđd, labelListBtnEmployee, p3, p4, p5, p7, p6, p8, p9, p10, p11);
        p2.add(customerBtn);



        employeeBtn = new JButton("User Info");
        employeeBtn.setBounds(0, 150, 250, 50);
        employeeBtn.setBorder(null);
        employeeBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        employeeBtn.setBackground(Color.decode("#292c35"));
        employeeBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkEmployeeInfoBtn(employeeBtn, labelListBtnEmployee, labelListBtnAđd);
        p2.add(employeeBtn);

        driverBtn = new JButton("Driver info");
        driverBtn.setBounds(0, 200, 250, 50);
        driverBtn.setBorder(null);
        driverBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        driverBtn.setBackground(Color.decode("#292c35"));
        driverBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkDriverInfoBtn(driverBtn, labelListBtnEmployee, labelListBtnAđd, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        p2.add(driverBtn);

        updateStatusBtn = new JButton("Update Room");
        updateStatusBtn.setBounds(0, 250, 250, 50);
        updateStatusBtn.setBorder(null);
        updateStatusBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        updateStatusBtn.setBackground(Color.decode("#292c35"));
        updateStatusBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkUpdateStatusBtn(updateStatusBtn, labelListBtnAđd, labelListBtnEmployee, p8, p4, p5, p6, p7, p3, p9, p10, p11);
        p2.add(updateStatusBtn);

        statisticsBtn = new JButton("Statistics");
        statisticsBtn.setBounds(0, 300, 250, 50);
        statisticsBtn.setBorder(null);
        statisticsBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        statisticsBtn.setBackground(Color.decode("#292c35"));
        statisticsBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().checkStatisticsBtn(statisticsBtn, labelListBtnAđd, labelListBtnEmployee, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        p2.add(statisticsBtn);

        historyBtn = new JButton("History");
        historyBtn.setBounds(0, 350, 250, 50);
        historyBtn.setBorder(null);
        historyBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        historyBtn.setBackground(Color.decode("#292c35"));
        historyBtn.setForeground(Color.decode("#f0f5f5"));
        new ManagerDashboardController().historyBtn(historyBtn, labelListBtnAđd, labelListBtnEmployee, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        p2.add(historyBtn);


        ImageIcon chatBut = new ImageIcon(ClassLoader.getSystemResource("icons/chat_ic.png"));
        Image chat1 = chatBut.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        chatBtn = new JButton(new ImageIcon(chat1));
        chatBtn.setBounds(100, 600, 50, 50);
        chatBtn.setBorder(null);
        chatBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        chatBtn.setBackground(Color.decode("#292c35"));
        chatBtn.setForeground(Color.decode("#f0f5f5"));
//        chatBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Server()
//                new Client();
//            }
//        });
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
        new ManagerDashboard();
    }
}
