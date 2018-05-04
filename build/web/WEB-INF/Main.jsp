<%-- 
    Document   : Main
    Created on : 27 Apr, 2018, 1:01:48 AM
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
        <input type="button" value="SearchbyTitle" onclick="location.href='index.jsp'" />
        <input type="button" value="SearchbyISBN" onclick="location.href='searchisbn.jsp'" />
        <input type="button" value="SearchbyBorrrower" onclick="location.href='searchborrower.jsp'" />
        <input type="button" value="SearchbyAuthor" onclick="location.href='searchauthor.jsp'" />
        <input type="button" value="Insert Book" onclick="location.href='insertbook.jsp'" />
        <input type="button" value="Insert Author" onclick="location.href='insertauthor.jsp'" />
        <input type="button" value="Insert Borrower" onclick="location.href='insertborrower.jsp'" />
    </body>
</html>
