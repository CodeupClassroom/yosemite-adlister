import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    Connection connection;

    public MySQLAdsDao(Config config) {
        // TODO: throw exception to be handled elsewhere
//        Config config = new Config();
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all(){
        List<Ad> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            while(rs.next()) {
                list.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Ad findOne(Long id) {
        Ad ad = null;
        try {
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM ads WHERE id = " + id;
//            ResultSet rs = statement.executeQuery(query);

            String prepQuery = "SELECT * FROM ads WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(prepQuery);
            System.out.println(preparedStatement);
            preparedStatement.setLong(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
//            ResultSet rs = preparedStatement.getResultSet();


            while(rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ad;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO ads(user_id,title,description) "
            + "values (" + ad.getUserId() + ",'" + ad.getTitle() + "','" + ad.getDescription() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Config config = new Config();
        MySQLAdsDao dao = new MySQLAdsDao(config);
//        dao.insert(new Ad(1,"Second Ad","The Sequel"));
        System.out.println(dao.findOne(2l).getTitle());
    }
}
