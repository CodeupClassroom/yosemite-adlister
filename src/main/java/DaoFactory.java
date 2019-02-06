public class DaoFactory {

    private static Quotes quotesDao;

    public static Quotes getQuotesDao() {
        if(quotesDao == null) {
            quotesDao = new QuotesDao();
        }
        return quotesDao;
    }
}
