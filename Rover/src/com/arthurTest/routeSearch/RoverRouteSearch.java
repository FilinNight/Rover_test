package com.arthurTest.routeSearch;
import com.arthurTest.helperClasses.*;
import com.arthurTest.logic.*;

public class RoverRouteSearch {

    public static void calculateRoverPath(String[][] map) {
        try {
            if (map.length != 0) {
                Coordinate[][] newMap = RoverRouteSearch.conversionMap(map);
                if (!checkCorrectMap(newMap)) {
                    RecordToFile.recordToTXT(null, 0, 0, true, false, false);
                } else {
                    LogicMain logic = new LogicMain(newMap);
                    logic.start();
                    if (logic.isNotPathFinish()) {
                        RecordToFile.recordToTXT(
                            logic.getShortPath(), logic.getSteps(), logic.getFuel(), false, true,
                            false);
                    } else {
                        RecordToFile.recordToTXT(
                            logic.getShortPath(), logic.getSteps(), logic.getFuel(), false, false,
                            false);
                    }
                }
            } else {
                RecordToFile.recordToTXT(null, 0, 0, false, false, false);
            }
        } catch (Exception e) {
            RecordToFile.recordToTXT(null, 0, 0, false, false, true);
        }
    }

    private static boolean checkCorrectMap(Coordinate[][] map) {
        if (map[0][0].isNoPassage()) {
            return false;
        }
        if (map[map.length - 1][map[0].length - 1].isNoPassage()) {
            return false;
        }
        return true;
    }

    private static Coordinate[][] conversionMap(String[][] map) {
        Coordinate[][] newMap = new Coordinate[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if ("x".equals(map[i][j]) || "X".equals(map[i][j])) {
                    newMap[i][j] = new Coordinate(i, j, 0);
                    newMap[i][j].setNoPassage(true);
                } else {
                    try {
                        newMap[i][j] = new Coordinate(i, j, Integer.parseInt(map[i][j]));
                    } catch (Exception e) {
                    }
                }
            }
        }
        return newMap;
    }
}





