package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/LoginController/*", loadOnStartup = 1)
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String user = request.getParameter("username");
        String pw = request.getParameter("password");
        //call all functions with info pulled
        boolean accepted = true;

        try {
            accepted = CheckLogin.accountExists(user);
            boolean passed = true;
            if (accepted == true) {
               passed = CheckLogin.passwordMatches(user, pw);

                if (passed == true) {
                    LoginRecord.AddLogin(user, true);
                    response.sendRedirect("/WelcomeView/*?username="+user);
                } else {
                    LoginRecord.AddLogin(user, false);
                    response.sendRedirect("/FailedView/");
                }
            } else {
                CheckLogin.addAccount(user, pw);
                LoginRecord.AddLogin(user, false);
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //send results to view

        //view needs to be able to go to thomas or tyler
    }
}