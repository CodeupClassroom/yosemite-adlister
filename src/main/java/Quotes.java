import java.util.List;

public interface Quotes {
    List<Quote> all();

    Quote random();

    Quote findOne(long id);
}
