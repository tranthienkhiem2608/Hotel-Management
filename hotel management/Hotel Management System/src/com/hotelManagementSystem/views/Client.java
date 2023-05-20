/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelManagementSystem.views;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Client extends JFrame {
    private JButton jButton1;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextField jTextField1;
    private static JPanel p1;
    private Thread thread;
    private BufferedWriter os;
    private BufferedReader is;
    private Socket socketOfClient;
    private List<String> onlineList;
    private int id;

    private static String clientName;
    public void setClientName(String clientName) {
        Client.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public int getId() {
        return id;
    }
    public JPanel getP1() {
        return p1;
    }



    public Client(String clientName) {
        initComponents();
        setLocationRelativeTo(null);
        setClientName(clientName);
        onlineList = new ArrayList<>();
        setUpSocket(clientName);
        id = -1;

    }

    private void initComponents() {
        setSize(480, 500);
        setLayout(null);
        setBackground(Color.decode("#17181D"));
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 480, 500);
        p1.setBackground(Color.decode("#17181D"));
        add(p1);
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel3.setLayout(new BorderLayout());
        jTextArea1.setEditable(false);
        jTextArea2.setEditable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBackground(new java.awt.Color(252, 217, 184));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jScrollPane2, BorderLayout.CENTER);
        p1.add(jPanel1);

        jTabbedPane1.addTab("Online List", jPanel1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        ImageIcon chatBut = new ImageIcon(ClassLoader.getSystemResource("icons/sendIcon.png"));
        Image chat1 = chatBut.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        jButton1.setIcon(new ImageIcon(chat1));
        jButton1.setBackground(new java.awt.Color(50, 50, 51));
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(Color.BLACK);
        jLabel1.setText("Choose a recipient");

        jLabel1.setForeground(Color.BLACK);
        jLabel2.setText("Enter a message");

        jLabel3.setBackground(new java.awt.Color(118, 93, 89));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(Color.BLACK);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("{Receiver}");

        jPanel2.setLayout(null);

        jLabel1.setBounds(22, 15, 120, 16);
        jPanel2.add(jLabel1);
        p1.add(jPanel2);

        jComboBox1.setBounds(135, 12, 246, 22);
        jPanel2.add(jComboBox1);

        jLabel3.setBounds(22, 52, 414, 23);
        jPanel2.add(jLabel3);

        jScrollPane1.setBounds(22, 83, 414, 250);
        jPanel2.add(jScrollPane1);

        jLabel2.setBounds(22, 248, 96, 16);
        jPanel2.add(jLabel2);

        jTextField1.setBounds(22, 360, 347, 30);
        jPanel2.add(jTextField1);

        jButton1.setBounds(375, 360, 61, 30);
        jPanel2.add(jButton1);
        p1.add(jPanel2);

        jTabbedPane1.addTab("Chat", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 476, 514);
        p1.add(jTabbedPane1);


        setVisible(true);
    }


    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jComboBox1.getSelectedIndex()==0){
            jLabel3.setText("Global");
        }
        else{
            jLabel3.setText("Messaging with "+jComboBox1.getSelectedItem());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String messageContent = jTextField1.getText();
        if(messageContent.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "You have not entered a message");
            return;
        }
        if(jComboBox1.getSelectedIndex()==0){
            try {
                write("send-to-global"+","+messageContent+","+this.id+","+ clientName);
                jTextArea1.setText(jTextArea1.getText()+"You: "+messageContent+"\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
        }else{
            try {
                String[] parner = ((String) Objects.requireNonNull(jComboBox1.getSelectedItem())).split("-");
                write("send-to-person"+","+messageContent+","+this.id+","+ clientName+","+parner[1]);
                jTextArea1.setText(jTextArea1.getText()+"You (to "+parner[1]+"): "+messageContent+"\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
        }
        jTextField1.setText("");
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public void setUpSocket(String clientName) {
        try {
            thread = new Thread(() -> {

                try {
                    // Gửi yêu cầu kết nối tới Server đang lắng nghe
                    // trên máy 'localhost' cổng 7777.
                    socketOfClient = new Socket("localhost", 7777);
                    System.out.println("Successful connection!");
                    // Tạo luồng đầu ra tại client (Gửi dữ liệu tới server)
                    os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
                    // Luồng đầu vào tại Client (Nhận dữ liệu từ server).
                    is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
                    String connectMessage = "connect" + "," + clientName;
                    os.write(connectMessage);
                    os.newLine();
                    os.flush();
                    String message;
                    while (true) {

                        message = is.readLine();
                        if(message==null){
                            break;
                        }
                        String[] messageSplit = message.split(",");
                        if(messageSplit[0].equals("get-id")){
                            setID(Integer.parseInt(messageSplit[1]));
                            setClientName(messageSplit[2]);
                            setIDTitle();
                        }
                        if (messageSplit[0].equals("update-online-list")) {
                            onlineList = new ArrayList<>();
                            StringBuilder online = new StringBuilder();
                            String[] onlineSplit = messageSplit[1].split("-");
                            for (String s : onlineSplit) {
                                onlineList.add(s);
                                online.append(s).append(" online\n");
                            }
                            jTextArea2.setText(online.toString());
                            updateCombobox();
                        }
                        if(messageSplit[0].equals("global-message")){
                            jTextArea1.setText(jTextArea1.getText()+messageSplit[1]+"\n");
                            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
                        }
                    }
//                    os.close();
//                    is.close();
//                    socketOfClient.close();
                } catch (IOException e) {
                    return;
                }
            });
            thread.start();
        } catch (Exception ignored) {
        }
    }
    private void updateCombobox(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Send all");
        String idString = ""+this.getClientName();
        for(String e : onlineList){
            if(!e.equals(idString)){
                jComboBox1.addItem("-"+ e);
            }
        }

    }
    private void setIDTitle(){
        this.setTitle(clientName);
    }
    private void setID(int id){
        this.id = id;
    }
    private void write(String message) throws IOException{
//        String clientName = "";
//        if (jComboBox1.getSelectedIndex() > 0) {
//            String[] parner = ((String)jComboBox1.getSelectedItem()).split(" ");
//            clientName = parner[1];
//        }
        os.write(message + "," + clientName);
        os.newLine();
        os.flush();
    }

    public static void main(String[] args) {
        new Client("Tom(re05)");
    }


}