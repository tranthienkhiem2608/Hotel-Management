package com.hotelManagementSystem.views;

import javax.swing.*;
import java.awt.*;

public class NewCustomer extends JFrame{

    public static void main(String[] args) {

        new NewCustomer().setVisible(true);

    }

    private JPanel p1, p2;

    private JTextArea t1;

    JComboBox comboid;

    JTextField tfnumber;


    public NewCustomer() {
        initComponent();
//        setLocationRelativeTo(null);
    }
    public void initComponent(){
        setSize(1400, 800);
        setLayout(null);


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

        t1 = new JTextArea("New Customer Form");
        t1.setBounds(10, 0, 300, 40);
        t1.setFont(new Font("serif", Font.BOLD, 30));
        t1.setForeground(Color.decode("#e09145"));
        t1.setBackground(Color.decode("#1b1c22"));
        p1.add(t1);

        JLabel lbid = new JLabel("ID");
        lbid.setBounds(10, 150, 100, 30);
        lbid.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbid);

        String options[] = {"Aadhar Card", "Passport", "Driving License", "Voter ID"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 150, 150, 30);
        comboid.getBackground();
        add(comboid);

        JLabel lbnumer = new JLabel("Number");
        lbnumer.setBounds(10, 200, 100, 30);
        lbnumer.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbnumer);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 200, 150, 30);
        add(tfnumber);





    }
}



