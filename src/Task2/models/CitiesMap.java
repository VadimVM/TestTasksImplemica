package Task2.models;

import java.util.HashSet;
import java.util.Set;

public class CitiesMap {
    /*
    a Graph is a set of cities.
    in the method  getCityByName through the foreach we get the necessary city by name
     */
    private Set<City> cites = new HashSet<>();

    public Set<City> getCites() {
        return cites;
    }

    public void addCity(City city) {
        cites.add(city);
    }

    public City getCityByName(String cityName) {
        for (City city : cites) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }

}
