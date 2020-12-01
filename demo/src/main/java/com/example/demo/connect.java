package com.example.demo;

import oracle.jdbc.driver.*;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class connect {

    //JDBC driver name and database url
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";//Try out "jdbc:mysql://artemis.vsnet.gmu.edu" if it doesnt work

    //credentials
    static final String USER = "mkenne";
    static final String PASS = "agladogu";
    static Connection conn = null;
    //creates data base connection to sqlplus account provided by school need to be on mason network in order to connect properly
    public static Connection databaseConn() throws Exception {
        // TODO Auto-generated method stub

        Connection conn = null;
        Statement stmt = null;

        //Register the JDBC driver
        Class.forName(JDBC_DRIVER);//"com.mysql.jdbc.Driver"

        //Open a connection to the database
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //Do a query
        stmt= conn.createStatement();

        return conn;
    }

}
