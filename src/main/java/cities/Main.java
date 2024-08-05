package cities;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        CityDAO studentDAO = new CityDAO();

        System.out.println("Add new city");
        City newCity = new City(7,"Warsaw", 1700000, "Poland");
        studentDAO.addCity(newCity);

        System.out.println("Update city");
        City updatedStudent = new City(1, "Minsk", 1, "Belarus");
        studentDAO.updateCity(updatedStudent);

        System.out.println("Delete city");
        studentDAO.deleteCity(2);

        System.out.println("Show all cities");
        List<City> allStudents = studentDAO.getAllCities();
        allStudents.forEach(System.out::println);
    }
}
