import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie ourCookie = new Cookie("ourCookie","Daniel");

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("ourCookie")) {
                ourCookie = cookie;
            }
        }

        response.addCookie(ourCookie);

        request.setAttribute("name", ourCookie.getValue());
        request.getRequestDispatcher("/WEB-INF/cookies.jsp").forward(request,response);
    }

}
