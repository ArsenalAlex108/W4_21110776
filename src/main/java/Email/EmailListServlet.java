/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email;

import Business.User;
import Business.UserInfo;
import Business.UserPreferences;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Khoapa
 */

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
// get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }
// perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";
        } // the "join" page
        else if (action.equals(
                "add")) {
// get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            
            Date doB = new Date();
            
            try{
                doB = parser.parse(request.getParameter("dateOfBirth"));
            }
            catch(ParseException e) {}
            
            UserPreferences.HowDidYouHearAboutUs howDidYouHearAboutUs =
                    UserPreferences.HowDidYouHearAboutUs.valueOf(request.getParameter("howDidYouHearAboutUs"));
            
            boolean likeThat = request.getParameter("likeThat") != null;
            
            boolean likeEmail = request.getParameter("likeEmail") != null;
            
            UserPreferences.mailingChoice mailingChoice =
                    UserPreferences.mailingChoice.valueOf(request.getParameter("mailingChoice"));
            
// store data in User object and save User object in db 
            User user = new User(firstName, lastName, email);
            
            UserPreferences userPreferences = new UserPreferences(howDidYouHearAboutUs, likeThat, likeEmail, mailingChoice); 
            
            UserInfo userInfo = new UserInfo(user, doB, userPreferences);
            
            //UserDB.insert(user);

// set User object in request object and set URL 
            request.setAttribute("userInfo", userInfo);
            url = "/thanks.jsp"; // the "thanks" page =
        }
// forward request and response objects to specified URL 
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
    
