<%-- 
    Document   : index4
    Created on : 27 Apr, 2018, 12:33:18 AM
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
       <%
            String temp=(String) request.getAttribute("a_name");
            String[] array=temp.split(",");
            String a_id=array[0];
            String a_email=array[1];
            
        %>
        
       <form>
          
           Author_ID: <input type="text" name="a_id"value="<%=a_id%>" ><br>
           PUBLISHER_ID: <input type="text" name="a_email" value="<%=a_email%>" ><br>
           
           
       </form>
    </body>
</html>
