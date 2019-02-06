import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="QuotesIndexServlet", urlPatterns = "/quotes")
public class QuotesIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get all the quotes
        List<Quote> quotes = DaoFactory.getQuotesDao().all();

        // bind the quotes to the request object
        request.setAttribute("quotes", quotes);

        // send the response along w/ the data
        request.getRequestDispatcher("/WEB-INF/quotes/index.jsp").forward(request, response);

    }
}
