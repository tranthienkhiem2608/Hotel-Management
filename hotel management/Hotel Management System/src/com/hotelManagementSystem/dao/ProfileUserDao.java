package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;
import com.hotelManagementSystem.views.Login;
import com.hotelManagementSystem.views.Notification;

import javax.swing.*;
import java.sql.PreparedStatement;

public class ProfileUserDao {
    private Login l;
    private final Conn conn = new Conn();

    public ProfileUserDao(){
        l = new Login();
        l.setVisible(false);
    }

    public int updateUser(Account account, User user){
        try{
            String query = "update users set name = ?, age = ?, gender = ?, phone = ?, email = ? where id = ?";
            String query2 = "update account set password = ? where id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            PreparedStatement stmt2 = conn.getConnection().prepareStatement(query2);
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, l.getIDLogin());
            stmt2.setString(1, account.getPassword());
            stmt2.setString(2, l.getIDLogin());
            int flag = stmt.executeUpdate();
            int flag2 = stmt2.executeUpdate();
            if(flag == 1 && flag2 == 1) {
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }
}
