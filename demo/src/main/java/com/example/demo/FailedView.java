package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = "/FailedView/*", loadOnStartup = 1)
public class FailedView extends HttpServlet {
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
        out.println("<h2>Failed to Login</h2>");
        out.println ("</CENTER>");
        out.println("</BODY>");

    }
}