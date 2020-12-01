package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = "/WelcomeView/*", loadOnStartup = 1)
public class WelcomeView extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String user = request.getParameter("username");
        System.out.println("WElcome View" + user);
        int ID;
        try {
            Connection conn = connect.databaseConn();
            String sqlQuery = "SELECT userid FROM accounts WHERE username=\'" + user+"\'";
            PreparedStatement pstmt2 = conn.prepareStatement(sqlQuery);
            ResultSet rset = pstmt2.executeQuery();
            rset.next();
            ID = rset.getInt("userid");

            String sqlQuery2 = "SELECT * FROM friendlist WHERE username =\'" + user+"\'";
            System.out.println("SQL QUERY FRIEND LIST " + sqlQuery2);
            PreparedStatement pstmt3 = conn.prepareStatement(sqlQuery2);
            ResultSet rset2 = pstmt3.executeQuery();

        PrintWriter out = response.getWriter();
        out.println ("<HTML>");
        out.println ("<HEAD>");
        out.println ("<TITLE>Results</TITLE>");
        out.println ("</HEAD>");
        out.println("<BODY>");
        out.println ("<CENTER>");
        out.println("<h2>welcome "+user+" USER ID: " + ID + "</h2>");
        //out.println("ID: "+ID)
        out.println("<a href=\"http://69.244.76.36:8080/user?username="+user+"\">Go To Encode</a>");
        out.println("<br>");
        out.println("<a href=\"http://69.244.76.36:8080/user?username="+user+"\">Go To Message</a>");
        //add friends button
        out.println("<form action=\"/WelcomeController/*\" method = \"GET\">");
        out.println("FriendName<input type=\"text\" name=\"friendName\">");
        out.println("<br>");
        out.println("Friend ID <input type=\"text\" name=\"id\">");
        out.println("<br>");
        out.println("USER <input type=\"text\" name=\"user\">");
       //out.println("<input type=\"hidden\" value=\""+user+"\">");
            out.println("<br>");
        out.println("<input type=\"submit\" value=\"add friend\">");
        out.println("</form>");

        out.println("FRIENDS");

        out.println("<ul>");
        while(rset2.next()) {
            out.println("<li> Friend "+rset2.getString("friend")+" ID "+rset2.getInt("friendID")+"</li>");
        }
        out.println("</ul>");
           out.println("</CENTER>");
           out.println("</BODY>");

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
