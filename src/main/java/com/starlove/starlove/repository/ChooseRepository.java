package com.starlove.starlove.repository;

import com.starlove.starlove.entity.Choose;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChooseRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private final static String DB_USER = "ewoks";
    private final static String DB_PASSWORD = "ewoks1$Ewoks2";


    public List<Choose> Findlove() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.prepareStatement(
                    "SELECT distinct(eye_color) FROM people JOIN planet ON people.id_planet = planet.id;"
            );
            resultSet = statement.executeQuery();

            List<Choose> choose = new ArrayList<>();

            while (resultSet.next()) {
                String genre = resultSet.getString("gender");
                String planet = resultSet.getString("planet.name");
                String eye = resultSet.getString("eye_color");

                choose.add(new Choose(genre, planet, eye));
            }
            return choose;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}