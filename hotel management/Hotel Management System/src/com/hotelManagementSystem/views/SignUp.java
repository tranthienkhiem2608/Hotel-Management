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
public class SignUp extends JFrame {

    private JLabel userLabel, passLabel, emailLabel, phoneLabel, idLabel, typeLabel, answerLabel, l1, l2;
    private JTextField userField, emailField, phoneField, idField, answerField;
    private JPasswordField passField;
    private JButton signUpBtn;
    private ImageIcon backBut, i1, ib1 ;
    private Image imgButton1, img1;
    private JButton backBtn;
    private JTextArea t1;
    private JRadioButton radioBtnManager, radioBtnReceptionist;
    private String type;
    private static ButtonGroup bg;
    private static User userSignUp;

    public SignUp(){
        innitComponents();
        setLocationRelativeTo(null);

    }

    private void innitComponents(){
        setSize(1400, 800);
        setLayout(null);
        userSignUp = new User();

        backBut = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        imgButton1 = backBut.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        backBtn = new JButton(new ImageIcon(imgButton1));
        backBtn.setBounds(10, 10, 30, 30);
        backBtn.setBorder(null);
        backBtn.setBackground(Color.decode("#292C35"));
        new LoginController().changeToLogin(backBtn,this);
        add(backBtn);

        idLabel = new JLabel("ID");
        idLabel.setBounds(100, 150, 100, 30);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(200, 150, 220, 30);
        idField.setBackground(Color.decode("#e6f2f2"));
        idField.setFont(new Font("Arial", Font.PLAIN, 15));
        idField.setForeground(Color.decode("#1a1a1a"));
        idField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setId(idField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                userSignUp.setId(idField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setId(idField.getText());
            }
        });
        add(idField);


        userLabel = new JLabel("Username");
        userLabel.setBounds(100, 200, 100, 30);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(200, 200, 220, 30);
        userField.setBackground(Color.decode("#e6f2f2"));
        userField.setFont(new Font("Arial", Font.PLAIN, 15));
        userField.setForeground(Color.decode("#1a1a1a"));
        userField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setUsername(userField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userSignUp.setUsername(userField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setUsername(userField.getText());
            }
        });
        add(userField);

        passLabel = new JLabel("Password");
        passLabel.setBounds(100, 250, 100, 30);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(200, 250, 220, 30);
        passField.setBackground(Color.decode("#e6f2f2"));
        passField.setFont(new Font("Arial", Font.PLAIN, 15));
        passField.setForeground(Color.decode("#1a1a1a"));
        passField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setPassword(passField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userSignUp.setPassword(passField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setPassword(passField.getText());
            }
        });
        add(passField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 300, 100, 30);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 300, 220, 30);
        emailField.setBackground(Color.decode("#e6f2f2"));
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setForeground(Color.decode("#1a1a1a"));
        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setEmail(emailField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userSignUp.setEmail(emailField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setEmail(emailField.getText());
            }
        });
        add(emailField);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(100, 350, 100, 30);
        phoneLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 350, 220, 30);
        phoneField.setBackground(Color.decode("#e6f2f2"));
        phoneField.setFont(new Font("Arial", Font.PLAIN, 15));
        phoneField.setForeground(Color.decode("#1a1a1a"));
        phoneField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setPhone(phoneField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userSignUp.setPhone(phoneField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setPhone(phoneField.getText());
            }
        });
        add(phoneField);

        typeLabel = new JLabel("Type");
        typeLabel.setBounds(100, 400, 100, 30);
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(typeLabel);

        radioBtnManager = new JRadioButton("Manager");
        radioBtnManager.setBounds(200, 400, 100, 30);
        radioBtnManager.setBackground(Color.decode("#FCD9B8"));
        radioBtnManager.setFont(new Font("serif", Font.PLAIN, 20));
        radioBtnManager.setForeground(Color.decode("#1a1a1a"));
        add(radioBtnManager);

        radioBtnReceptionist = new JRadioButton("Receptionist");
        radioBtnReceptionist.setBounds(300, 400, 150, 30);
        radioBtnReceptionist.setBackground(Color.decode("#FCD9B8"));
        radioBtnReceptionist.setFont(new Font("serif", Font.PLAIN, 20));
        radioBtnReceptionist.setForeground(Color.decode("#1a1a1a"));
        add(radioBtnReceptionist);

        bg = new ButtonGroup();
        bg.add(radioBtnManager);
        bg.add(radioBtnReceptionist);
        if(bg.getSelection() == radioBtnReceptionist.getModel()){
            userSignUp.setType("Receptionist");
        }else{
            userSignUp.setType("Manager");
        }

        t1 = new JTextArea("Security Question: What is your favourite food?");
        t1.setBounds(100, 450, 350, 20);
        t1.setBackground(Color.decode("#FCD9B8"));
        t1.setFont(new Font("Arial", Font.ITALIC, 15));
        t1.setForeground(Color.decode("#1a1a1a"));
        t1.setEditable(false);
        add(t1);

        answerLabel = new JLabel("Answer");
        answerLabel.setBounds(100, 470, 100, 30);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(answerLabel);

        answerField = new JTextField();
        answerField.setBounds(200, 470, 220, 30);
        answerField.setBackground(Color.decode("#e6f2f2"));
        answerField.setFont(new Font("Arial", Font.PLAIN, 15));
        answerField.setForeground(Color.decode("#1a1a1a"));
        answerField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userSignUp.setAnswer(answerField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userSignUp.setAnswer(answerField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userSignUp.setAnswer(answerField.getText());
            }
        });
        add(answerField);


        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(130, 550, 280, 40);
        signUpBtn.setBackground(Color.decode("#000000"));
        signUpBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        signUpBtn.setForeground(Color.decode("#ffffff"));
        new SignUpController().SignUpUser(signUpBtn,this, userSignUp);
        add(signUpBtn);

        JPanel panelSignUp = new JPanel();
        panelSignUp.setBounds(80, 100, 400, 550);
        panelSignUp.setBackground(Color.decode("#FCD9B8"));
        add(panelSignUp);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logologin.png"));
        img1 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ib1 = new ImageIcon(img1);
        l1 = new JLabel(ib1);
        l1.setBounds(800, 200, 400, 400);
        add(l1);

        JPanel panel = new JPanel();
        l2 = new JLabel("Sign Up");
        l2.setBounds(600, 300, 800, 100);
        l2.setFont(new Font("Arial", Font.BOLD, 40));
        l2.setForeground(Color.decode("#E09145"));
        panel.add(l2);
        panel.setBounds(600, 0, 800, 800);
        panel.setBackground(Color.decode("#17181D"));
        add(panel);




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
        gradientPanel.setBounds(0, 0, 1400, 800);
        add(gradientPanel);
        setVisible(true);
    }



    public static void main(String[] args) {
        new SignUp();
    }
}
