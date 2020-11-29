package Task2;

import Task2.models.CitiesMap;
import Task2.models.CitiesRegistry;
import Task2.models.City;
import Task2.services.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input number of test cases:");
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCases; testCase++) {
            CitiesRegistry citiesRegistry = new CitiesRegistry();
            System.out.printf("Please input number of cities for test case #%d: \n", testCase + 1);
            int numberOfCities = Integer.parseInt(reader.readLine());
            for (int c = 0; c < numberOfCities; c++) {
                System.out.printf("Please input %d city name: \n", c + 1);
                int selfIndex = c + 1;
                City city = citiesRegistry.getOrCreateCity(selfIndex);
                city.setName(reader.readLine());
                System.out.println("Please input number of neighbours:");
                int neighbours = Integer.parseInt(reader.readLine());
                for (int n = 0; n < neighbours; n++) {
                    System.out.printf("Please input %d neighbour information: \n", n + 1);
                    String[] neighbourInfo = reader.readLine().split(" ");
                    int neighbourIndex = Integer.parseInt(neighbourInfo[0]);
                    int neighbourDistance = Integer.parseInt(neighbourInfo[1]);
                    city.addDestination(citiesRegistry.getOrCreateCity(neighbourIndex), neighbourDistance);
                }
            }
            System.out.println("Please input number of path to find:");
            int numberOfPathToFind = Integer.parseInt(reader.readLine());
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
