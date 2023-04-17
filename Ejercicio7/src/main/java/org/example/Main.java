package org.example;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        BarcosHash algoritmo = new BarcosHash();

        // Agregar algunos barcos
        algoritmo.agregarBarco(123, "Barco 1", "Tipo 1", 5);
        algoritmo.agregarBarco(456, "Barco 2", "Tipo 2", 7);
        algoritmo.agregarBarco(789, "Barco 3", "Tipo 1", 9);
        algoritmo.agregarBarco(101, "Barco 4", "Tipo 3", 2);
        algoritmo.agregarBarco(112, "Barco 5", "Tipo 1", 4);
        algoritmo.agregarBarco(113, "Barco 6", "Tipo 2", 8);

        // Buscar un barco
        Barco barco = algoritmo.buscarBarco(456);
        if (barco != null) {
            System.out.println("Barco encontrado: " + barco.getNombre());
        } else {
            System.out.println("Barco no encontrado");
        }

        // Buscar un barco por nombre
        barco = algoritmo.buscarBarco("Barco 3");
        if (barco != null) {
            System.out.println("Barco encontrado: " + barco.getNombre());
        } else {
            System.out.println("Barco no encontrado");
        }
    }
}