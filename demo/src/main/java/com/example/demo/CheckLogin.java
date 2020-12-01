package com.example.demo;

import oracle.jdbc.driver.*;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class CheckLogin {

    //Checks to see if an account exists in the database
    public static boolean accountExists(String usrName) throws Exception {
      //  System.out.println("HELLO");
        Connection conn = connect.databaseConn();
      //  System.out.println("Connected");
        String sqlQuery = "SELECT username FROM accounts WHERE username=\'" + usrName+"\'";
        //System.out.println(sqlQuery);
        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
        ResultSet rset = pstmt2.executeQuery();

        if (rset.next() == true) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
//usrName.compareTo(rset.getString(1)) ==
    
    
    //checks to see if a password matches a username
    public static boolean passwordMatches(String usrName, String pW) throws Exception {
        //works
        //System.out.println("password matches");
        Connection conn = connect.databaseConn();
        String sqlQuery = "SELECT * FROM Accounts WHERE username=\'" + usrName + "\' AND pass = \'" + pW+"\'";
        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
        ResultSet rset = pstmt2.executeQuery();

        if (rset.next() == true) {
            System.out.println("login successfull");
            return true;
        } else {
            System.out.println("login not successfull");
            return false;
        }
    }
//usrName.compareTo(rset.getString("username")) == 0) && pW.compareTo(rset.getString("pass"
    
    
    //adds an account into the database
    public static boolean addAccount(String usrName, String pW) throws Exception {
        //works
        //get a new id by adding 1 to current highest id value
        Connection conn = connect.databaseConn();
        String sqlQuery = "SELECT MAX (DISTINCT userid) FROM Accounts";
        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
        ResultSet rset = pstmt2.executeQuery();
        rset.next();
        int newID = rset.getInt(1) + 1;
        System.out.println("ADD ACCOUNT PT1");
        //add the new account
        String sqlQuery2 = ("INSERT INTO Accounts (username, pass, userid) VALUES (\'" + usrName + "\', \'" + pW + "\', " + newID + ")");
        System.out.println(sqlQuery2);
        PreparedStatement pstmt3 = conn.prepareStatement(sqlQuery2);
        pstmt3.executeQuery();
        System.out.println("ADD ACCOUNT PT2");

        //was it added successfully
        String sqlQuery3 = "SELECT username FROM Accounts WHERE user=\'" + usrName + "\' AND password = \'" + pW+"\'";
        PreparedStatement pstmtCheck = conn.prepareStatement(sqlQuery);
        ResultSet rset3 = pstmtCheck.executeQuery();
        System.out.println("ADD ACCOUNT PT3");

        if (rset3.next()) {
            System.out.println("added account successful");
            return true;
        } else {
            System.out.println("added account failed");
            return false;
        }
    }
//(usrName.compareTo(rset3.getString(1)) == 0) && pW.compareTo(rset3.getString(2)) == 0
    
    
    //checks if a friend name matches their id number
    public static boolean IDMatches(String usrName, int iD) throws Exception {

        Connection conn = connect.databaseConn();
        String sqlQuery = "SELECT * FROM accounts WHERE username=\'" + usrName + "\' AND userid=" + iD;
        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
        System.out.println("ID QUERY " + sqlQuery);
        ResultSet rset = pstmt2.executeQuery();
        if (rset.next()) {
            System.out.println("id exists");
            return true;
        } else {
            return false;
        }

    }
//(usrName.compareTo(rset.getString(1)) == 0) && (rset.getInt(2) == iD)
    
    //
    public static ArrayList getFriendsList(String usrName) throws Exception {


        ArrayList<String> friendList = new ArrayList<String>();
        Connection conn = connect.databaseConn();
        String sqlQuery = "SELECT friends FROM friendList WHERE user=" + usrName;
        PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
        ResultSet rset = pstmt2.executeQuery();

        while (rset.next()) {
            friendList.add(rset.getString(1));
        }
        return friendList;
    }
    //inster friend into the database
    public static boolean addFriend(String usrName, String friend, int id) throws Exception {


        //add the new friend
        Connection conn = connect.databaseConn();
        //System.out.println("CONNECTED");

        String sqlQuery = ("INSERT INTO friendlist (username, friend, friendID) VALUES (\'" + usrName + "\', \'" + friend + "\', " + id + ")");
        PreparedStatement pstmt3 = conn.prepareStatement(sqlQuery);
        pstmt3.executeQuery();
        System.out.println("add friend inserted");

        //was it added successfully
        String sqlQuery2 = "SELECT friend FROM friendlist WHERE username=\'" + usrName + "\' AND friend = \'" + friend+"\'";
        PreparedStatement pstmtCheck = conn.prepareStatement(sqlQuery2);
        ResultSet rset3 = pstmtCheck.executeQuery();

        if (rset3.next()) {
            return true;
        } else {
            return false;
        }
    }
//(usrName.compareTo(rset3.getString(1)) == 0) && friend.compareTo(rset3.getString(2)) == 0

}
