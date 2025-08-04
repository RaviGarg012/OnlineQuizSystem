import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Invalidate the current session
        HttpSession session = request.getSession(false); // prevent creating new session
        if (session != null) {
            session.invalidate();
        }
        
        // Remove JSESSIONID cookie from browser
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0); // delete immediately
        cookie.setPath(request.getContextPath()); // important!
        response.addCookie(cookie);

        // Redirect to login page
        response.sendRedirect("index.jsp");
    }
}
