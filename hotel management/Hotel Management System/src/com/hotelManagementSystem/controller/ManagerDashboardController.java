package com.hotelManagementSystem.controller;
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

    private CardLayout cardLayout, cardLayout2, cardLayout3;
    public ManagerDashboardController(){
        addDrivers = new AddDrivers();
        addUser = new AddUser();
        addRoom = new AddRoom();
        managerInfo = new ManagerInfo();
        employeeInfo = new EmployeeInfo();
        viewRoom = new Room();
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
        cardLayout3 = new CardLayout();
        p.setLayout(cardLayout3);
        p.add(viewRoom.getP1(), "viewRoom");
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

    public void checkSelectBtnListAdd(JList<String> list, JLabel p, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout(p2);
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Room")){
                p.setVisible(false);
                p3.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                cardLayout.show(p2, "addRoom");
            }else if(list.getSelectedValue().equals("User")){
                p3.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                cardLayout.show(p2, "addUser");
            }else if(list.getSelectedValue().equals("Driver")){
                p3.setVisible(false);
                p.setVisible(false);
                p2.setVisible(true);
                p4.setVisible(false);
                cardLayout.show(p2, "addDrivers");
            }
        });
    }
    public void checkSelectBtnListEmployee(JList<String> list, JLabel p, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout2(p3);
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Employee")){
                p.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(true);
                p4.setVisible(false);
                cardLayout2.show(p3, "employeeInfo");
            }else if(list.getSelectedValue().equals("Manager")){
                p.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(true);
                p4.setVisible(false);
                cardLayout2.show(p3, "managerInfo");
            }
        });
    }

    public void checkViewBtn(JButton btn,JLabel l1, JLabel l2, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout3(p4);
        btn.addActionListener(e -> {
            l1.setVisible(false);
            l2.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(true);
            cardLayout3.show(p4, "viewRoom");
        });
    }
}
