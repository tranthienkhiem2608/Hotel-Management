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
    public EmployeeDashboardController(){
        newCustomer = new NewCustomer();
        customerInfo = new CustomerInfo();
        updateCheck = new UpdateCheck();
        searchRoom = new SearchRoom();
    }

    public void addCardLayout(JPanel p){
        newCustomer.setVisible(false);
        customerInfo.setVisible(false);
        updateCheck.setVisible(false);
        searchRoom.setVisible(false);
        cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        p.add(newCustomer.getP1(), "newCustomer");
        p.add(customerInfo.getP1(), "customerInfo");
        p.add(updateCheck.getP1(), "updateCheck");
        p.add(searchRoom.getP1(), "searchRoom");
    }
    public void newCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "newCustomer");
        });
    }

    public void customerInfoBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "customerInfo");
        });
    }

    public void updateCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3, JPanel p4){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "updateCheck");
        });
    }

    public void checkInOutBtn(JButton btn, JLabel p){
        btn.addActionListener(e -> {
//            p.setVisible(true);
        });

    }

    public void checkSelectBtnList(JList<String> list, JLabel p){
        list.addListSelectionListener(e -> {
//            if(list.getSelectedValue().equals("Check in")){
//                displayPanel("Check In");
//                p.setVisible(false);
//            }else if(list.getSelectedValue().equals("Check Out")){
//                displayPanel("Check Out");
//                p.setVisible(false);
//            }
        });
    }

    public void displayPanel(String typePanel){
        if(typePanel.equals("Check In")){
            //print notification
            System.out.println("Check In");
        }
        else if(typePanel.equals("Check Out")){
            //print notification
            System.out.println("Check Out");
        }
    }

    public void checkSearchRoomBtn(JButton btn, JPanel p, JPanel p1, JPanel p2, JPanel p3){
        btn.addActionListener(e -> {
            addCardLayout(p);
            p3.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "searchRoom");
        });
    }
}
