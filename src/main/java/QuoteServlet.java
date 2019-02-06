import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="QuoteServlet", urlPatterns = "/quotes/random")
public class QuoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // talk to QuotesDao, call the random method to get a random quote.
        Quote quote = DaoFactory.getQuotesDao().random();

        // Bind the randomQuote object as an attribute to the request object.
        request.setAttribute("quote", quote);

        // The requestDispatcher runs any java code in order to render the appropriate HTML.
        request.getRequestDispatcher("/WEB-INF/quotes/quote.jsp").forward(request, response);
    }
}
