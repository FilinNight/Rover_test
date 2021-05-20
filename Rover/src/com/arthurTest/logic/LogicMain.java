package com.arthurTest.logic;
import com.arthurTest.helperClasses.*;

public class LogicMain {
    private Coordinate[][] map;
    private Path shortPath;
    private int steps;
    private int fuel;
    private boolean notPathFinish = false;

    public LogicMain(Coordinate[][] map) {
        this.map = map;
        shortPath = new Path();
    }

    public void start() {
        SearchShortPath searchShortPath = new SearchShortPath(map);
        searchShortPath.Bypass(map[0][0]);
        if (searchShortPath.getMinPath() != null) {
            shortPath = searchShortPath.getMinPath();
            fullValueFuel(shortPath);
        } else {
            notPathFinish = true;
        }
    }

    private int getDiagonalMove(Path path) {
        int valueDiagonalMove = 0;

        for (int i = 0; i < path.size() - 1; i++) {
            int y = path.get(i).getY();
            int x = path.get(i).getX();

            if ((y + 1) == path.get(i + 1).getY() && (x + 1) == path.get(i + 1).getX()) {
                valueDiagonalMove++;
            }
            if ((y - 1) == path.get(i + 1).getY() && (x - 1) == path.get(i + 1).getX()) {
                valueDiagonalMove++;
            }
            if ((y + 1) == path.get(i + 1).getY() && (x - 1) == path.get(i + 1).getX()) {
                valueDiagonalMove++;
            }
            if ((y - 1) == path.get(i + 1).getY() && (x + 1) == path.get(i + 1).getX()) {
                valueDiagonalMove++;
            }
        }
        return valueDiagonalMove;
    }

    private int fullValueFuel(Path path) {
        steps = path.size()-1;
        int diagonal = (getDiagonalMove(path) / 2) - 1;

        for (int i = 0; i < path.size() - 1; i++) {
            fuel += difference(path.get(i).getLevel(), path.get(i + 1).getLevel());
        }
        fuel += path.size() + diagonal;
        return fuel;
    }

    private static int difference(int a, int b) {
        int diff = 0;

        while (a != b) {
            if (a > b) {
                b++;
                diff++;
            }
            if (a < b) {
                b--;
                diff++;
            }
        }
        return diff;
    }

    public int getSteps() {
        return steps;
    }
    public int getFuel() {
        return fuel;
    }
    public Path getShortPath() {
        return shortPath;
    }
    public boolean isNotPathFinish() {
        return notPathFinish;
    }
}
