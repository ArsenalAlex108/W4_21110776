<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <img src="img/murach.png" alt="Murach Logo">
        <h1>Survey</h1>
        <p>If you have a moment, we would appreciate it if you would fill out this survey</p>
        <h1>Your information:</h1>
        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">
            <label>Email:</label>
            <input type="email" name="email" required><br>
            <label>First Name: </label>
            <input type="text" name="firstName" required><br>
            <label>Last Name: </label>
            <input type="text" name="lastName" required><br>
            <label>Date of Birth:</label>
            <input type="date" name="dateOfBirth"><br> 
            
            <h1>How did you hear about us?</h1>
            <input id="searchEngine" type="radio" name="howDidYouHearAboutUs" value="searchEngine" required>Search Engine           
            <input id="wordOfMouth" type="radio" name="howDidYouHearAboutUs" value="wordOfMouth" required>Word of mouth          
            <input id="socialMedia" type="radio" name="howDidYouHearAboutUs" value="socialMedia" required>Social media
            <input id="other" type="radio" name="howDidYouHearAboutUs" value="other" required>Other
             
            <h1>Would you like to receive announcements about new CDs and special offers?</h1>
            <input type="checkbox" name="likeThat">YES, I'd like that.<br>
            <input type="checkbox" name="likeEmail">YES, please send me email announcements<br>
            
            <label>Please contact me by:</label>
            <select name="mailingChoice" id="mailingChoice">
                <option value = emailOrPostal>Email or postal mail</option>
                <option value = email>Email only</option>
                <option value = postal>Postal mail only</option>
            </select>
            
            <label>&nbsp;</label>
            <input type="submit" value="Join Now" id="submit">            
            
        </form>
    </body>
</html>