package com.hotelManagementSystem.dao;
import com.hotelManagementSystem.entity.Driver;
import com.hotelManagementSystem.conn.Conn;
import com.hotelManagementSystem.views.Notification;

import java.sql.ResultSet;

public class AddDriversDao {
    private final Conn conn = new Conn();
    public int addDrivers(Driver driver){
        try{
            String query1 = "select * from Drivers where name = '" + driver.getName() + "'";
            ResultSet rs = conn.getStatment().executeQuery(query1);
            if(!rs.next()){
                String query2 = "insert into Drivers values('" + driver.getName() + "', '" + driver.getAge() + "', '" + driver.getGender() + "', '" + driver.getPhone() + "', '" + driver.getCarBrand() + "', '" + driver.getAvailable() + "', '" + driver.getLocation() + "')";
                conn.getStatment().executeUpdate(query2);
                return 1;
            }else {
                return 2;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
            conn.closeConnection();
        }
    }

}
