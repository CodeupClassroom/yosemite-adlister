public class DaoFactory {

    private static Quotes quotesDao;

    public static Quotes getQuotesDao() {
        if(quotesDao == null) {
            quotesDao = new QuotesDao();
        }
        return quotesDao;
    }

    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }
}
