package com.arthurTest.logic;
import com.arthurTest.helperClasses.*;

public class NextMove {
    public Path allNewPaths(Coordinate myCoordinate, Coordinate[][] map) {

        Path arrayCoordinates = new Path();

        if (myCoordinate.getY() != 0) { // up
            if (checkCoordinate(map[myCoordinate.getY() - 1][myCoordinate.getX()], map)) {
                arrayCoordinates.add(map[myCoordinate.getY() - 1][myCoordinate.getX()]);
            }
        }

        if (myCoordinate.getX() != map[0].length - 1) { // right
            if (checkCoordinate(map[myCoordinate.getY()][myCoordinate.getX() + 1], map)) {
                arrayCoordinates.add(map[myCoordinate.getY()][myCoordinate.getX() + 1]);
            }
        }

        if (myCoordinate.getY() != map.length - 1) { // down
            if (checkCoordinate(map[myCoordinate.getY() + 1][myCoordinate.getX()], map)) {
                arrayCoordinates.add(map[myCoordinate.getY() + 1][myCoordinate.getX()]);
            }
        }

        if (myCoordinate.getX() != 0) { // left
            if (checkCoordinate(map[myCoordinate.getY()][myCoordinate.getX() - 1], map)) {
                arrayCoordinates.add(map[myCoordinate.getY()][myCoordinate.getX() - 1]);
            }
        }

        if (myCoordinate.getY() != map.length - 1) { // diagonalDownRight
            if (myCoordinate.getX() != map[0].length - 1) {
                if (checkCoordinate(map[myCoordinate.getY() + 1][myCoordinate.getX() + 1], map)) {
                    arrayCoordinates.add(map[myCoordinate.getY() + 1][myCoordinate.getX() + 1]);
                }
            }
        }

        if (myCoordinate.getY() != map.length - 1) { // diagonalDownLeft
            if (myCoordinate.getX() != 0) {
                if (checkCoordinate(map[myCoordinate.getY() + 1][myCoordinate.getX() - 1], map)) {
                    arrayCoordinates.add(map[myCoordinate.getY() + 1][myCoordinate.getX() - 1]);
                }
            }
        }

        if (myCoordinate.getY() != 0) { // diagonalUpRight
            if (myCoordinate.getX() != map[0].length - 1) {
                if (checkCoordinate(map[myCoordinate.getY() - 1][myCoordinate.getX() + 1], map)) {
                    arrayCoordinates.add(map[myCoordinate.getY() - 1][myCoordinate.getX() + 1]);
                }
            }
        }

        if (myCoordinate.getY() != 0) { // diagonalUpLeft
            if (myCoordinate.getX() != 0) {
                if (checkCoordinate(map[myCoordinate.getY() - 1][myCoordinate.getX() - 1], map)) {
                    arrayCoordinates.add(map[myCoordinate.getY() - 1][myCoordinate.getX() - 1]);
                }
            }
        }
        return arrayCoordinates;
    }

    private boolean checkCoordinate(Coordinate newCoordinate, Coordinate[][] map) {

        if (newCoordinate.isNoPassage()) {
            return false;
        }
        if (!newCoordinate.isNewCoordinate()) {
            return false;
        }
        if (newCoordinate.getX() < 0 || newCoordinate.getY() < 0) {
            return false;
        }
        if (newCoordinate.getX() > map[0].length - 1 || newCoordinate.getY() > map.length - 1) {
            return false;
        }
        return true;
    }
}
