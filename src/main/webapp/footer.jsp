<%-- 
    Document   : footer
    Created on : Oct 3, 2023, 8:09:27 PM
    Author     : Khoapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.time.Year" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>
    </head>
    <body>
        <!-- <p>Copyright &copy; <%= Year.now().getValue() %></p> -->
        
    <c:if test="${year != null && year != ""}">
        <p>Copyright &copy; ${year}</p>
    </c:if>
        
    </body>
</html>
