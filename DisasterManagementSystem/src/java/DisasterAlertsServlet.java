import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DisasterAlertsServlet")
public class DisasterAlertsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the list of alerts from the session
        HttpSession session = request.getSession();
        List<String> alerts = (List<String>) session.getAttribute("alerts");

        if (alerts == null) {
            alerts = new ArrayList<>();
        }

        // Set the alerts as a request attribute to display on the page
        request.setAttribute("alerts", alerts);

        // Forward the request to the disasteralerts.html page
        RequestDispatcher dispatcher = request.getRequestDispatcher("disasteralerts.html");
        dispatcher.forward(request, response);
    }
}
