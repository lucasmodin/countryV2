package org.example.jdbcspring.repository;

import org.example.jdbcspring.model.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CountryRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;


    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        String sql = "select * from countries";

        try(Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Country country = new Country(resultSet.getLong("id"), resultSet.getString("name"));
                countries.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return countries;
    }


}
