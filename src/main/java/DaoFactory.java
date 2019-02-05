public class DaoFactory {
    private static Ads adsDao;
    private static Quotes quotesDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }


    public static Quotes getQuotesDao() {
        if(quotesDao == null) {
            quotesDao = new QuotesDao();
        }
        return quotesDao;
    }
}
