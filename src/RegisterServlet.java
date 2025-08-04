import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import DBUtil.java;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        ServletContext context = getServletContext();
        try (Connection con = DBUtil.getConnection(context)) {
            PreparedStatement pst = con.prepareStatement("INSERT INTO users(username, email, password) VALUES(?,?,?)");
            pst.setString(1, uname);
            pst.setString(2, email);  // ⚠️ For real apps, hash passwords
            pst.setString(3, pass);
            int i = pst.executeUpdate();
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
        	HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "User already exists or error occurred.");

            // Redirect to register.jsp (NOT forward)
            response.sendRedirect("register.jsp");
        }
    }
}
