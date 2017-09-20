package pl.pawelprzystarz.testproject.Models.dao.impl;

import pl.pawelprzystarz.testproject.Models.MySqlConnector;
import pl.pawelprzystarz.testproject.Models.Utils;
import pl.pawelprzystarz.testproject.Models.dao.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    MySqlConnector connector = MySqlConnector.getInstance();

    @Override
    public boolean login(String name, String password) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE username = ?"
            );

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return false;                // Przesuwa wskaźnik z -1 na 1;
            }

            return resultSet.getString("password").equals(Utils.shaHash(password));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean register(String name, String password) {

        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "SELECT * FROM user WHERE username = ?"
            );

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return false;
            }

            PreparedStatement preparedStatement1 = connector.getConnection().prepareStatement(
                    "INSERT INTO user VALUES(?,?,?)"
            );

            preparedStatement1.setInt(1, 0);
            preparedStatement1.setString(2, name);
            preparedStatement1.setString(3, Utils.shaHash(password));

            preparedStatement1.execute();

            preparedStatement.close();
            preparedStatement1.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void removeUser(int id) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "DELETE FROM user WHERE id = ?"
            );

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
