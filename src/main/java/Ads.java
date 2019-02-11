import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // look up an ad by its id and return it
    Ad findOne(Long id);
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

}
