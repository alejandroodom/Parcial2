package org.example;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class PuertoGrafos {
    private Graph<String, DefaultEdge> graph;

    public PuertoGrafos() {
        graph = new SimpleGraph<>(DefaultEdge.class);
    }

    public void agregarPuerto(String puerto) {
        graph.addVertex(puerto);
    }

    public void agregarConexion(String puerto1, String puerto2, double distancia) {
        DefaultEdge edge = graph.addEdge(puerto1, puerto2);
        graph.setEdgeWeight(edge, distancia);
    }

    public void barridoEnProfundidad(String origen) {
        DepthFirstSearch<String, DefaultEdge> dfs = new DepthFirstSearch<>(graph);
        dfs.startVertex = origen;
        dfs.execute();
    }

    public GraphPath<String, DefaultEdge> caminoMasCorto(String origen, String destino) {
        DijkstraShortestPath<String, DefaultEdge> dijkstra = new DijkstraShortestPath<>(graph);
        return dijkstra.getPath(origen, destino);
    }

    public String eliminarPuertoConMasAristas() {
        int max = 0;
        String puertoMax = null;

        for (String puerto : graph.vertexSet()) {
            int grado = graph.degreeOf(puerto);
            if (grado > max) {
                max = grado;
                puertoMax = puerto;
            }
        }

        if (puertoMax != null) {
            graph.removeVertex(puertoMax);
        }

        return puertoMax;
    }
}
