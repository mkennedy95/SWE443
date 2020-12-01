package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/WelcomeController/*", loadOnStartup = 1)
public class WelcomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String user = request.getParameter("user");

        String friend = request.getParameter("friendName");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("WELCOM CONTROLLER" + user + "friend "+ friend+ " id "+ id);
        String send = "/WelcomeView/*?username="+user;
        Boolean matches = false;
        try {
            matches = CheckLogin.IDMatches(friend, id);
            System.out.println("matches = " + matches);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //checks to see if a friend and id match in order to add a friend to a friend base then sends to either failed to add view or back to their welcome page
        //depending on if the friend was added successfully
        if(matches == true){
            try {
               CheckLogin.addFriend(user, friend, id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            send = "/Failed2Add/*?user="+user;
        }
        response.sendRedirect(send);
    }
}
