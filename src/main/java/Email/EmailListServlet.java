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
import java.time.Year;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khoapa
 */

@WebServlet(name="EmailList", urlPatterns={"/emailList"})
public final class EmailListServlet extends HttpServlet {

    private static final Logger logger = Logger.getGlobal();
    
    private boolean validate(HttpServletRequest request, String[] args)
    {
        for(var arg : args)
        {
            var result = request.getParameter(arg);
            if (result == null || "".equals(result))
                return false;
        }
        return true;
    }
    
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

            String[] args = {"firstName", "lastName", "email", "howDidYouHearAboutUs"};

            if(validate(request, args))
            {
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
                
                request.setAttribute("year", Year.now());                
                
                url = "/thanks.jsp"; // the "thanks" page =
            

                
    // forward request and response objects to specified URL 
                getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
            }
            
            else
            {
                response.getWriter().println("We require that you provide your email, first and last name, and tell us how you heard about us");
                
                request.setAttribute("validationMessage", "We require that you provide your email, first and last name, and tell us how you heard about us");
                
                url = "/index.jsp";               
                
                getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //if(true) throw new ServletException();
        
        doPost(request, response);
        
        System.out.println("Action: " + request.getParameter("action"));
        
        logger.log(Level.CONFIG, "Action: {0}", request.getParameter("action"));
    }
}
    
