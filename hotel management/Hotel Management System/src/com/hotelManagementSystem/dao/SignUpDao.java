package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.entity.User;

public class SignUpDao {

    void SignUpDao(){}
    public int SignUpUser(User user) {
        try {

            Conn c = new Conn();
            String str = "insert into Users values('" + user.getId() + "', '" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', '" + user.getPhone() + "', '" + user.getType() + "', '" + user.getAnswer() + "')";
            c.getStatment().executeUpdate(str);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}



