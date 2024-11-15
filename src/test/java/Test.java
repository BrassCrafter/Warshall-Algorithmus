import de.tillmannrohlfing.GraphToAdjazenzmatrix;
import de.tillmannrohlfing.GraphToWeightMatrix;
import utils.datenstrukturklassen.algorithms.ListAlgorithms;
import utils.datenstrukturklassen.graph.Edge;
import utils.datenstrukturklassen.graph.Graph;
import utils.datenstrukturklassen.graph.Vertex;
import utils.datenstrukturklassen.linear.List;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        for(char i = 65; i < 72; i++){
            graph.addVertex(new Vertex("" + i));
        }
        Vertex[] vertices = Test.listToArray(graph.getVertices());
        if(null == vertices)return;
        graph.addEdge(new Edge(vertices[0], vertices[1], 13));
        graph.addEdge(new Edge(vertices[1], vertices[3], 36));
        graph.addEdge(new Edge(vertices[1], vertices[5], 54));
        graph.addEdge(new Edge(vertices[1], vertices[4], 2));
        graph.addEdge(new Edge(vertices[2], vertices[4], 7));
        graph.addEdge(new Edge(vertices[3], vertices[4], 10));
        graph.addEdge(new Edge(vertices[4], vertices[5], 10));
        graph.addEdge(new Edge(vertices[5], vertices[2], 10));

        //Adjazenzmatrix

        GraphToAdjazenzmatrix graphToAdj = new GraphToAdjazenzmatrix(graph);
        graphToAdj.printMatrix();
        graphToAdj.printWarshallMatrix();

        //Weight Matrix

        GraphToWeightMatrix graphToWeight = new GraphToWeightMatrix(graph);
        graphToWeight.printMatrix();
        graphToWeight.printWarshallMatrix();
    }
    public static Vertex[] listToArray(List<Vertex> list){
        if(list.isEmpty()) return null;
        int length = ListAlgorithms.getLength(list);
        Vertex[] array = new Vertex[length];
        list.toFirst();
        for(int i = 0; i < length; i++){
            array[i] = list.getContent();
            list.next();
        }
        return array;
    }
}
