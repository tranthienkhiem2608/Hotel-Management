package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.entity.User;
import  com.hotelManagementSystem.conn.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditEmployeeDao {

    private final Conn conn = new Conn();
    public User searchUser(User user) {
        try {
            String query = "select * from users where id = '" + user.getId() + "'";
            PreparedStatement stmt  = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setPosition(rs.getString("position"));
                user.setSalary(rs.getString("salary"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                return user;
            }else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            conn.closeConnection();
        }
    }
    public int saveUser(User user){
        try{
            String query = "update users set name = ?, age = ?, gender = ?, position = ?, salary = ?, phone = ?, email = ? where id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getPosition());
            stmt.setString(5, user.getSalary());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getEmail());
            stmt.setString(8, user.getId());
            int flag = stmt.executeUpdate();
            return flag;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }

    public int deleteUser(User user){
        try{
            String query = "delete from account where id = ?";
            String query2 = "delete from users where id = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            PreparedStatement stmt2 = conn.getConnection().prepareStatement(query2);
            stmt.setString(1, user.getId());
            stmt2.setString(1, user.getId());
            int flag = stmt.executeUpdate();
            int flag2 = stmt2.executeUpdate();
            return flag2;

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }
}