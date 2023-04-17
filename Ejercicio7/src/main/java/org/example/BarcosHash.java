package org.example;

import java.util.*;

public class BarcosHash {

    // Declaración de las tres tablas hash
    private Map<String, Map<Integer, Map<String, Integer>>> tablaTipoBarco;
    private Map<Integer, Map<String, Integer>> tablaNumBarco;
    private Map<String, Map<String, Integer>> tablaNombreBarco;

    // Constructor de la clase
    public BarcosHash() {
        // Inicialización de las tres tablas hash
        tablaTipoBarco = new HashMap<String, Map<Integer, Map<String, Integer>>>();
        tablaNumBarco = new HashMap<Integer, Map<String, Integer>>();
        tablaNombreBarco = new HashMap<String, Map<String, Integer>>();
    }

    // Función hash para la primera tabla, basada en el tipo de barco
    private int hashTipo(String tipo) {
        return Math.abs(tipo.hashCode() % 10000);
    }

    // Función hash para la segunda tabla, basada en el número de barco
    private int hashNum(int num) {
        return Math.abs(num % 15);
    }

    // Función hash para la tercera tabla, basada en el nombre de barco
    private int hashNombre(String nombre) {
        return Math.abs(nombre.hashCode() % 15);
    }

    // Función de sondeo lineal para resolver colisiones
    private int sondeoLineal(int hash, int intento) {
        return (hash + intento) % 10000;
    }

    // Función para agregar un barco a las tres tablas hash
    public void agregarBarco(int num, String nombre, String tipo, int nivel) {
        // Agregar a la tabla hash por tipo de barco
        if (!tablaTipoBarco.containsKey(tipo)) {
            tablaTipoBarco.put(tipo, new HashMap<Integer, Map<String, Integer>>());
        }
        int hashTipo = hashTipo(tipo);
        int intentoTipo = 0;
        while (tablaTipoBarco.get(tipo).containsKey(hashTipo) &&
                tablaTipoBarco.get(tipo).get(hashTipo).containsKey(nombre)) {
            hashTipo = sondeoLineal(hashTipo, intentoTipo);
            intentoTipo++;
        }
        if (!tablaTipoBarco.get(tipo).containsKey(hashTipo)) {
            tablaTipoBarco.get(tipo).put(hashTipo, new HashMap<String, Integer>());
        }
        tablaTipoBarco.get(tipo).get(hashTipo).put(nombre, nivel);

        // Agregar a la tabla hash por número de barco
        int hashNum = hashNum(num);
        int intentoNum = 0;
        while (tablaNumBarco.containsKey(hashNum) && tablaNumBarco.get(hashNum).containsKey(nombre)) {
            hashNum = sondeoLineal(hashNum, intentoNum);
            intentoNum++;
        }
        if (!tablaNumBarco.containsKey(hashNum)) {
            tablaNumBarco.put(hashNum, new HashMap<String, Integer>());
        }
        tablaNumBarco.get(hashNum).put(nombre, nivel);

        // Agregar a la tabla hash por nombre de barco
        int hashNombre = hashNombre(nombre);
        int intentoNombre = 0;
        while (tablaNombreBarco.containsKey(nombre) && tablaNombreBarco.get(nombre).containsKey(hashNombre)) {
            hashNombre = sondeoLineal(hashNombre, intentoNombre);
            intentoNombre++;
        }
        if (!tablaNombreBarco.containsKey(hashNombre)) {
            tablaNombreBarco.put(nombre, new HashMap<String, Integer>());
        }
        tablaNombreBarco.get(nombre).put(tipo, nivel);
    }

    public void setTamanioTabla(int i) {
    }
}



