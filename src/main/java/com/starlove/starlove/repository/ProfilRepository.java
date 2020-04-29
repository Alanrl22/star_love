package com.starlove.starlove.repository;

import com.starlove.starlove.entity.Choose;
import com.starlove.starlove.entity.Profil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfilRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private final static String DB_USER = "ewoks2";
    private final static String DB_PASSWORD = "ewoks1$Ewoks2!";

    /* public List<Choose> findLove(String gender, String planet_name, String eye_color) {*/
    public List<Profil> findLove(String genderValue, String eye_color) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            /*statement = connection.prepareStatement(
                    "SELECT * FROM people WHERE gender LIKE  ? AND planet.name LIKE ? AND eye_color Like ? JOIN planet ON planet.id = people.planet_id;"
            );*/
            statement = connection.prepareStatement(
                    "SELECT * FROM people WHERE eye_color Like ? AND gender LIKE ? ;"
            );
            /*
            statement.setString(2, planet_name);*/
            statement.setString(1, eye_color);
            statement.setString(2, genderValue);

            resultSet = statement.executeQuery();

            List<Profil> profils = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String eye = resultSet.getString("eye_color");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");

                profils.add(new Profil(id, gender, name, eye, null));
            }
            return profils;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}