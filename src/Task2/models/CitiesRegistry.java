package Task2.models;

import java.util.HashMap;
import java.util.Map;

public class CitiesRegistry {
    private Map<Integer, City> citiesRegistry = new HashMap<>();

    public City getOrCreateCity(Integer cityIndex) {
        if (!citiesRegistry.containsKey(cityIndex)) {
            City city = new City();
            citiesRegistry.put(cityIndex, city);
            return city;
        }
        return citiesRegistry.get(cityIndex);
    }

    public CitiesMap ToCitiesMap() {
        CitiesMap citiesMap = new CitiesMap();
        for (Map.Entry<Integer, City> c: citiesRegistry.entrySet()) {
            citiesMap.addCity(c.getValue());
        }
        return citiesMap;
    }
}
