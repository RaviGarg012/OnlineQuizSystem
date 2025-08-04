<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h2>Your Quiz Result</h2>
    <p>You scored: <strong><%= request.getAttribute("score") %></strong> out of 3</p>
    <a href="index.jsp">Try Again</a>
</body>
</html>
