package cities;

import java.util.Objects;

public class City {
    private long id;
    private String name;
    private int population;
    private String location;

    public City(long id, String name, int population, String location) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        City city = (City) object;
        return id == city.id && population == city.population && Objects.equals(name, city.name) && Objects.equals(location, city.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population, location);
    }

    @Override
    public String toString() {
        return "City" +
                "id = " + id +
                ", name = " + name +
                ", population = " + population +
                ", location = " + location;
    }
}
