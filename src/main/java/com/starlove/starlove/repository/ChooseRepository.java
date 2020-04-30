package com.starlove.starlove.repository;

import com.starlove.starlove.entity.Choose;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChooseRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/star_wars?serverTimezone=Europe/Paris";
    private final static String DB_USER = "ewoks";
    private final static String DB_PASSWORD = "ewoks1$Ewoks2";


    public List<String> findEyecolors() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            List<String> colorEyes = new ArrayList<>();
            statement = connection.prepareStatement(
                    "SELECT distinct(eye_color) FROM people;"
            );
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String eye = resultSet.getString("eye_color");

                colorEyes.add(eye);
            }
            return colorEyes;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public List<String> findYourGender(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            List<String> genders = new ArrayList<>();
            statement = connection.prepareStatement(
                    "SELECT distinct(gender) FROM people;"
            );
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String eye = resultSet.getString("gender");

                genders.add(eye);
            }
            return genders;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;

    }
}