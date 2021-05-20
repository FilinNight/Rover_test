package com.arthurTest.helperClasses;

public class Path {
    private int MaxSizeArr = 8;
    private Coordinate[] array = new Coordinate[MaxSizeArr];
    private int pointer = 0;

    public void add(Coordinate item) {
        if (pointer == MaxSizeArr) {
            MaxSizeArr *= 2;
            resize(MaxSizeArr);
        }
        array[pointer] = item;
        pointer++;
    }

    public Coordinate get(int index) {
        if (index < pointer) {
            return array[index];
        }
        return null;
    }

    public void removeLastItem() {
        if (pointer > 0) {
            Coordinate[] newCoordinats = new Coordinate[array.length];
            for (int i = 0; i < array.length - 1; i++) {
                newCoordinats[i] = array[i];
            }
            pointer--;
        }
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Coordinate[] TmpArray = new Coordinate[newLength];
        for (int i = 0; i < array.length; i++) {
            TmpArray[i] = array[i];
        }
        array = TmpArray;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < pointer; i++) {
            if (i != pointer - 1) {
                result += "[" + array[i].getY() + "][" + array[i].getX() + "]->";
            } else {
                result += "[" + array[i].getY() + "][" + array[i].getX() + "]";
            }
        }
        return result;
    }
}
