package org.example;

import java.util.Scanner;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of ships: ");
        int numberOfShips = scanner.nextInt();
        Ship[] ships = new Ship[numberOfShips];
        for (int i = 0; i < numberOfShips; i++) {
            System.out.println("Enter the type of ship: ");
            String typeOfShip = scanner.next();
            System.out.println("Enter the start point: ");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            System.out.println("Enter the end point: ");
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            Point startPoint = new Point(x1, y1);
            Point endPoint = new Point(x2, y2);
            switch (typeOfShip) {
                case "Canoe":
                    ships[i] = new Canoe(startPoint, endPoint);
                    break;
                case "Frigate":
                    ships[i] = new Frigate(startPoint, endPoint);
                    break;
                case "BattleShip":
                    ships[i] = new BattleShip(startPoint, endPoint);
                    break;
            }
        }
        System.out.println("Enter the number of shots: ");
        int numberOfShots = scanner.nextInt();
        for (int i = 0; i < numberOfShots; i++) {
            System.out.println("Enter the shot point: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point shotPoint = new Point(x, y);
            for (Ship ship : ships) {
                ship.getShot(shotPoint);
            }
        }
        for (Ship ship : ships) {
            if (ship.isSunk()) {
                System.out.println("Ship is sunk");
            } else {
                System.out.println("Ship is not sunk");
            }
        }
    }
}