package org.example;

public class Main {
    public static void main(String[] args) {
        PuertoGraph puertoGraph = new PuertoGraph();

        // Agregar puertos
        puertoGraph.agregarPuerto("Madero");
        puertoGraph.agregarPuerto("Rodas");
        puertoGraph.agregarPuerto("Hamburgo");
        puertoGraph.agregarPuerto("Singapur");

        // Agregar conexiones
        puertoGraph.agregarConexion("Madero", "Rodas", 5000);
        puertoGraph.agregarConexion("Madero", "Hamburgo", 7000);
        puertoGraph.agregarConexion("Madero", "Singapur", 10000);
        puertoGraph.agregarConexion("Rodas", "Hamburgo", 3000);
        puertoGraph.agregarConexion("Rodas", "Singapur", 5000);
        puertoGraph.agregarConexion("Hamburgo", "Singapur", 2000);

        // Barrido en profundidad
        System.out.println("Barrido en profundidad:");
        puertoGraph.barridoEnProfundidad("Madero");

        // Camino más corto
        System.out.println("Camino más corto:");
        System.out.println(puertoGraph.caminoMasCorto("Madero", "Singapur"));

        // Eliminar puerto con más aristas
        System.out.println("Eliminar puerto con más aristas:");
        System.out.println(puertoGraph.eliminarPuertoConMasAristas());
    }
}