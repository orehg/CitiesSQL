package cities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    public void addCity(City city) {
        String query = "INSERT INTO cities (id, name, population, location) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, city.getId());
            statement.setString(2, city.getName());
            statement.setInt(3, city.getPopulation());
            statement.setString(4, city.getLocation());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCity(City city) {
        String query = "UPDATE cities SET name = ?, population = ?, location = ? WHERE id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setString(3, city.getLocation());
            statement.setLong(4, city.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCity(int cityId) {
        String query = "DELETE FROM cities WHERE id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cityId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT * FROM cities";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int population = resultSet.getInt("population");
                String location = resultSet.getString("location");
                cities.add(new City(id, name, population, location));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }
}
