<%-- 
    Document   : thanks
    Created on : Aug 30, 2023, 2:05:47 PM
    Author     : Khoapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>
        <label>Email:</label>
        <span>${userInfo.user.email}</span><br>
        <label>First Name: </label>
        <span>${userInfo.user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${userInfo.user.lastName}</span><br>
        <label>Date of Birth: </label>
        <span>${userInfo.dateOfBirth}</span><br>
        <label>How you heard from us: </label>
        <span>${userInfo.userPreferences.howDidYouHearAboutUs}</span><br>
        <label>Receive announcements about new CDs and special offers: </label>
        <span>${userInfo.userPreferences.likeThat}</span><br>
        <label>Receive email announcements: </label>
        <span>${userInfo.userPreferences.likeEmail}</span><br>
        <label>Contact me by: </label>
        <span>${userInfo.userPreferences.mailingChoice}</span><br>        
        <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>
        <form action="index.jsp" method="get">
            <input type="hidden" name="action" value="join"> <input type="submit" value="Return">
        </form>
    </body>
</html>