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

public class AddUser extends JFrame{ //Third Frame


    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JComboBox c1;

    public AddUser() {
        initComponent();
        setLocationRelativeTo(null);

    }
    private void initComponent(){
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD USER DETAILS");


        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel email = new JLabel("ID");
        email.setFont(new Font("Arial", Font.BOLD, 17));
        email.setBounds(60, 30, 150, 27);
        add(email);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JLabel Passportno = new JLabel("Name");
        Passportno.setFont(new Font("Arial", Font.BOLD, 17));
        Passportno.setBounds(60, 80, 150, 27);
        add(Passportno);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        JButton Next = new JButton("SAVE");
        Next.setBounds(200, 490, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        JLabel Pnrno = new JLabel("Age");
        Pnrno.setFont(new Font("Arial", Font.BOLD, 17));
        Pnrno.setBounds(60, 130, 150, 27);
        add(Pnrno);

        textField_2 = new JTextField();
        textField_2.setBounds(200, 130, 150, 27);
        add(textField_2);

        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Arial", Font.BOLD, 17));
        Gender.setBounds(60, 180, 150, 27);
        add(Gender);

        JRadioButton NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(200, 180, 70, 27);
        add(NewRadioButton);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 180, 70, 27);
        add(Female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        bg.add(Female);
///////////////
        JLabel Type = new JLabel("Type");
        Type.setFont(new Font("Arial", Font.BOLD, 17));
        Type.setBounds(60, 230, 150, 27);
        add(Type);
        JRadioButton ManagerBtn = new JRadioButton("MANAGER");
        ManagerBtn.setBackground(Color.WHITE);
        ManagerBtn.setBounds(200, 230, 83, 27);
        add(ManagerBtn);

        JRadioButton EmployeeBtn = new JRadioButton("EMPLOYEE");
        EmployeeBtn.setBackground(Color.WHITE);
        EmployeeBtn.setBounds(280, 230, 95, 27);
        add(EmployeeBtn);

        ButtonGroup bg_1 = new ButtonGroup();
        bg_1.add(ManagerBtn);
        bg_1.add(EmployeeBtn);
/////////////////
        JLabel Address = new JLabel("Job");
        Address.setFont(new Font("Arial", Font.BOLD, 17));
        Address.setBounds(60, 280, 150, 27);
        add(Address);

        String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,280,150,30);
        add(c1);

        JLabel Nationality = new JLabel("Salary");
        Nationality.setFont(new Font("Arial", Font.BOLD, 17));
        Nationality.setBounds(60, 330, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 330, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("Phone");
        Name.setFont(new Font("Arial", Font.BOLD, 17));
        Name.setBounds(60, 380, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 380, 150, 27);
        add(textField_4);

        JLabel Phno = new JLabel("Email");
        Phno.setFont(new Font("Arial", Font.BOLD, 17));
        Phno.setBounds(60, 430, 150, 27);
        add(Phno);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 430, 150, 27);
        add(textField_5);


        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD USER DETAILS");
        AddPassengers.setForeground(Color.decode("#17181D"));
        AddPassengers.setFont(new Font("Arial", Font.BOLD, 35));
        AddPassengers.setBounds(470, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        add(image);


        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name = textField.getText();
                String age = textField_1.getText();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String aadhar = textField_5.getText();
                String email = textField_6.getText();

                String gender = null;

                if(NewRadioButton.isSelected()){
                    gender = "male";

                }else if(Female.isSelected()){
                    gender = "female";
                }


                String s6 = (String)c1.getSelectedItem();

                try {
                    Conn c = new Conn();
                    String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900,600);
        setVisible(true);
        setLocation(530,200);

    }

    public static void main(String[] args){
        new AddUser();
    }
}
