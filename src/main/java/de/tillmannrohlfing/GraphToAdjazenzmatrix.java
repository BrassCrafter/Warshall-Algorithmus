package de.tillmannrohlfing;

import utils.datenstrukturklassen.algorithms.ListAlgorithms;
import utils.datenstrukturklassen.graph.Graph;
import utils.datenstrukturklassen.graph.Vertex;
import utils.datenstrukturklassen.linear.List;

import java.util.Objects;

public class GraphToAdjazenzmatrix {
    Graph graph;
    Vertex[] vertices;
    boolean [][] matrix, warshallMatrix;
    public GraphToAdjazenzmatrix(Graph graph){
        this.graph = graph;
        vertices = ListAlgorithms.ListToArray(graph.getVertices());
        if(null == vertices){return;}
        matrix = new boolean[vertices.length][vertices.length];

        for(int i = 0; i < vertices.length; i++){
            List<Vertex> neighbour = graph.getNeighbours(vertices[i]);
            mergeSortOnList(neighbour);
            drawMatrix(i, neighbour);
        }
    }

    private void drawMatrix(int i, List<Vertex> neighbours){
        if(neighbours.isEmpty()) return;

        //Debugging
        System.out.println("Neighbours of " + vertices[i].getID() + ": ");
        printList(neighbours);

        neighbours.toFirst();
        for(int j = 0; j < vertices.length; j++){
            if(vertices[j].getID().equals(neighbours.getContent().getID())){
                matrix[i][j] = true;
                neighbours.next();
            }
            if(!neighbours.hasAccess()){
                return;
            }
        }
    }
    public boolean[][] getMatrix(){
        return matrix;
    }
    public void printMatrix(){
        System.out.print("  | ");
        for(int j = 0; j < vertices.length; j++){
            System.out.print(vertices[j].getID() + " | ");
        }
        System.out.println();
        for(int i = 0; i < vertices.length; i++){
            StringBuilder line = new StringBuilder();
            line.append(vertices[i].getID());
            for(int j = 0; j < vertices.length; j++){
                line.append(" | ").append(matrix[i][j]);
            }
            line.append(" |");
            System.out.println(line.toString());
        }
    }
    public void printWarshallMatrix(){
        warshallMatrix = WarshallAlgorithm.calculate(matrix);
        System.out.print("  | ");
        for(int j = 0; j < vertices.length; j++){
            System.out.print(vertices[j].getID() + " | ");
        }
        System.out.println();
        for(int i = 0; i < vertices.length; i++){
            StringBuilder line = new StringBuilder();
            line.append(vertices[i].getID());
            for(int j = 0; j < vertices.length; j++){
                line.append(" | ").append(warshallMatrix[i][j]);
            }
            line.append(" |");
            System.out.println(line.toString());
        }
    }
    private void printList(List<Vertex> list){
        StringBuilder line = new StringBuilder();
        for(list.toFirst(); list.hasAccess(); list.next()){
            line.append(list.getContent().getID()).append("; ");
        }
        System.out.println(line.toString());
    }
    public static void mergeSortOnList(List<Vertex> pList){
        List<Vertex> leftList = new List<Vertex>();
        List<Vertex> rightList = new List<Vertex>();
        pList.toFirst();
        while(!pList.isEmpty()){
            leftList.append(pList.getContent());
            pList.remove();
            if(!pList.isEmpty()){
                rightList.append(pList.getContent());
                pList.remove();
            }
        }
        if(ListAlgorithms.getLength(leftList) > 1)mergeSortOnList(leftList);
        if(ListAlgorithms.getLength(rightList) > 1)mergeSortOnList(rightList);
        mergeLists(leftList, rightList, pList);
    }
    private static void mergeLists(List<Vertex> pLeftList, List<Vertex> pRightList, List<Vertex> pList){
        pLeftList.toFirst();
        pRightList.toFirst();
        while(!pLeftList.isEmpty() && !pRightList.isEmpty()){
            if((pLeftList.getContent().getID().compareTo(pRightList.getContent().getID()) < 0) ){
                pList.append(pLeftList.getContent());
                pLeftList.remove();
            }else{
                pList.append(pRightList.getContent());
                pRightList.remove();
            }
        }
        while(!pLeftList.isEmpty()){
            pList.append(pLeftList.getContent());
            pLeftList.remove();
        }
        while(!pRightList.isEmpty()){
            pList.append(pRightList.getContent());
            pRightList.remove();
        }
    }
}
