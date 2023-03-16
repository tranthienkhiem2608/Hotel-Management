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
public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }

    public AddDrivers() {
        initComponent();
        setLocationRelativeTo(null);

    }
    private void initComponent() {
        setBounds(450, 200, 900, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/drivers.jpg"));
        Image i3 = i1.getImage().getScaledInstance(480, 480,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(380,30,500,450);
        add(l15);

        JLabel l10 = new JLabel("ADD DRIVER");
        l10.setFont(new Font("Arial", Font.BOLD, 35));
        l10.setBounds(525, 30, 442, 35);
        contentPane.add(l10);



        JLabel l1 = new JLabel("Name");
        l1.setForeground(Color.decode("#17181D"));
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setBounds(60, 80, 150, 27);
        contentPane.add(l1);


        t1 = new JTextField();
        t1.setBounds(174, 80, 150, 27);
        contentPane.add(t1);


        JLabel l2 = new JLabel("Age");
        l2.setForeground(Color.decode("#17181D"));
        l2.setFont(new Font("Arial", Font.BOLD, 17));
        l2.setBounds(60, 130, 150, 27);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(174, 130, 150, 27);
        contentPane.add(t2);


        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Arial", Font.BOLD, 17));
        Gender.setBounds(60, 180, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(170, 180, 70, 27);
        add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(240, 180, 70, 27);
        add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        bg.add(Female);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(Color.decode("#17181D"));
        l4.setFont(new Font("Arial", Font.BOLD, 17));
        l4.setBounds(60, 230, 150, 27);
        contentPane.add(l4);

        t3 = new JTextField();
        t3.setBounds(174, 230, 150, 27);
        contentPane.add(t3);

        JLabel l5 = new JLabel("Car Brand");
        l5.setForeground(Color.decode("#17181D"));
        l5.setFont(new Font("Arial", Font.BOLD, 17));
        l5.setBounds(60, 280, 150, 27);
        contentPane.add(l5);


        t4 = new JTextField();
        t4.setBounds(174, 280, 150, 27);
        contentPane.add(t4);


        JLabel l6 = new JLabel("Available");
        l6.setForeground(Color.decode("#17181D"));
        l6.setFont(new Font("Arial", Font.BOLD, 17));
        l6.setBounds(60, 330, 150, 27);
        contentPane.add(l6);


        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
        comboBox_1.setBounds(176, 330, 150, 27);
        contentPane.add(comboBox_1);


        JLabel l7 = new JLabel("Location");
        l7.setForeground(Color.decode("#17181D"));
        l7.setFont(new Font("Arial", Font.BOLD, 17));
        l7.setBounds(60, 380, 150, 27);
        contentPane.add(l7);


        t5 = new JTextField();
        t5.setBounds(174, 380, 150, 27);
        contentPane.add(t5);



        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setBounds(80, 430, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("BACK");
        b2.addActionListener(this);
        b2.setBounds(215, 430, 111, 33);
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
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String)comboBox.getSelectedItem();
                    String company  = t3.getText();
                    String brand = t4.getText();
                    String available = (String)comboBox_1.getSelectedItem();
                    String location = t5.getText();
                    String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
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
