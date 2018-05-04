<%-- 
    Document   : insertauthor
    Created on : 27 Apr, 2018, 12:47:19 AM
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
        <form name="form2" method="post" action="InsertAuthorServlet">
        Author ID: <input type="text" name="a_id"><br>
        A_name: <input type="text" name="a_name"><br>
       Email: <input type="text" name="email"><br>
      
        <input type="Submit" value="Submit">
        </form>
    </body>
</html>
