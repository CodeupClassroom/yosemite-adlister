import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class QuotesDao implements Quotes {

    // new stuff
    private Connection connection = null;

    public QuotesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    // refactor the all method to get records from the database
    @Override
    public List<Quote> all() {
        //
        quotes = new ArrayList<>();
        String query = "SELECT * FROM quotes";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                quotes.add(createQuoteFromResults(rs));
            }

            return quotes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Quote createQuoteFromResults(ResultSet rs){
        try{

            return new Quote(
                    rs.getLong("id"),
                    rs.getString("author"),
                    rs.getString("quote")
            );

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }



    // what we had yesterday is below
    private List<Quote> quotes;

    public Quote random() {
        if(quotes == null) {
            quotes = generateQuotes();
        }

        int randomIndex = (int) Math.floor(Math.random() * quotes.size());

        return quotes.get(randomIndex);

    }

    public Quote findOne(long id) {
        if(quotes == null) {
            quotes = generateQuotes();
        }

        return quotes.get((int) id - 1);
    }




    private List<Quote> generateQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(
                        1,
                        "Whatever you are, be a good one!",
                        "Abraham Lincoln"));
        quotes.add(new Quote(
                2,
                "What is the meaning of Zen? When hungry, eat. When tired, sleep.",
                "Zen Master"));

        quotes.add(new Quote(
                3,
                "Make your customers more awesome! Upgrade your user, not your product... make people better at something they want to get better at.",
                "Kathy Sierra"));

        quotes.add(new Quote(
                4,
                "You're going to make mistakes. The real mistake is not learning from them",
                "Anonymous"));

        quotes.add(new Quote(
                5,
                "Sometimes, the best debugger is a good night's rest. Or a walk.",
                "Ryan Orsinger"));

        quotes.add(new Quote(
                6,
                "Always remember the first lesson. The first lesson is to breath. Remember to breath!",
                "Daniel Fryar"));

        quotes.add(new Quote(
                7,
                "Talent is a pursued interest. Anything that you're willing to practice, you can do.",
                "Bob Ross"));

        return quotes;
    }
}
