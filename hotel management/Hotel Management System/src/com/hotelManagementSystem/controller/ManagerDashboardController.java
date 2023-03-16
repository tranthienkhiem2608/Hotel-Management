package com.hotelManagementSystem.controller;
import com.hotelManagementSystem.views.ManagerDashboard;

import javax.swing.*;

public class ManagerDashboardController {

    public ManagerDashboardController(){

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

    public void checkSelectBtnListAdd(JList<String> list, JLabel p){
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Room")){
                displayPanel("Room");
                p.setVisible(false);
            }else if(list.getSelectedValue().equals("Employee")){
                displayPanel("Employee");
                p.setVisible(false);
            }else if(list.getSelectedValue().equals("Driver")){
                displayPanel("Driver");
                p.setVisible(false);
            }
        });
    }
    public void checkSelectBtnListEmployee(JList<String> list, JLabel p){
        list.addListSelectionListener(e -> {
            if(list.getSelectedValue().equals("Employee")){
                displayPanel("Employee Info");
                p.setVisible(false);
            }else if(list.getSelectedValue().equals("Driver")){
                displayPanel("Driver Info");
                p.setVisible(false);
            }
        });
    }
    public void displayPanel(String typePanel){
        if(typePanel.equals("Room")){
            //print notification
            System.out.println("Room");
    }
        else if(typePanel.equals("Employee")){
            //print notification
            System.out.println("Employee");
        }
        else if(typePanel.equals("Driver")){
            //print notification
            System.out.println("Driver");

        }
        else if(typePanel.equals("Employee Info")){
            //print notification
            System.out.println("Employee Info");
        }
        else if(typePanel.equals("Driver Info")){
            //print notification
            System.out.println("Driver Info");
        }

}}
