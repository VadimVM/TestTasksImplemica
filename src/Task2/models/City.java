package Task2.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class City {
    /* This class describes our objects, wish wish are placed in graph "CitiesMap"
       This is where the fields and the generated, and also method "addDestination",
       wish contributes the weight of the edges of the graph
     */
    private String name;
    private List<City> shortestPath = new LinkedList<>(); //here we enter the value of the short path from the beginning of the graph to the desired point
    private Integer distance = 200000;
    Map<City, Integer> adjacentNodes = new HashMap<>(); // this Map contains data about the distance to the Adjacent  City

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<City> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<City, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<City, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addDestination(City destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

}
