package org.example;

import java.awt.*;
import java.util.List;

public class User {
    //Atributos
    private List<Ship> ships;
    private boolean isAlive;

    //Constructor
    public User(List<Ship> ships) {
        if (ships == null || ships.isEmpty() || ships.size() > 3) {
            throw new IllegalArgumentException("Invalid ship list");
        }
        this.ships = ships;
        this.isAlive = true;
    }

    public User(Ship ship, Ship ship1, Ship ship2) {

    }

    //Getter de ships
    public List<Ship> getShips() {
        return ships;
    }

    //Métodos de clase
    public boolean attack(Point shotPoint, User user) throws IllegalArgumentException {
        if (!isValidShot(shotPoint)) {
            throw new IllegalArgumentException("Invalid shot point");
        }
        boolean hit = false;
        for (Ship ship : user.getShips()) {
            if (ship.getShot(shotPoint)) {
                hit = true;
                if (ship.isSunk()) {
                    user.getShips().remove(ship);
                }
                break;
            }
        }
        return hit;
    }

    public boolean getShot(Point shotPoint) {
        for (Ship ship : ships) {
            if (ship.getShot(shotPoint)) {
                if (ship.isSunk()) {
                    ships.remove(ship);

                    if (ships.isEmpty()) {
                        die();
                    }
                }
                return true;
            }
        }
        return false;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }

    private boolean isValidShot(Point shotPoint) {
        return shotPoint.getX() >= 0 && shotPoint.getX() <= 9 && shotPoint.getY() >= 0 && shotPoint.getY() <= 9;
    }
}
