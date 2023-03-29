package org.example;

import java.awt.*;

public class Ship {
    //Atributos
    private Point startPoint;
    private Point endPoint;
    private int size;
    private CardinalPoints direction;
    private int hits;

    //Constructor
    public Ship(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        if (!isStraightLine()) {
            throw new IllegalArgumentException("Invalid ship placement: Not a straight line");
        }
        this.size = calculateSize();
        this.direction = calculateDirection();
        this.hits = 0;
    }

    //Getters y Setters
    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public int getSize() {
        return size;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public int getHits() {
        return hits;
    }

    public boolean isSunk() {
        return hits == size;
    }

    //Métodos de clase
    public boolean getShot(Point shotPoint) {
        if (isHorizontal()) {
            if (shotPoint.getX() < startPoint.getX() || shotPoint.getX() > endPoint.getX()) {
                return false;
            }
        } else {
            if (shotPoint.getY() < startPoint.getY() || shotPoint.getY() > endPoint.getY()) {
                return false;
            }
        }
        hits++;
        return true;
    }

    private boolean isStraightLine() {
        return startPoint.getX() == endPoint.getX() || startPoint.getY() == endPoint.getY();
    }

    private int calculateSize() {
        if (isHorizontal()) {
            return (int) (Math.abs(endPoint.getX() - startPoint.getX()) + 1);
        } else {
            return (int) (Math.abs(endPoint.getY() - startPoint.getY()) + 1);
        }
    }

    private CardinalPoints calculateDirection() {
        if (isHorizontal()) {
            return endPoint.getX() > startPoint.getX() ? CardinalPoints.EAST : CardinalPoints.WEST;
        } else {
            return endPoint.getY() > startPoint.getY() ? CardinalPoints.SOUTH : CardinalPoints.NORTH;
        }
    }

    private boolean isHorizontal() {
        return startPoint.getY() == endPoint.getY();
    }
}
