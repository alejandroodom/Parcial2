package org.example;

import java.awt.*;

public class BattleShip extends Ship{
    private final int size = 5;
    private boolean[] hits = new boolean[size];


    public BattleShip(Point startPoint, Point endPoint) {
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
