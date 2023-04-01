package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.views.*;

import javax.swing.*;
import java.awt.*;

public class EmployeeDashboardController {

    private NewCustomer newCustomer;
    private CustomerInfo customerInfo;
    private UpdateCheck updateCheck;
    private CardLayout cardLayout;
    private SearchRoom searchRoom;
    private ProfileUser profileUser;
    private CheckOut checkOut;
    private HistoryCustomer historyCustomer;
    private DriverInfo driverInfo;
    public EmployeeDashboardController(){
        newCustomer = new NewCustomer();
        customerInfo = new CustomerInfo();
        updateCheck = new UpdateCheck();
        searchRoom = new SearchRoom();
        profileUser = new ProfileUser();
        checkOut = new CheckOut();
        historyCustomer = new HistoryCustomer();
        driverInfo = new DriverInfo();
    }

    public void addCardLayout(JPanel p){
        newCustomer.setVisible(false);
        customerInfo.setVisible(false);
        updateCheck.setVisible(false);
        searchRoom.setVisible(false);
        profileUser.setVisible(false);
        checkOut.setVisible(false);
        historyCustomer.setVisible(false);
        driverInfo.setVisible(false);
        cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        p.add(newCustomer.getP1(), "newCustomer");
        p.add(customerInfo.getP1(), "customerInfo");
        p.add(updateCheck.getP1(), "updateCheck");
        p.add(searchRoom.getP1(), "searchRoom");
        p.add(profileUser.getP1(), "profileUser");
        p.add(checkOut.getP1(), "checkOut");
        p.add(historyCustomer.getP1(), "historyCustomer");
        p.add(driverInfo.getP1(), "driverInfo");
    }
    public void newCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "newCustomer");
        });
    }

    public void customerInfoBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "customerInfo");
        });
    }

    public void updateCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "updateCheck");
        });
    }

    public void checkInOutBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "checkOut");
        });

    }


    public void checkSearchRoomBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        btn.addActionListener(e -> {
            addCardLayout(p);
            p3.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "searchRoom");
        });
    }

    public void profileBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        btn.addActionListener(e -> {
            addCardLayout(p);
            p3.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "profileUser");
        });
    }

    public void historyBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        btn.addActionListener(e -> {
            addCardLayout(p);
            p3.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "historyCustomer");
        });
    }

    public void driverInfoBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4, JPanel p5, JPanel p6, JPanel p7, JPanel p8){
        btn.addActionListener(e -> {
            addCardLayout(p);
            p3.setVisible(false);
            p2.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p8.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "driverInfo");
        });
    }



}
