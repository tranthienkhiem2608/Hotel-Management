package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hotelManagementSystem.controller.LoginController;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.controller.SignUpController;
public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        initComponent();
        setLocationRelativeTo(null);

    }

    private void initComponent() {
        setBounds(450, 200, 900, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/rooms.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(350,80,550,400);
        add(l15);

        JLabel l10 = new JLabel("ADD ROOM");
        l10.setFont(new Font("Arial", Font.BOLD, 35));
        l10.setBounds(525, 24, 442, 35);
        contentPane.add(l10);



        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(Color.decode("#17181D"));
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setBounds(60, 80, 150, 27);
        contentPane.add(l1);


        t4 = new JTextField();
        t4.setBounds(200, 80, 150, 27);
        contentPane.add(t4);


        JLabel l2 = new JLabel("Availability");
        l2.setForeground(Color.decode("#17181D"));
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setBounds(60, 130, 150, 27);
        contentPane.add(l2);

        comboBox = new JComboBox(new String[] { "Available", "Occupied" });
        comboBox.setBounds(200, 130, 150, 27);
        contentPane.add(comboBox);


        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(Color.decode("#17181D"));
        l3.setFont(new Font("Arial", Font.BOLD, 17));
        l3.setBounds(60, 180, 150, 27);
        contentPane.add(l3);

        comboBox_2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
        comboBox_2.setBounds(200, 180, 150, 27);
        contentPane.add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(Color.decode("#17181D"));
        l4.setFont(new Font("Arial", Font.BOLD, 17));
        l4.setBounds(64, 230, 150, 27);
        contentPane.add(l4);

        t2 = new JTextField();
        t2.setBounds(200, 230, 150, 27);
        contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(Color.decode("#17181D"));
        l5.setFont(new Font("Arial", Font.BOLD, 17));
        l5.setBounds(64, 280, 150, 27);
        contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
        comboBox_3.setBounds(200, 280, 150, 27);
        contentPane.add(comboBox_3);





        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setBounds(90, 350, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("BACK");
        b2.addActionListener(this);
        b2.setBounds(230, 350, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    Conn c = new Conn();
                    String room = t4.getText();
                    String available = (String)comboBox.getSelectedItem();
                    String status = (String)comboBox_2.getSelectedItem();
                    String price  = t2.getText();
                    String type = (String)comboBox_3.getSelectedItem();
                    String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){

        }
    }
}
