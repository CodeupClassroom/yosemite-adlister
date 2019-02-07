public class DaoFactory {

    // instantiate a new configuration object.
    private static Config config = new Config();

    private static Quotes quotesDao;

    public static Quotes getQuotesDao() {
        if(quotesDao == null) {
            quotesDao = new QuotesDao(config);
        }
        return quotesDao;
    }
}
