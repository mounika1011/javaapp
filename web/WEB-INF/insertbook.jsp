<%-- 
    Document   : insertbook
    Created on : 26 Apr, 2018, 9:20:15 PM
    Author     : mouni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form2" method="post" action="InsertServlet">
        ISBN: <input type="text" name="isbn"><br>
        Title: <input type="text" name="title"><br>
        Publisher ID: <input type="text" name="p_id"><br>
        Author ID: <input type="text" name="a_id"><br>
        PublishDate: <input type="text" name="publishdate"><br>
        Available Copies: <input type="text" name="availablecopies"><br>
        <input type="Submit" value="Submit">
        </form>
    </body>
</html>
