package cities;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        CityDAO cityDAO = new CityDAO();

        System.out.println("Add new city");
        City newCity = new City(7,"Warsaw", 1700000, "Poland");
        cityDAO.addCity(newCity);

        System.out.println("Update city");
        City updatedStudent = new City(1, "Minsk", 100, "Belarus");
        cityDAO.updateCity(updatedStudent);

        System.out.println("Delete city");
        cityDAO.deleteCity(7);

        System.out.println("Show all cities");
        List<City> allCities = cityDAO.getAllCities();
        allCities.forEach(System.out::println);
    }
}
