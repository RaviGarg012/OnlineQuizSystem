import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import DBUtil.java;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("username");
        String pass = request.getParameter("password");

        ServletContext context = getServletContext();
        try (Connection con = DBUtil.getConnection(context)) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", email);
                response.sendRedirect("welcome.jsp");
            } else {
            	HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Invalid email or password");

                // Redirect to index.jsp (NOT forward)
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", "Internal error occurred.");

            // Redirect to index.jsp (NOT forward)
            response.sendRedirect("index.jsp");
        }
    }
}
