package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.views.CustomerInfo;
import com.hotelManagementSystem.views.EmployeeDashboard;
import com.hotelManagementSystem.views.NewCustomer;
import com.hotelManagementSystem.views.UpdateCheck;

import javax.swing.*;
import java.awt.*;

public class EmployeeDashboardController {

    private NewCustomer newCustomer;
    private CustomerInfo customerInfo;
    private UpdateCheck updateCheck;
    private CardLayout cardLayout;
    public EmployeeDashboardController(){
        newCustomer = new NewCustomer();
        customerInfo = new CustomerInfo();
        updateCheck = new UpdateCheck();
    }

    public void addCardLayout(JPanel p){
        newCustomer.setVisible(false);
        customerInfo.setVisible(false);
        updateCheck.setVisible(false);
        cardLayout = new CardLayout();
        p.setLayout(cardLayout);
        p.add(newCustomer.getP1(), "newCustomer");
        p.add(customerInfo.getP1(), "customerInfo");
        p.add(updateCheck.getP1(), "updateCheck");
    }
    public void newCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "newCustomer");
        });
    }

    public void customerInfoBtn(JButton btn, JPanel p, JPanel p2, JPanel p3){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
            p.setVisible(true);
            cardLayout.show(p, "customerInfo");
        });
    }

    public void updateCustomerBtn(JButton btn, JPanel p, JPanel p2, JPanel p3){
        addCardLayout(p);
        btn.addActionListener(e -> {
            p2.setVisible(false);
            p3.setVisible(false);
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

}
