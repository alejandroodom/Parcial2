package org.example;

import java.util.*;

public class BarcosHash {
    private HashMap<String, HashMap<Integer, Barco>> tipoBarcos;

    public BarcosHash() {
        tipoBarcos = new HashMap<String, HashMap<Integer, Barco>>();
    }

    private int hashTipoBarco(String tipo) {
        return Math.abs(tipo.hashCode() % tipoBarcos.size());
    }

    private int hashNumeroBarco(int numero) {
        return Math.abs(numero % 15);
    }

    private int hashNombreBarco(String nombre) {
        return Math.abs(nombre.hashCode() % 15);
    }

    public void agregarBarco(int numero, String nombre, String tipo, int nivel) {
        HashMap<Integer, Barco> tablaDeTipo = tipoBarcos.get(tipo);

        if (tablaDeTipo == null) {
            tablaDeTipo = new HashMap<Integer, Barco>();
            tipoBarcos.put(tipo, tablaDeTipo);
        }
    }

    public Barco buscarBarco(int numero) {
        for (HashMap<Integer, Barco> tablaDeTipo : tipoBarcos.values()) {
            Barco barco = tablaDeTipo.get(numero);
            if (barco != null) {
                return barco;
            }
        }
        return null;
    }

    public Barco buscarBarco(String nombre) {
        for (HashMap<Integer, Barco> tablaDeTipo : tipoBarcos.values()) {
            for (Barco barco : tablaDeTipo.values()) {
                if (barco.getNombre().equals(nombre)) {
                    return barco;
                }
            }
        }
        return null;
    }

}



