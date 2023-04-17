package org.example;


import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos los tableros de ambos jugadores
        int[][] tablero1 = new int[10][10];
        int[][] tablero2 = new int[10][10];
        int numBarcos;
        List<Ship> ships1 = new ArrayList<>();
        List<Ship> ships2 = new ArrayList<>();

        System.out.println("\n\t\t\tDa comienzo la partida");
        // Pedimos la configuración de los barcos para el jugador 1
        System.out.println("Jugador 1, introduce la configuración de tus barcos:");
        for (int i = 0; i < tablero1.length; i++) {
            for (int j = 0; j < tablero1.length; j++) {
                tablero1[i][j] = 0;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Introduce el número de barcos que quieres colocar (Máximo 3): ");
        numBarcos = scanner.nextInt();
        int numero = numBarcos;
        System.out.printf("%d Barcos\n", numBarcos);
        do {


            if(numBarcos == 3) {
                System.out.printf("Barco %d\n", (numero - 2));
            }
            if(numBarcos == 2) {
                System.out.printf("Barco %d\n", (numero - 1));
            }
            if(numBarcos == 1) {
                System.out.printf("Barco %d\n", numero);
            }

            System.out.println("Elige el tipo de barco[Canoa(1), Fragata(3), Acorazado(5)]: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Canoa");
                    System.out.println("Introduce las coordenadas X e Y: ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.print("Coordenada X: " + x + "\n");
                    System.out.print("Coordenada Y: " + y + "\n");
                    Point a = new Point(x, y);
                    Point b = new Point(x, y);
                    Canoe canoe = new Canoe(a, b);

                    if (tablero1[x][y] != 0) {
                        System.out.println("No puedes colocar un barco en esa posición.");
                    } else {
                        ships1.add(canoe);
                        tablero1[x][y] = 1;
                        System.out.println("Canoa colocada");
                    }
                    numBarcos--;
                    break;
                case 3:
                    System.out.println("Fragata");
                    System.out.println("Introduce las coordenadas X e Y (punto inicial): ");
                    int f = scanner.nextInt();
                    int g = scanner.nextInt();
                    System.out.print("Coordenada X: " + f + "\n");
                    System.out.print("Coordenada Y: " + g + "\n");
                    System.out.println("Introduce las coordenadas X e Y (punto final): ");
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    System.out.print("Coordenada X: " + u + "\n");
                    System.out.print("Coordenada Y: " + v + "\n");
                    Point c = new Point(f, g);
                    Point d = new Point(u, v);
                    if (f != u && g != v) {
                        System.out.println("Los puntos no están en la misma fila o columna.");
                        return;
                    }
                    if (Math.abs(f - u) < 2 && Math.abs(g - v) < 2) {
                        System.out.println("La distancia entre los puntos es menor que 3.");
                        return;
                    }
                    if (tablero1[f][g] != 0) {
                        System.out.println("No puedes colocar un barco en esa posición.");
                    } else {
                        if (f == u) { // Colocar horizontalmente
                            int fila = f;
                            int columnaInicial = Math.min(g, v);
                            for (int j = columnaInicial; j <= columnaInicial + 2; j++) {
                                tablero1[fila][j] = 3;
                            }
                        } else { // Colocar verticalmente
                            int columna = g;
                            int filaInicial = Math.min(f, u);
                            for (int i = filaInicial; i <= filaInicial + 2; i++) {
                                tablero1[i][columna] = 3;
                            }
                        }
                        Frigate frigate = new Frigate(c, d);
                        ships1.add(frigate);
                        System.out.println("Fragata colocada");
                    }
                    numBarcos--;
                    break;
                case 5:
                    System.out.println("Acorazado");
                    System.out.println("Introduce las coordenadas X e Y (punto inicial): ");
                    int h = scanner.nextInt();
                    int n = scanner.nextInt();
                    System.out.print("Coordenada X: " + h + "\n");
                    System.out.print("Coordenada Y: " + n + "\n");
                    System.out.println("Introduce las coordenadas X e Y (punto final): ");
                    int h2 = scanner.nextInt();
                    int n2 = scanner.nextInt();
                    System.out.print("Coordenada X: " + h2 + "\n");
                    System.out.print("Coordenada Y: " + n2 + "\n");
                    Point t = new Point(h, n);
                    Point r = new Point(h2, n2);
                    if (h != h2 && n != n2) {
                        System.out.println("Los puntos no están en la misma fila o columna.");
                        return;
                    }
                    if (Math.abs(h - h2) < 4 && Math.abs(n - n2) < 4) {
                        System.out.println("La distancia entre los puntos es menor que 5.");
                        return;
                    }
                    if (tablero1[h][n] != 0) {
                        System.out.println("No puedes colocar un barco en esa posición.");
                    } else {
                        if (h == h2) { // Colocar horizontalmente
                            int fila = h;
                            int columnaInicial = Math.min(n, n2);
                            for (int j = columnaInicial; j <= columnaInicial + 4; j++) {
                                tablero1[fila][j] = 5;
                            }
                        } else { // Colocar verticalmente
                            int columna = n;
                            int filaInicial = Math.min(h, h2);
                            for (int i = filaInicial; i <= filaInicial + 4; i++) {
                                tablero1[i][columna] = 5;
                            }
                        }
                        BattleShip battleship = new BattleShip(t, r);
                        ships1.add(battleship);
                        System.out.println("Acorazadp colocado");
                    }
                    numBarcos--;
                    break;
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(tablero1[i][j] + " ");
                }
                System.out.println();
            }
        } while (numBarcos > 0);
    }
}

        /* Pedimos la configuración de los barcos para el jugador 2
        System.out.println("Jugador 2, introduce la configuración de tus barcos:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Barco %d:\n", i+1);
            int x, y;
            do {
                System.out.print("Coordenada X: ");
                x = scanner.nextInt();
                System.out.print("Coordenada Y: ");
                y = scanner.nextInt();
            } while (!colocarBarco(tablero2, x, y));
        }

        // Comienza el juego
        int jugadorActual = 1;
        while (true) {
            // Turno del jugador actual
            System.out.printf("Jugador %d, es tu turno.\n", jugadorActual);
            boolean[][] tableroAtaque, tableroDefensa;
            if (jugadorActual == 1) {
                tableroAtaque = tablero2;
                tableroDefensa = tablero1;
            } else {
                tableroAtaque = tablero1;
                tableroDefensa = tablero2;
            }
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (!atacar(tableroAtaque, x, y));
            System.out.printf("Has atacado la posición (%d,%d)\n", x, y);
            if (todosHundidos(tableroDefensa)) {
                System.out.printf("¡El jugador %d ha ganado!\n", jugadorActual);
                break;
            }

            // Cambio de jugador
            if (jugadorActual == 1) {
                jugadorActual = 2;
            } else {
                jugadorActual = 1;
            }
        }

        scanner.close();
    }

    public static boolean colocarBarco(boolean[][] tablero, int x, int y) {
        if (x < 0 || x >= 10 || y < 0 || y >= 10 || tablero[x][y]) {
            return false;
        }
        tablero[x][y] = true;
        return true;
    }

    public static boolean atacar(boolean[][] tablero, int x, int y) {
        if (x < 0 || x >= 10 || */
