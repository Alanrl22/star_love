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

    public List<Profil> findLove(String genderValue, String eye_color, String nameP) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            statement = connection.prepareStatement(
                    "SELECT gender, people.name As name, planet.name AS planet, eye_color FROM people JOIN planet ON planet.id = people.planet_id WHERE planet.name LIKE ? AND gender LIKE ? AND eye_color LIKE ? ;"
            );
            statement.setString(1, eye_color);
            statement.setString(2, genderValue);
            statement.setString(3, nameP);

            resultSet = statement.executeQuery();

            List<Profil> profils = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String eye = resultSet.getString("eye_color");
                nameP = resultSet.getString("planet.name");
                String gender = resultSet.getString("gender");

                profils.add(new Profil(id, eye, gender, nameP, null));
            }
            return profils;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}