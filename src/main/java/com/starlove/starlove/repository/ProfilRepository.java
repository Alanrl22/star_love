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
    private final static String DB_USER = "ewoks";
    private final static String DB_PASSWORD = "ewoks1$Ewoks2";

    public List<Choose> findLove(String gender, String planet_name, String eye_color) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM people WHERE gender LIKE  ? AND planet.name LIKE ? AND eye_color Like ? JOIN planet ON planet.id = people.planet_id;"
            );
            statement.setString(1, gender);
            statement.setString(2, planet_name);
            statement.setString(3, eye_color);

            resultSet = statement.executeQuery();

            List<Choose> chooses = new ArrayList<>();

            while (resultSet.next()) {
                gender = resultSet.getString("gender");
                String planet = resultSet.getString("planet.name");
                String eye = resultSet.getString("eye_color");
                chooses.add(new Choose(gender, planet, eye));
            }
            return chooses;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}