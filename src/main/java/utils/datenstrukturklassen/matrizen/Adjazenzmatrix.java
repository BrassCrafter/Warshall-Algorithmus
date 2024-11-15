package utils.datenstrukturklassen.matrizen;

import utils.datenstrukturklassen.algorithms.ListAlgorithms;
import utils.datenstrukturklassen.graph.Graph;
import utils.datenstrukturklassen.graph.Vertex;
import utils.datenstrukturklassen.linear.List;

import java.util.Objects;

public class Adjazenzmatrix {
    int[][] matrix;
    public Adjazenzmatrix(Graph graph) {
        List<Vertex> vertices = graph.getVertices();
        int length = ListAlgorithms.getLength(vertices);
        matrix = new int[length][length];

    }
    public void addToAdjMatrix(int i, List<Vertex> neighbours, List<Vertex> vertices) {
        if(neighbours.isEmpty())
            return;
        neighbours.toFirst();
        int j = 0;
        for(vertices.toFirst(); vertices.hasAccess() && neighbours.hasAccess(); vertices.next()) {
            if(Objects.equals(neighbours.getContent().getID(), vertices.getContent().getID())){
                matrix[i][j] = 1;
            }
            else{
                matrix[i][j] = 0;
            }
            j++;
            neighbours.next();
        }
    }
}
