package com.example.superherodatabasev5.repositories;

import com.example.superherodatabasev5.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository ("Superhero_DB")
public class SuperheroRepository implements ISuperheroRepository {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String user_Name;

    @Value("${spring.datasource.password}")
    private String pwd;

    public List<Superhero> getSuperheroAll() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url,user_Name,pwd))
        {
            String SQL = "SELECT * FROM superhero;";
            Statement stnt = con.createStatement();
            ResultSet rs = stnt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");

                superheroes.add(new Superhero(id, heroName, realName, creationYear));
            }
            return superheroes;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
