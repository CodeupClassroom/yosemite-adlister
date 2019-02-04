import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="QuoteServlet", urlPatterns = "/randomquote")
public class QuoteServlet extends HttpServlet {
    protected String[] quotes = {
        "Whatever you are, be a good one - Abraham Lincoln",
        "It's about making your users awesome, enabling them to kick butt! - Kathy Sierra"
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = "<h1>Quote: '" + getRandomQuote() + "'.</h1>";

        response.getWriter().println(message);
    }

    protected String getRandomQuote() {
        // randomly generate an index in range
        int index = (int) Math.floor(Math.random() * quotes.length);

        // assign the quote variable to hold a random quote string
        return quotes[index];
    }


}
