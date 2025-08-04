<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
  <div class="login-box">
    <h2>Login</h2>
    <%
	    HttpSession session1 = request.getSession(false);
	    String error = null;
	    if (session1 != null) {
	        error = (String) session.getAttribute("errorMessage");
	        session1.removeAttribute("errorMessage");  // Remove after showing once
	    }
	    if (error != null) {
	%>
    	<p style="color:red;"><%= error %></p>
	<% } %>
    
    <form action="LoginServlet" method="post">
      <input type="text" name="username" placeholder="Username" required><br>
      <input type="password" name="password" placeholder="Password" required><br>
      <button type="submit">Login</button>
    </form>
    <p>Don't have an account? <a href="register.jsp">Sign up</a></p>
  </div>
</body>
</html>
