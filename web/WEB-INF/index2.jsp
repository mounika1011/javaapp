<%-- 
    Document   : index2
    Created on : 26 Apr, 2018, 10:49:06 PM
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
            String temp=(String) request.getAttribute("isbn_no");
            String[] array=temp.split(",");
            String title=array[0];
            String p_id=array[1];
            String a_id=array[2];
            String p_date=array[3];
            String avail=array[4];
        %>
        
       <form>
          
           Title: <input type="text" name="title"value="<%=title%>" ><br>
           PUBLISHER_ID: <input type="text" name="p_id" value="<%=p_id%>" ><br>
           AUTHOR_ID: <input type="text" name="a_id"value="<%=a_id%>" ><br>
           PUBLISHER_DATE: <input type="text" name="p_date"value="<%=p_date%>" ><br>
           AVAILABLE_COPIES: <input type="text" name="avail_copies"value="<%=avail%>" ><br>
           
       </form>
    </body>
</html>
