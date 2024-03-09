package com.shiblee.jdbc.DatabaseConnection;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPractice {

    public static void main(String[] args) {
        
        try ( Connection connection = DriverManager.getConnection("jdbc:h2:mem:")){
            System.out.println("connection is valid " + connection.isValid(0));
            PreparedStatement ps = connection.prepareCall("insert into USERS(name) values(?)");
            ps.setString(1, "Shiblee");
            PreparedStatement ps2 = connection.prepareCall("SELECT * FROM USERS WHERE NAME = ?");
            ps2.setString(1, "shiblee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





}
