package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import static com.hotelManagementSystem.constants.Constants.*;
import com.hotelManagementSystem.views.Notification;

import java.sql.ResultSet;
import java.util.Random;


public class AddUserDao {

    public int addUser(User user, Account account){
        try{
            Conn conn = new Conn();
            String query = "SELECT * FROM users WHERE id = '" + user.getId() + "'";
            ResultSet rs = conn.getStatment().executeQuery(query);
            if(!rs.next()){
                String query2 = "insert into Users values('" + user.getId() + "', '" + user.getName() + "', '" + user.getAge() + "', '" + user.getGender() + "', '" + user.getPosition() + "', '" + user.getSalary() + "', '" + user.getPhone() + "', '" + user.getEmail() + "')";
                conn.getStatment().executeUpdate(query2);
                if (user.getPosition() == "receptionist" || user.getPosition() == "manager") {
                    String query3 = "insert into Account values('" + user.getId() + "', '" + generateRandomPassword(10) + "','" + "0" + "')";
                    conn.getStatment().executeUpdate(query3);
                    return 1;
                }
                return 1;
            }else {
                return 2;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
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
