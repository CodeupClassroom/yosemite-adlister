import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        count += 1;

        request.setAttribute("count", count);
        request.getRequestDispatcher("/counter.jsp").forward(request, response);

    }
}
