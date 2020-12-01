package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = "/Failed2Add/*", loadOnStartup = 1)
public class Failed2Add extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println ("<HTML>");
        out.println ("<HEAD>");
        out.println ("<TITLE>Results</TITLE>");
        out.println ("</HEAD>");
        out.println("<BODY>");
        out.println ("<CENTER>");
        out.println("<h2>Failed to Add Friend</h2>");
        out.println ("</CENTER>");
        out.println("</BODY>");
        String user = request.getParameter("user");
        out.println("<form action=/WelcomeView/*?username=\""+user+" actions=\"Get\">");
        out.println("<input type=\"hidden\" value=\""+user+"\">");
        out.println("<input type=\"submit\" value=\"Go Back\">");
        out.println("</form>");

    }
}