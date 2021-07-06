<%-- 
    Document   : error
    Created on : May 18, 2021, 12:35:34 AM
    Author     : Le Phuoc Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPD</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        <h2>
            <font color="red">
            ${requestScope.ERROR}
            </font>
        </h2>
            <a href="login.jsp">Back to Login page</a>
    </body>
</html>
