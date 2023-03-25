package com.hotelManagementSystem.views;


import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField txt_ID;
    private JTextField txt_Ava;
    private JTextField txt_Status;
    private JTextField txt_Room;

    Choice c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateRoom frame = new UpdateRoom();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close(){
        this.dispose();
    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public UpdateRoom() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/roomview.jpg"));
        Image i3 = i1.getImage().getScaledInstance(563, 375,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,80,563,375);
        add(l1);

        JLabel lblUpdateRoomStatus = new JLabel("UPDATE ROOM STATUS");
        lblUpdateRoomStatus.setFont(new Font("Arial", Font.BOLD, 50));
        lblUpdateRoomStatus.setForeground(Color.decode("#E09145"));
        lblUpdateRoomStatus.setBounds(200, 10, 600, 50);
        contentPane.add(lblUpdateRoomStatus);

        JLabel lblNewLabel = new JLabel("Customer ID:");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setForeground(Color.decode("#f0f5f5"));
        lblNewLabel.setBounds(20, 130, 150, 27);
        contentPane.add(lblNewLabel);

        c1 = new Choice();
//        Su dung DB
//        try{
//            conn c = new conn();
//            ResultSet rs = c.s.executeQuery("select * from customer");
//            while(rs.next()){
//                c1.add(rs.getString("number"));
//            }
//        }catch(Exception e){ }
        c1.setBounds(180, 130, 140, 20);
        contentPane.add(c1);

        JLabel lblRoomId = new JLabel("Room Number:");
        lblRoomId.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRoomId.setForeground(Color.decode("#f0f5f5"));
        lblRoomId.setBounds(20, 190, 150, 27);
        contentPane.add(lblRoomId);

        txt_Room = new JTextField();
        txt_Room.setBounds(180, 190, 140, 20);
        contentPane.add(txt_Room);

        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setFont(new Font("Arial", Font.PLAIN, 20));
        lblAvailability.setForeground(Color.decode("#f0f5f5"));
        lblAvailability.setBounds(20, 250, 150, 27);
        contentPane.add(lblAvailability);

        txt_Ava = new JTextField();
        txt_Ava.setBounds(180, 250, 140, 20);
        contentPane.add(txt_Ava);

        JLabel lblCleanStatus = new JLabel("Clean Status:");
        lblCleanStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCleanStatus.setForeground(Color.decode("#f0f5f5"));
        lblCleanStatus.setBounds(20, 310, 150, 27);
        contentPane.add(lblCleanStatus);

        txt_Status = new JTextField();
        txt_Status.setBounds(180, 310, 140, 20);
        contentPane.add(txt_Status);



        JButton b1 = new JButton("Check");
        //            Su dung DB
//        b1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    String s1 = c1.getSelectedItem();
//                    conn c = new conn();
//                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);
//
//                    while(rs1.next()){
//                        txt_Room.setText(rs1.getString("room_number"));
//                    }
//                }catch(Exception ee){}
//                try{
//                    conn c  = new conn();
//                    ResultSet rs2 = c.s.executeQuery("select * from room where room_number = "+txt_Room.getText());
//                    while(rs2.next()){
//                        txt_Ava.setText(rs2.getString("availability"));
//                        txt_Status.setText(rs2.getString("clean_status"));
//                    }
//                }catch(Exception ee){}
//            }
//        });
        b1.setBounds(80, 380, 180, 50);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnUpdate = new JButton("Update");
//        Su dung DB
//        btnUpdate.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) throws NumberFormatException {
//
//                try{
//                    conn c = new conn();
//                    String str = "update room set clean_status = '"+txt_Status.getText()+"' where room_number = "+txt_Room.getText();
//                    c.s.executeUpdate(str);
//                    JOptionPane.showMessageDialog(null, "Update Sucessful");
//
//                    new Reception().setVisible(true);
//                    setVisible(false);
//                }catch (Exception ee){
//                    ee.printStackTrace();
//                }
//
//
//            }
//        });
        btnUpdate.setBounds(80, 470, 180, 50);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);

//        ImageIcon i6  = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
//        Image i4 = i6.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
//        ImageIcon i5 = new ImageIcon(i4);
//        JButton btnExit = new JButton(i5);
//        btnExit.setBackground(Color.decode("#292C35"));
//        btnExit.setBounds(900,490,50,50);
////        btnExit.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                new ManagerDashboard().setVisible(true);
////                setVisible(false);
////            }
////        });
//        contentPane.add(btnExit);

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradient = new GradientPaint(0, 0, Color.decode("#292C35"), getWidth(), getHeight(), Color.decode("#292C35"));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setBounds(0, 0, 1000, 600);
        contentPane.add(gradientPanel);
    }

}