<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>HOMEPAGE</h2>
    <% String webpage = "http://69.244.76.36:8080/user?username="+request.getParameter("user"); %>
    <% String webpage2 = "https://google.com"+request.getParameter("user"); %>

    <form action=<%=webpage %> >
        <input type="submit" value="Go to Encode" />
    </form>

    <form action=<%= webpage2 %>>
            <input type="submit" value="Go to Message" />
        </form>
</body>
</html>
