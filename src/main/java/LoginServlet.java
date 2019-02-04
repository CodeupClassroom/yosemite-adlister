import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // tell the response that we're delivering html
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String content = "<form method='POST' action='/login'>"
                + "<label for='email'>Email:</label>"
                + "<input id='email' type='email' name='email' placeholder='Enter your email address' />"
                + "<br>"
                + "<label for='password'>Password:</label>"
                + "<input type='password' name='password' id='password' placeholder='password here'>"
                + "<br>"
                + "<button type='submit'>Login</button>"
                + "</form>";

        out.println(content);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // get the data from the user's submitted login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String goodLogin = "admin@codeup.com";
        String goodPassword = "password123";

        if(!email.equals(goodLogin) || !password.equals(goodPassword)) {
            response.sendRedirect("/login");
        }

        if(email.equals(goodLogin) && password.equals(goodPassword)) {
            out.println("<h1>You've successfully logged in</h1>");
        }

    }
}
