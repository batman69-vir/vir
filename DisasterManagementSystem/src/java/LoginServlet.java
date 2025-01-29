import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Simple hardcoded check (replace with actual database check later)
        if ("admin@example.com".equals(username) && "password123".equals(password)) {
            // Successful login - Redirect to a thank you page or show the message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Thank You, You are the Admin!</h3>");
            out.println("<p>Welcome to the Disaster Management System.</p>");
            out.println("<a href='dashboard.html'>Go to Dashboard</a>");
            out.println("</body></html>");
        } else {
            // If login fails, redirect back to the login page with an error message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Invalid username or password. Please try again.</h3>");
            out.println("<a href='login.html'>Back to Login</a>");
            out.println("</body></html>");
        }
    }
}

