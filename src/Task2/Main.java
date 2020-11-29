package Task2;

import Task2.models.CitiesMap;
import Task2.models.CitiesRegistry;
import Task2.models.City;
import Task2.services.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
In this app we use famous algorithm for finding the shortest path of a weighted graph and its implementation in Java (see class Core)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input number of test cases:"); // each line of input is accompanied by corresponding text
        int testCases = Integer.parseInt(reader.readLine()); // number of test that determines number of a app iterations
        for (int testCase = 0; testCase < testCases; testCase++) {
            CitiesRegistry citiesRegistry = new CitiesRegistry();
            System.out.printf("Please input number of cities for test case #%d: \n", testCase + 1);
            int numberOfCities = Integer.parseInt(reader.readLine()); // number of Cities
            for (int c = 0; c < numberOfCities; c++) {
                System.out.printf("Please input %d city name: \n", c + 1); // here we put the name of a first City
                int selfIndex = c + 1;
                City city = citiesRegistry.getOrCreateCity(selfIndex); // put or get corresponding City by numberId
                city.setName(reader.readLine());
                System.out.println("Please input number of neighbours:"); // number of neighbours
                int neighbours = Integer.parseInt(reader.readLine());
                for (int n = 0; n < neighbours; n++) {
                    System.out.printf("Please input %d neighbour information: \n", n + 1);
                    String[] neighbourInfo = reader.readLine().split(" "); // here we take the input data an array of strings
                    int neighbourIndex = Integer.parseInt(neighbourInfo[0]); // numberID of corresponding neighbours
                    int neighbourDistance = Integer.parseInt(neighbourInfo[1]); // distance
                    city.addDestination(citiesRegistry.getOrCreateCity(neighbourIndex), neighbourDistance);
                }
            }
            System.out.println("Please input number of path to find:"); // How many shortest paths do we want to find?
            int numberOfPathToFind = Integer.parseInt(reader.readLine());
            /* create double array of strings. in first part - variable "p" for corresponding search
                                                second - corresponding cities
            */
            String[][] measures = new String[numberOfPathToFind][2];
            for (int p = 0; p < numberOfPathToFind; p++) {
                System.out.printf("Please input %d measure cities: \n", p + 1);
                measures[p] = reader.readLine().split(" ");
            }
            for (int p = 0; p < numberOfPathToFind; p++) {
                CitiesMap citiesMap = citiesRegistry.ToCitiesMap();
                System.out.println(Core.getShortestPathBetweenCities(citiesMap, measures[p][0], measures[p][1]));
            }
        }
    }

}
