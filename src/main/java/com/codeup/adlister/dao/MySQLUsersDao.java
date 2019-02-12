package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select * from users where username = ? limit 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    @Override
    public Long insert(User user) {
        String qry = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

//    @Override
//    public List<Ad> all() {
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
//
//    @Override
//    public Long insert(Ad ad) {
//
//        String qry = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
//
//        try {
//            PreparedStatement stmt = connection.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
//
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
//
//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(
//            rs.getLong("id"),
//            rs.getLong("user_id"),
//            rs.getString("title"),
//            rs.getString("description")
//        );
//    }
//
//    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        while (rs.next()) {
//            ads.add(extractAd(rs));
//        }
//        return ads;
//    }
}
