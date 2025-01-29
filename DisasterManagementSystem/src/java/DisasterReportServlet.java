import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DisasterReportServlet") // Maps the servlet to the URL pattern
public class DisasterReportServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data from the request
        String location = request.getParameter("location");
        String disasterType = request.getParameter("disaster");
        String details = request.getParameter("details");

        // For now, let's just print the data to the console (you can save this data to a database later)
        System.out.println("Disaster Report Received:");
        System.out.println("Location: " + location);
        System.out.println("Type of Disaster: " + disasterType);
        System.out.println("Details: " + details);

        // Send response back to the user confirming their report submission
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Your Disaster Report has been submitted successfully!</h2>");
        out.println("<p><strong>Location:</strong> " + location + "</p>");
        out.println("<p><strong>Type of Disaster:</strong> " + disasterType + "</p>");
        out.println("<p><strong>Details:</strong> " + details + "</p>");
        out.println("<p>Thank you for your report!</p>");
        out.println("</body></html>");
    }
}
