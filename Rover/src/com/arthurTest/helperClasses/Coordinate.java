package com.arthurTest.helperClasses;

public class Coordinate {
    private int x;
    private int y;
    private int level;
    private boolean newCoordinate = true;
    private boolean isNoPassage = false;

    public Coordinate(int y, int x, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public boolean isNoPassage() {
        return isNoPassage;
    }
    public void setNoPassage(boolean noPassage) {
        isNoPassage = noPassage;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public boolean isNewCoordinate() {
        return newCoordinate;
    }
    public void setNewCoordinate(boolean newCoordinate) {
        this.newCoordinate = newCoordinate;
    }
    @Override
    public String toString() {
        return "y = " + y + ", x = " + x + ", level = " + level + ", newCoordinate = "
            + newCoordinate;
    }
}
