package com.hotelManagementSystem.views;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.controller.NewCustomerController;
import com.hotelManagementSystem.controller.UpdateCheckController;
import com.hotelManagementSystem.entity.Customer;

import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame {

    private static JPanel p1;
    private JTextField txt_ID;
    private JTextField txt_Room;
    private JTextField txt_Status;
    private JTextField txt_Deposit;
    private JTextField txt_Payment;
    private JComboBox comboBox_1;
    private Customer customer;
    private JTextArea txt_Time, txt_TimeOut;

    private int valuePayment;

    public int getValuePayment() {
        return valuePayment;
    }

    public void setValuePayment(int valuePayment) {
        this.valuePayment = valuePayment;
    }


    public JPanel getP1() {
        return p1;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCheck frame = new UpdateCheck();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UpdateCheck() {
        initComponent();
    }

    private void initComponent() {
        //conn = Javaconnect.getDBConnection();
        p1 = new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
        p1.setSize(1000, 550);
        setContentPane(p1);
        p1.setLayout(null);
        customer = new Customer();

        JTextArea lblUpdateCheckStatus = new JTextArea("CHECK-IN DETAILS");
        lblUpdateCheckStatus.setFont(new Font("Arial", Font.BOLD, 35));
        lblUpdateCheckStatus.setForeground(Color.BLACK);
        lblUpdateCheckStatus.setBounds(90, 15, 600, 50);
        p1.add(lblUpdateCheckStatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(550, 120, 476, 270);
        add(l1);

        JLabel lblNewLabel = new JLabel("ID:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel.setBounds(25, 88, 70, 16);
        p1.add(lblNewLabel);

        comboBox_1 = new JComboBox();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                comboBox_1.addItem(rs.getString("numberID"));
            }
            comboBox_1.setBounds(248, 88, 150, 20);
            String selectedItem = (String) comboBox_1.getSelectedItem();
            if (selectedItem != null && !selectedItem.isEmpty()) {
            comboBox_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customer.setNumberID((String) comboBox_1.getSelectedItem());
                }
            });
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            p1.add(comboBox_1);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(420, 88, 80, 20);
        new UpdateCheckController().refreshBtn(btnRefresh, comboBox_1);
        p1.add(btnRefresh);

            JLabel lblNewLabel_1 = new JLabel("Room No :");
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_1.setBounds(25, 135, 97, 16);
            p1.add(lblNewLabel_1);

            txt_ID = new JTextField();
            txt_ID.setBounds(248, 135, 140, 20);
            txt_ID.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(txt_ID.getText().length() > 0) {
                        customer.setRoomNumber(Integer.parseInt(txt_ID.getText()));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(txt_ID.getText().length() > 0) {
                        customer.setRoomNumber(Integer.parseInt(txt_ID.getText()));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(txt_ID.getText().length() > 0) {
                        customer.setRoomNumber(Integer.parseInt(txt_ID.getText()));
                    }
                }
            });
            p1.add(txt_ID);
            txt_ID.setColumns(14);

            JLabel lblNewLabel_2 = new JLabel("Name : ");
            lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_2.setBounds(25, 185, 97, 16);
            p1.add(lblNewLabel_2);

            JLabel lblNewLabel_3 = new JLabel("Checked-in :");
            lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_3.setBounds(25, 235, 107, 16);
            p1.add(lblNewLabel_3);

            JLabel lblNewLabel_6 = new JLabel("Checked-out :");
            lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_6.setBounds(25, 285, 120, 16);
            p1.add(lblNewLabel_6);


        JLabel lblNewLabel_4 = new JLabel("Amount Paid(Rs) : ");
            lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_4.setBounds(25, 335, 170, 16);
            p1.add(lblNewLabel_4);

            JLabel lblNewLabel_5 = new JLabel("Pending Amount(Rs) : ");
            lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
            lblNewLabel_5.setBounds(25, 385, 200, 16);
            p1.add(lblNewLabel_5);


            txt_Status = new JTextField();
            txt_Status.setBounds(248, 185, 140, 20);
            txt_Status.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(txt_Status.getText().length() > 0) {
                        customer.setName(txt_Status.getText());
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(txt_Status.getText().length() > 0) {
                        customer.setName(txt_Status.getText());
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(txt_Status.getText().length() > 0) {
                        customer.setName(txt_Status.getText());
                    }
                }
            });
            p1.add(txt_Status);
            txt_Status.setColumns(14);

            txt_Time = new JTextArea();
            txt_Time.setBounds(248, 235, 140, 20);
            txt_Time.setEditable(false);
            txt_Time.setText("0/0/0 00:00:00");
            p1.add(txt_Time);

            txt_TimeOut = new JTextArea();
            txt_TimeOut.setBounds(248, 285, 140, 20);
            txt_TimeOut.setEditable(false);
            txt_TimeOut.setText("0/0/0 00:00:00");
            p1.add(txt_TimeOut);

            txt_Deposit = new JTextField();
            txt_Deposit.setBounds(248, 335, 140, 20);
            txt_Deposit.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(txt_Deposit.getText().length() > 0) {
                        customer.setDeposit(Integer.parseInt(txt_Deposit.getText()));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(txt_Deposit.getText().length() > 0) {
                        customer.setDeposit(Integer.parseInt(txt_Deposit.getText()));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(txt_Deposit.getText().length() > 0) {
                        customer.setDeposit(Integer.parseInt(txt_Deposit.getText()));
                    }
                }
            });

            p1.add(txt_Deposit);

            txt_Payment = new JTextField();
            txt_Payment.setBounds(248, 385, 140, 20);
            txt_Payment.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(txt_Payment.getText().length() > 0) {
                        setValuePayment(Integer.parseInt(txt_Payment.getText()));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(txt_Payment.getText().length() > 0) {
                        setValuePayment(Integer.parseInt(txt_Payment.getText()));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(txt_Payment.getText().length() > 0) {
                        setValuePayment(Integer.parseInt(txt_Payment.getText()));
                    }
                }
            });

            p1.add(txt_Payment);

            JButton btnAdd = new JButton("CHECK");
            btnAdd.setFont(new Font("Arial", Font.BOLD, 13));
            btnAdd.setBounds(90, 450, 100, 40);
            btnAdd.setBackground(Color.BLACK);
            btnAdd.setForeground(Color.WHITE);
            new UpdateCheckController().btnCheckOut(btnAdd, customer,txt_ID, txt_Status, txt_Time, txt_TimeOut, txt_Deposit, txt_Payment);
            p1.add(btnAdd);

            JButton btnUpdate = new JButton("UPDATE");
            btnUpdate.setFont(new Font("Arial", Font.BOLD, 13));
            btnUpdate.setBounds(230, 450, 100, 40);
            btnUpdate.setBackground(Color.BLACK);
            btnUpdate.setForeground(Color.WHITE);
            new UpdateCheckController().btnUpdate(btnUpdate, customer);
            p1.add(btnUpdate);


            getContentPane().setBackground(Color.WHITE);
        }

    }


