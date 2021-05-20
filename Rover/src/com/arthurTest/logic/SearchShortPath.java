package com.arthurTest.logic;
import com.arthurTest.helperClasses.*;

public class SearchShortPath {
    private Coordinate[][] map;
    private Coordinate finish;
    private Path myPath;
    private NextMove nextMove;
    private Path minPath;

    public SearchShortPath(Coordinate[][] map) {
        this.finish = map[map.length - 1][map[0].length - 1];
        this.map = map;
        this.myPath = new Path();
        this.nextMove = new NextMove();
        ;
    }

    public void Bypass(Coordinate myCoordinate) { // Обход через рекурсию

        myCoordinate.setNewCoordinate(false);
        myPath.add(myCoordinate);

        if (myPath.get(myPath.size() - 1).equals(finish) && minPath == null) {
            Path path = new Path();
            for (int i = 0; i < myPath.size(); i++) {
                path.add(
                    new Coordinate(myPath.get(i).getY(), myPath.get(i).getX(),
                        myPath.get(i).getLevel()));
            }
            minPath = path;

        } else if (minPath != null) {

            if (myCoordinate.equals(finish) && fullValueFuel(minPath) > fullValueFuel(myPath)) {
                Path path = new Path();
                for (int i = 0; i < myPath.size(); i++) {
                    path.add(
                        new Coordinate(myPath.get(i).getY(), myPath.get(i).getX(),
                            myPath.get(i).getLevel()));
                }
                minPath = path;
                return;
            }

            if (fullValueFuel(minPath) < fullValueFuel(myPath)) {
                return;
            }
        }

        Path AllFreePaths = nextMove.allNewPaths(myCoordinate, map);

        if (AllFreePaths.size() == 0) {
            return;
        }

        for (int i = 0; i < AllFreePaths.size(); i++) {
            myCoordinate = AllFreePaths.get(i);
            Bypass(myCoordinate);
            myCoordinate.setNewCoordinate(true);
            myPath.removeLastItem();
        }
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

    private int fullValueFuel(Path path) {
        int fuel = 0;
        int diagonal = (getDiagonalMove(path) / 2) - 1;

        for (int i = 0; i < path.size() - 1; i++) {
            fuel += difference(path.get(i).getLevel(), path.get(i + 1).getLevel());
        }
        fuel += (path.size()-1) + diagonal;
        return fuel;
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

    public Path getMinPath() {
        return minPath;
    }

}