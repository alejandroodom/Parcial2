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

        // Creamos las listas de barcos de ambos jugadores
        int numBarcos;
        List<Ship> ships1 = new ArrayList<>();
        List<Ship> ships2 = new ArrayList<>();

        ships1.add(new Frigate(new Point(0, 0), new Point(0, 2)));
        ships2.add(new Frigate(new Point(0, 0), new Point(0, 2)));

        // Creamos los usuarios
        User user1 = new User(ships1);
        User user2 = new User(ships2);

        boolean salir = false;

        do {
            // Comienza el juego
            System.out.println("\n\t\t\tDa comienzo la partida");
            System.out.println("\t\t\t\t¡A colocar!");
            // Pedimos la configuración de los barcos para el jugador 1
            System.out.println("Jugador 1, introduce la configuración de tus barcos:\n");
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
            System.out.println("\nIntroduce el número de barcos que quieres colocar (Máximo 3): ");
            numBarcos = scanner.nextInt();
            int numero = numBarcos;
            System.out.printf("%d Barcos\n", numBarcos);
            do {


                if (numBarcos == 3) {
                    System.out.printf("Barco %d\n", (numero - 2));
                }
                if (numBarcos == 2) {
                    System.out.printf("Barco %d\n", (numero - 1));
                }
                if (numBarcos == 1) {
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
                            System.out.println("Acorazado colocado");
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

            // Pedimos la configuración de los barcos para el jugador 2
            System.out.println("Jugador 2, introduce la configuración de tus barcos:\n");
            for (int i = 0; i < tablero2.length; i++) {
                for (int j = 0; j < tablero2.length; j++) {
                    tablero2[i][j] = 0;
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(tablero2[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("\nIntroduce el número de barcos que quieres colocar (Máximo 3): ");
            numBarcos = scanner.nextInt();
            numero = numBarcos;
            System.out.printf("%d Barcos\n", numBarcos);
            do {


                if (numBarcos == 3) {
                    System.out.printf("Barco %d\n", (numero - 2));
                }
                if (numBarcos == 2) {
                    System.out.printf("Barco %d\n", (numero - 1));
                }
                if (numBarcos == 1) {
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

                        if (tablero2[x][y] != 0) {
                            System.out.println("No puedes colocar un barco en esa posición.");
                        } else {
                            ships2.add(canoe);
                            tablero2[x][y] = 1;
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
                        if (tablero2[f][g] != 0) {
                            System.out.println("No puedes colocar un barco en esa posición.");
                        } else {
                            if (f == u) { // Colocar horizontalmente
                                int fila = f;
                                int columnaInicial = Math.min(g, v);
                                for (int j = columnaInicial; j <= columnaInicial + 2; j++) {
                                    tablero2[fila][j] = 3;
                                }
                            } else { // Colocar verticalmente
                                int columna = g;
                                int filaInicial = Math.min(f, u);
                                for (int i = filaInicial; i <= filaInicial + 2; i++) {
                                    tablero2[i][columna] = 3;
                                }
                            }
                            Frigate frigate = new Frigate(c, d);
                            ships2.add(frigate);
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
                        if (tablero2[h][n] != 0) {
                            System.out.println("No puedes colocar un barco en esa posición.");
                        } else {
                            if (h == h2) { // Colocar horizontalmente
                                int fila = h;
                                int columnaInicial = Math.min(n, n2);
                                for (int j = columnaInicial; j <= columnaInicial + 4; j++) {
                                    tablero2[fila][j] = 5;
                                }
                            } else { // Colocar verticalmente
                                int columna = n;
                                int filaInicial = Math.min(h, h2);
                                for (int i = filaInicial; i <= filaInicial + 4; i++) {
                                    tablero2[i][columna] = 5;
                                }
                            }
                            BattleShip battleship = new BattleShip(t, r);
                            ships2.add(battleship);
                            System.out.println("Acorazado colocado");
                        }
                        numBarcos--;
                        break;
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero2[i][j] + " ");
                    }
                    System.out.println();
                }
            } while (numBarcos > 0);

            System.out.println("\n\t\t\t¡Comienza el juego!");
            System.out.println("\t\t\t Es hora de atacar");
            do{
                System.out.println("Jugador 1, introduce las coordenadas X e Y del punto que quieras tocar: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point p = new Point(x, y);
                int shots = 0;
                user1.attack(p, user2);
                if (tablero2[x][y] == 0) {
                    System.out.println("Agua");
                } else if(tablero2[x][y] != 0 && ships2.get(tablero2[x][y]).getSize() == 1 && ships2.get(tablero2[x][y]).getShot(p)){
                    System.out.println("Tocado y hundido");
                    ships2.remove(tablero2[x][y]);
                }else if(tablero2[x][y] != 0 && ships2.get(tablero2[x][y]).getSize() == 3 && ships2.get(tablero2[x][y]).getShot(p)){
                    System.out.println("Tocado");
                    for(int i = 0; i < ships2.get(tablero2[x][y]).getSize(); i++){
                        if(ships2.get(tablero2[x][y]).equals(p)){
                            shots++;
                        }
                    }
                    if(shots == 3) {
                        System.out.println("Hundido");
                        ships2.get(tablero2[x][y]).isSunk();
                        ships2.remove(tablero2[x][y]);
                    }
                } else if (tablero2[x][y] != 0 && ships2.get(tablero2[x][y]).getSize() == 5 && ships2.get(tablero2[x][y]).getShot(p)){
                    System.out.println("Tocado");
                    for(int i = 0; i < ships2.get(tablero2[x][y]).getSize(); i++){
                        if(ships2.get(tablero2[x][y]).equals(p)){
                            shots++;
                        }
                    }
                    if(shots == 5) {
                        System.out.println("Hundido");
                        ships2.get(tablero2[x][y]).isSunk();
                        ships2.remove(tablero2[x][y]);
                    }
                }

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero2[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Jugador 2, introduce las coordenadas X e Y del punto que quieras tocar: ");
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                Point p2 = new Point(x2, y2);
                int shots2 = 0;
                user2.attack(p2, user1);
                if (tablero1[x2][y2] == 0) {
                    System.out.println("Agua");
                } else if(tablero1[x2][y2] != 0 && ships1.get(tablero1[x2][y2]).getSize() == 1 && ships1.get(tablero2[x2][y2]).getShot(p2)){
                    System.out.println("Tocado y hundido");
                    ships1.remove(tablero1[x2][y2]);
                }else if(tablero1[x2][y2] != 0 && ships1.get(tablero1[x2][y2]).getSize() == 3 && ships1.get(tablero2[x2][y2]).getShot(p2)){
                    System.out.println("Tocado");
                    for(int i = 0; i < ships1.get(tablero1[x2][y2]).getSize(); i++){
                        if(ships1.get(tablero1[x2][y2]).equals(p2)){
                            shots2++;
                        }
                    }
                    if(shots2 == 3) {
                        System.out.println("Hundido");
                        ships1.get(tablero1[x2][y2]).isSunk();
                        ships1.remove(tablero1[x2][y2]);
                    }
                } else if (tablero1[x2][y2] != 0 && ships1.get(tablero1[x2][y2]).getSize() == 5 && ships1.get(tablero2[x2][y2]).getShot(p2)){
                    System.out.println("Tocado");
                    for(int i = 0; i < ships1.get(tablero1[x2][y2]).getSize(); i++){
                        if(ships1.get(tablero1[x2][y2]).equals(p2)){
                            shots2++;
                        }
                    }
                    if(shots2 == 5) {
                        System.out.println("Hundido");
                        ships1.get(tablero1[x2][y2]).isSunk();
                        ships1.remove(tablero1[x2][y2]);
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(tablero1[i][j] + " ");
                    }
                    System.out.println();
                }

            } while (!ships1.isEmpty() || !ships2.isEmpty());
            if(ships1.isEmpty()){
                System.out.println("¡El jugador 2 ha ganado!");
            } else if(ships2.isEmpty()){
                System.out.println("¡El jugador 1 ha ganado!");
            } else if(ships1.isEmpty() && ships2.isEmpty()){
                System.out.println("¡Empate!");
            }
            salir = true;
        } while (salir == false);
        //Esto es todo el código, lo he hecho todo prácticamente a mano sin copilot ni chatgpt pero no me funciona del todo bien la parte de atacar barcos,
        // colocarlos en el tablero funciona perfectamente. No sé donde está el error, pero creo que tiene que ver con las listas de barcos,
        // te lo entrego así porque no se muy bien como hacer que funcione pero el código tiene sentido.

    }
}
