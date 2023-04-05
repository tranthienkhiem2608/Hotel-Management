package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.views.ManagerDashboard;
import com.hotelManagementSystem.views.*;
import com.hotelManagementSystem.dao.*;
import javax.swing.*;
import java.awt.*;

import java.awt.*;

public class ManagerDashboardController {

    private AddDrivers addDrivers;
    private AddUser addUser;
    private AddRoom addRoom;
    private ManagerInfo managerInfo;
    private EmployeeInfo employeeInfo;
    private Room viewRoom;
    private ProfileUser profileUser;
    private CustomerInfo customerInfo;
    private UpdateRoom updateRoom;
    private HistoryCustomer historyCustomer;
    private DriverInfo driverInfo;

    private Chart chart;

    private CardLayout cardLayout, cardLayout2, cardLayout3, cardLayout4, cardLayout5, cardLayout6;
    public ManagerDashboardController(){
        addDrivers = new AddDrivers();
        addUser = new AddUser();
        addRoom = new AddRoom();
        managerInfo = new ManagerInfo();
        employeeInfo = new EmployeeInfo();
        viewRoom = new Room();
        profileUser = new ProfileUser();
        customerInfo = new CustomerInfo();
        updateRoom = new UpdateRoom();
        historyCustomer = new HistoryCustomer();
        driverInfo = new DriverInfo();
        chart = new Chart();
    }
    public void addCardLayout(JPanel p){
        addDrivers.setVisible(false);
        addUser.setVisible(false);
        addRoom.setVisible(false);
        cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        p.add(addRoom.getP1(), "addRoom");
        p.add(addDrivers.getP1(), "addDrivers");
        p.add(addUser.getP1(), "addUser");

    }

    public void addCardLayout2(JPanel p){
        managerInfo.setVisible(false);
        employeeInfo.setVisible(false);
        cardLayout2 = new CardLayout();
        p.setLayout(cardLayout2);
        p.add(managerInfo.getP1(), "managerInfo");
        p.add(employeeInfo.getP1(), "employeeInfo");
    }
    public void addCardLayout3(JPanel p){
        viewRoom.setVisible(false);
        customerInfo.setVisible(false);
        cardLayout3 = new CardLayout();
        p.setLayout(cardLayout3);
        p.add(viewRoom.getP1(), "viewRoom");
        p.add(customerInfo.getP1(), "customerInfo");
    }

    public void addCardLayout4(JPanel p){
        profileUser.setVisible(false);
        updateRoom.setVisible(false);
        cardLayout4 = new CardLayout();
        p.setLayout(cardLayout4);
        p.add(profileUser.getP1(), "profileUser");
        p.add(updateRoom.getP1(), "updateRoom");

    }

    public void addCardLayout5(JPanel p) {
        historyCustomer.setVisible(false);
        chart.setVisible(false);
        cardLayout5 = new CardLayout();
        p.setLayout(cardLayout5);
        p.add(chart.getP1(), "chart");
        p.add(historyCustomer.getP1(), "historyCustomer");
    }

    public void addCardLayout6(JPanel p) {
        driverInfo.setVisible(false);
        cardLayout6 = new CardLayout();
        p.setLayout(cardLayout6);
        p.add(driverInfo.getP1(), "driverInfo");
    }


    public void checkAddBtn(JButton btn, JLabel p,JLabel p2){
        btn.addActionListener(e -> {
            p.setVisible(true);
            p2.setVisible(false);
        });

    }
    public void checkEmployeeInfoBtn(JButton btn, JLabel p, JLabel p2){
        btn.addActionListener(e -> {
            p.setVisible(true);
            p2.setVisible(false);
        });

    }

    public void checkSelectBtnListAdd(JList<String> list, JLabel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout(p2);
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Room")){
                p.setVisible(false);
                p3.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(false);
                p10.setVisible(false);
                cardLayout.show(p2, "addRoom");
            }else if(list.getSelectedValue().equals("User")){
                p3.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(false);
                p10.setVisible(false);
                cardLayout.show(p2, "addUser");
            }else if(list.getSelectedValue().equals("Driver")){
                p3.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(false);
                p10.setVisible(false);
                cardLayout.show(p2, "addDrivers");
            }
        });
    }
    public void checkSelectBtnListEmployee(JList<String> list, JLabel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout2(p3);
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Employee")){
                p.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(true);
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(false);
                p10.setVisible(false);
                cardLayout2.show(p3, "employeeInfo");
            }else if(list.getSelectedValue().equals("Manager")){
                p.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(true);
                p4.setVisible(false);
                p5.setVisible(false);
                p6.setVisible(false);
                p7.setVisible(false);
                p8.setVisible(false);
                p9.setVisible(false);
                p10.setVisible(false);
                cardLayout2.show(p3, "managerInfo");
            }
        });
    }

    public void checkViewBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout3(p4);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(true);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(false);
            p10.setVisible(false);
            cardLayout3.show(p4, "viewRoom");
        });
    }

    public void BtnProfileUser(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout4(p5);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p6.setVisible(false);
            p5.setVisible(true);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(false);
            p10.setVisible(false);
            cardLayout4.show(p5, "profileUser");
        });
    }


    public void checkCustomerInfoBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout3(p5);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(true);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(false);
            p10.setVisible(false);
            cardLayout3.show(p5, "customerInfo");
        });
    }

    public void checkUpdateStatusBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout4(p2);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(true);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(false);
            p10.setVisible(false);
            cardLayout4.show(p2, "updateRoom");
        });
    }

    public void historyBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout5(p8);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(true);
            p9.setVisible(false);
            p10.setVisible(false);
            cardLayout5.show(p8, "historyCustomer");
        });
    }

    public void checkDriverInfoBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout6(p9);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(true);
            p10.setVisible(false);
            cardLayout6.show(p9, "driverInfo");
        });
    }

    public void checkStatisticsBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8, JPanel p9, JPanel p10){
        addCardLayout5(p10);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p9.setVisible(false);
            p10.setVisible(true);
            cardLayout5.show(p10, "chart");
        });
    }

}
