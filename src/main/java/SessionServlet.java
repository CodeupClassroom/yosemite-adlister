import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String languagePreference = request.getParameter(LanguageService.LANGUAGE);
        if (languagePreference != null)
            session.setAttribute(LanguageService.LANGUAGE, languagePreference);
        else
            languagePreference = (String) session.getAttribute(LanguageService.LANGUAGE);
        if (languagePreference == null) {
            languagePreference = LanguageService.LANGUAGE_ENGLISH;
            session.setAttribute(LanguageService.LANGUAGE, languagePreference);
        }

        switch (languagePreference) {
            case LanguageService.LANGUAGE_ENGLISH :
                request.setAttribute("greeting", LanguageService.getGreeting(LanguageService.LANGUAGE_ENGLISH));
                break;
            case LanguageService.LANGUAGE_SPANISH :
                request.setAttribute("greeting", LanguageService.getGreeting(LanguageService.LANGUAGE_SPANISH));
                break;
            case LanguageService.LANGUAGE_FRENCH :
                request.setAttribute("greeting", LanguageService.getGreeting(LanguageService.LANGUAGE_FRENCH));
                break;
            default:
                request.setAttribute("greeting", LanguageService.getGreeting(LanguageService.LANGUAGE_ENGLISH));
        }

        request.getRequestDispatcher("/WEB-INF/session.jsp").forward(request,response);


    }
}
