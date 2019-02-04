import com.sun.deploy.net.HttpRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResumeServlet", urlPatterns = "/resume")
public class ResumeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "<h1>Ryan's Resume</h1>";
        content += "<p>I write a lot of code. Check my GitHub</p>";
        content += "<hr><br>";
        content += "<a href='https://github.com/ryanorsinger/'>My GitHub Profile</a>";
        content += "<a href='/portfolio'>My Portfolio</a>";

        response.getWriter().println(content);
    }
}
