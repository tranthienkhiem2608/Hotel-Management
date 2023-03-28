package com.hotelManagementSystem.views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.hotelManagementSystem.constants.Constants.*;

public class Notification extends JFrame {
    private JTextArea t1;
    private JButton b1, b2;
    private JLabel l1;


    public Notification(String mess) {
        initComponent(mess);
        setLocationRelativeTo(null);
    }

    private void initComponent(String mess) {
        setSize(350, 180);
        setLocation(800,350);
        setLayout(null);

        b2 = new JButton("Ok");
        b2.setBorder(null);
        b2.setBounds(145, 100, 27, 21);
        b2.setBackground(Color.decode("#17181d"));
        b2.setForeground(Color.decode("#FCD9B8"));
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(b2);

        b1 = new JButton("OK");
        b1.setBorder(null);
        b1.setBounds(145, 100, 30, 21);
        b1.setBackground(Color.decode("#17181d"));
        b1.setForeground(Color.decode("#FCD9B8"));

        b1.setFont(new Font("Arial", Font.BOLD, 10));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mess == MESSINVALID) {
                } else if (mess == MESSCHANGEPASS) {
                    new Login().setVisible(true);
                } else if (mess == "Password not matched") {
                } else if (mess == "Account Created Successfully") {
                    new Login().setVisible(true);
                } else if (mess == "Wrong phone or answer") {
                } else if (mess == "Account Created Failed") {
                }else if (mess == "Password Changed Successfully") {
                    new Login().setVisible(true);
                } else if (mess == "Password Changed Failed") {
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
