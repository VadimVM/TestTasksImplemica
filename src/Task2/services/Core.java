package Task2.services;

import Task2.models.CitiesMap;
import Task2.models.City;

import java.util.*;

public class Core {
    public static Integer getShortestPathBetweenCities(CitiesMap citiesMap, String source, String destination) {
        CitiesMap calculatedCitiesMap = Core.calculateShortestPathFromSource(citiesMap, citiesMap.getCityByName(source));
        for (City city: calculatedCitiesMap.getCites()) {
            if (city.getName().equals(destination)){
                return city.getDistance();
            }
        }
        throw new NoSuchElementException(String.format("City not found in cities registry: %s", destination));
    }

    public static CitiesMap calculateShortestPathFromSource(CitiesMap citiesMap, City source) {
        source.setDistance(0);

        Set<City> settledNodes = new HashSet<>();
        Set<City> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            City currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<City, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                City adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return citiesMap;
    }

    private static City getLowestDistanceNode(Set<City> unsettledCities) {
        City lowestDistanceNode = null;
        int lowestDistance = 200000;
        for (City node : unsettledCities) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(City evaluationNode,
                                                 Integer edgeWeigh, City sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<City> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
