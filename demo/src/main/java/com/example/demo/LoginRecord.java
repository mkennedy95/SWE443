package com.example.demo;

import oracle.jdbc.driver.*;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class LoginRecord {
    //research needs to be done to get date and time
    //adds a login user date time and if successfull not functional
    public static boolean AddLogin(String usrName, boolean success) throws Exception {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //LocalDateTime now = LocalDateTime.now();
        //insert into database if login attempt was succesfull
       /* String s = String.valueOf(success);
        java.util.Date today = new java.util.Date();
        Connection conn = connect.databaseConn();
        String sqlQuery = ("INSERT INTO LoginRecord (usrName, success, loginTime) VALUES (?,?,?)");

        PreparedStatement pstmt3 = conn.prepareStatement(sqlQuery);
        pstmt3.setString(1,usrName);
        pstmt3.setString(2,s);
        pstmt3.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
        System.out.println(sqlQuery);
        pstmt3.executeQuery();*/

        return true;

    }


}
