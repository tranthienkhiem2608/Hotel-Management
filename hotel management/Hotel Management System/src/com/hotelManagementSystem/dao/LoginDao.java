package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.User;

import java.sql.ResultSet;

public class LoginDao {

    public int checkLogin(User user) {
        try {

            Conn c = new Conn();
            String query = "select * from Users where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'";
            ResultSet rs = c.getStatment().executeQuery(query);
            try {
                if (rs.next()) {
                    // check if user is manager or employee
                    user.setType(rs.getString("type"));
                    if (user.getType().equals("Manager")) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
