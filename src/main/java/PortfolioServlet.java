import com.sun.deploy.net.HttpRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PortfolioServlet", urlPatterns = "/portfolio")
public class PortfolioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "<h1>Ryan's Portfolio</h1>";
        content += "<p>my awesome portolio</p> <br><hr><br>";
        content += "<a href='/resume'>My Resume</a>";

        response.getWriter().println(content);
    }
}
