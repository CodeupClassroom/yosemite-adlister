//import java.util.HashMap;
//import java.util.Map;

public class LanguageService {

    public static final String LANGUAGE = "language";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_SPANISH = "es";
    public static final String LANGUAGE_FRENCH = "fr";
    public static final String LANGUAGE_DEFAULT = LANGUAGE_ENGLISH;

//    public static final Map<String,String> GREETINGS =
//    new HashMap<String, String>() {
//        {
//            put(LANGUAGE_ENGLISH, "Hello");
//            put(LANGUAGE_SPANISH, "Hola");
//            put(LANGUAGE_FRENCH, "Bonjour");
//        }
//    };

    public static String getGreeting(String language) {
        switch(language) {
            case LANGUAGE_ENGLISH : return "Hello";
            case LANGUAGE_SPANISH : return "Hola";
            case LANGUAGE_FRENCH : return "Bonjour";
            default : return "Hello";
        }
    }
}
