package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    private final Conn conn = new Conn();


    public int checkLogin(Account account, User user){
        String query = "SELECT users.*, account.* FROM users JOIN account ON users.id = account.id WHERE users.id = ?";
        try{
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, account.getIdAccount());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(account.getPassword())){
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setGender(rs.getString("gender"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    user.setPosition(rs.getString("position"));
                    user.setSalary(rs.getString("salary"));
                    if(rs.getString("count").equals("1")){
                        if (user.getPosition().equals("manager")) {
                            return 1;
                        } else if (user.getPosition().equals("receptionist")) {
                            return 2;
                        }
                    }else {
                        return 3;
                    }
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.closeConnection();
        }
        return 0;
    }

}
