<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" href="register.css">
</head>
<body>
  <div class="register-box">
    <h2>Register</h2>
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
    <form action="RegisterServlet" method="post">
      <input type="text" name="username" placeholder="Username" required><br>
      <input type="email" name="email" placeholder="Email" required><br>
      <input type="password" name="password" placeholder="Password" required><br>
      <button type="submit">Sign Up</button>
    </form>
    <p>Already have an account? <a href="index.jsp">Login</a></p>
  </div>
</body>
</html>
