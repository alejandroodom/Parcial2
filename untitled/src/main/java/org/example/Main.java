package org.example;

import java.util.Scanner;
import java.awt.*;
public class Main {

    public static void main(String[] args) {
        Ship ship1 = new Ship(new Point(1, 1), new Point(1, 3));
        Ship ship2 = new Ship(new Point(2, 1), new Point(2, 3));
        Ship ship3 = new Ship(new Point(3, 1), new Point(3, 3));
        Ship ship4 = new Ship(new Point(1, 1), new Point(1, 3));
        Ship ship5 = new Ship(new Point(2, 1), new Point(2, 3));
        Ship ship6 = new Ship(new Point(3, 1), new Point(3, 3));

        User user1 = new User(ship1, ship2, ship3);
        User user2 = new User(ship4, ship5, ship6);
        //No hay main en el enunciado, no se como probar el programa
        }
}