package com.hotelManagementSystem.dao;
import  com.hotelManagementSystem.conn.Conn;
import  com.hotelManagementSystem.entity.Account;
import  com.hotelManagementSystem.entity.User;

import java.sql.PreparedStatement;

public class AccountSettingDao {

    private final Conn conn = new Conn();
    public int checkChangePassword(User user, Account account) {

        try {
            String query = "UPDATE account SET password = '" + account.getPassword() +"', keyAnswer = '" + account.getKeyAnswer() + "', count = '1' WHERE id = '" + user.getId() + "'";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.executeUpdate();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        } finally {
            conn.closeConnection();
        }
    }

}
