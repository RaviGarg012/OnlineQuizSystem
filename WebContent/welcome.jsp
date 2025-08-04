<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, jakarta.servlet.http.*, jakarta.servlet.*" %>
<%@ page session="true" %>
<%@ page import="java.sql.*, util.DBUtil" %>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>
<%
    HttpSession session1 = request.getSession(false);
    String username = (String) session1.getAttribute("username");
    if (username == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="welcome.css">
</head>
<body>
    <div class="topbar">
        <div><strong>Welcome, <%= username %></strong></div>
        <a href="LogoutServlet"><button class="logout-btn">Logout</button></a>
    </div>
    
	<h2>Welcome to Java Quiz!</h2>
    <form action="quiz.jsp">
        <input type="submit" value="Start Quiz">
    </form>
    
    <%
	    String msg = (String) request.getAttribute("message");
	    if (msg != null) {
	%>
    	<p style="color: green;"><%= msg %></p>
	<% } %>
</body>
</html>
