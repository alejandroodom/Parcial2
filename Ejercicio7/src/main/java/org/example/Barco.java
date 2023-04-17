package org.example;

public class Barco {
    private int numero;
    private String nombre;
    private String tipo;
    private int nivel;

    public Barco(int numero, String nombre, String tipo, int nivel) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
