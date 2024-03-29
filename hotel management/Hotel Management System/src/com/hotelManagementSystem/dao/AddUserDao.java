package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.bean.PasswordEncoder;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import static com.hotelManagementSystem.constants.Constants.*;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Random;


public class AddUserDao {

    private final Conn conn = Conn.getInstance();
    private String pass;

    public int addUser(User user, JTextArea textArea) {
        try {
            String query = "SELECT * FROM users WHERE id = '" + user.getId() + "'";
            ResultSet rs = conn.getStatment().executeQuery(query);
            if (!rs.next()) {
                String query2 = "insert into Users values('" + user.getId() + "', '" + user.getName() + "', '" + user.getAge() + "', '" + user.getGender() + "', '" + user.getPosition() + "', '" + user.getSalary() + "', '" + user.getPhone() + "', '" + user.getEmail() + "')";
                conn.getStatment().executeUpdate(query2);
                if (user.getPosition().equals("Manager") || user.getPosition().equals("Receptionist")) {
                    pass = generateRandomPassword(10);
                    String query3 = "insert into Account values('" + user.getId() + "', '" + PasswordEncoder.encode(pass) + "','" + "khong" + "','" + "0" +"')";
                    conn.getStatment().executeUpdate(query3);
                    textArea.setText("Password: " + pass);
                    return 1;
                } else {
                    return 3;
                }
            } else {
                return 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
//            conn.closeConnection();

        }
    }

    public String generateRandomPassword(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
