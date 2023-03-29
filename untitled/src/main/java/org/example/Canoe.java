package org.example;
import java.awt.*;

public class Canoe extends Ship{
    private final int size = 1;
    private boolean[] hits = new boolean[size];

    public Canoe(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    public boolean isSunk() {
        for (boolean hit : hits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    public void hit(int position) {
        if (position >= 0 && position < size) {
            hits[position] = true;
        }
    }
}
