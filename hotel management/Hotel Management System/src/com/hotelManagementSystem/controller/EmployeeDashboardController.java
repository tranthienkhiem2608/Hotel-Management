package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.views.EmployeeDashboard;
import javax.swing.*;
public class EmployeeDashboardController {
    public EmployeeDashboardController(){}
    public void checkInOutBtn(JButton btn, JLabel p){
        btn.addActionListener(e -> {
            p.setVisible(true);
        });

    }

    public void checkSelectBtnList(JList<String> list, JLabel p){
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Check in")){
                displayPanel("Check In");
                p.setVisible(false);
            }else if(list.getSelectedValue().equals("Check Out")){
                displayPanel("Check Out");
                p.setVisible(false);
            }
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
