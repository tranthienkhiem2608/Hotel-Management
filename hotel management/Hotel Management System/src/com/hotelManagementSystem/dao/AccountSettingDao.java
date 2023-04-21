package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.bean.PasswordEncoder;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.Account;
import com.hotelManagementSystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountSettingDao {

    private final Conn conn = Conn.getInstance();

    public int checkChangePassword(User user, Account account) {
        PreparedStatement pstmt = null;
        try {
            String query = "UPDATE account SET password = '" + PasswordEncoder.encode(account.getPassword()) + "', keyAnswer = '" + account.getKeyAnswer() + "', count = '1' WHERE id = '" + user.getId() + "'";
            pstmt = conn.getConnection().prepareStatement(query);
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            conn.closeConnection();
        }
    }
}
