<%-- 
    Document   : index3
    Created on : 27 Apr, 2018, 12:10:36 AM
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
            String temp=(String) request.getAttribute("card_no");
            String[] array=temp.split(",");
            String b_name=array[0];
            String b_add=array[1];
            String b_phone=array[2];
            
        %>
        <form >
        
	Borrower Name: <input type="text" name="b_name"value="<%=b_name%>"><br>
	Borrower Address: <input type="text" name="b_add"value="<%=b_add%>"><br>
	Borrower Phone: <input type="text" name="b_phone"value="<%=b_phone%>"><br>
        </form>

    </body>
</html>
