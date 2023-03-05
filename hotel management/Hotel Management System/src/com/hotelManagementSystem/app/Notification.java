package com.hotelManagementSystem.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Notification extends JFrame {
    private JTextArea t1;
    private JButton b1;
    private JLabel l1;


    public Notification(String mess) {
        setSize(350, 180);
        setLocation(800,350);
        setLayout(null);

        b1 = new JButton("OK");
        b1.setBorder(null);
        b1.setBounds(145, 100, 30, 21);
        b1.setBackground(Color.decode("#17181d"));
        b1.setForeground(Color.decode("#FCD9B8"));

        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mess == "Invalid username or password") {
                    setVisible(false);
                } else if (mess == "Password changed successfully") {
                    setVisible(false);
                } else if (mess == "Password not matched") {
                    setVisible(false);
                } else if (mess == "Account Created Successfully") {
                    new Login().setVisible(true);
                    setVisible(false);
                } else if (mess == "Wrong phone or answer") {
                    setVisible(false);
                }
            }
        });
        add(b1);

        JPanel panelForm = new JPanel();
        panelForm.setBounds(-10, 0, 350, 250);
        panelForm.setBackground(Color.decode("#17181D"));
        add(panelForm);

        l1 = new JLabel("tw");
        l1.setBounds(-10, 0, 300, 40);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        l1.setBackground(Color.decode("#17181D"));
        l1.setForeground(Color.decode("#FCD9B8"));
        l1.setText(mess);
        panelForm.add(l1);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Notification("Notification");
    }
}
