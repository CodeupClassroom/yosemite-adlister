import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public static final String USER = "user";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if logged in, redirect to /profile
        if (request.getSession().getAttribute(LoginServlet.USER) != null) {
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute(USER, "user");
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
