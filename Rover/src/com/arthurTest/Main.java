package com.arthurTest;
import com.arthurTest.routeSearch.RoverRouteSearch;

public class Main {

    public static void main(String[] args) {
        String[][] photoMap_1 = new String[][] {
            {"0" , "x", "x", "2", "3", "4"},
            {"1" , "x", "2", "2", "3", "3"},
            {"2" , "2", "2", "3", "4", "4"},
            {"3" , "4", "4", "3", "4", "4"},
            {"3" , "4", "5", "5", "4", "3"},
            {"4" , "5", "5", "6", "x", "2"},
            {"x" , "6", "6", "x", "x", "2"}};

        RoverRouteSearch.calculateRoverPath(photoMap_1);
    }
}
