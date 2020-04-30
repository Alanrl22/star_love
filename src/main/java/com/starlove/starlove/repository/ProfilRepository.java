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

    public List<Profil> findLove(String genderValue, String eye_color, String planetName) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT * FROM people, planet WHERE eye_color Like ? AND gender LIKE ? AND planet.name LIKE ? AND planet.id = planet_id ;"
            );
            statement.setString(1, eye_color);
            statement.setString(2, genderValue);
            statement.setString(3, "%"+planetName+"%");

            resultSet = statement.executeQuery();

            List<Profil> profils = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String eye = resultSet.getString("eye_color");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int idP = resultSet.getInt("planet_id");

                profils.add(new Profil(id, gender, name, eye, idP, null));
            }
            return profils;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}