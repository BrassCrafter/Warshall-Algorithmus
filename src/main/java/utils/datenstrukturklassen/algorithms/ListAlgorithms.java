package utils.datenstrukturklassen.algorithms;

import utils.datenstrukturklassen.graph.Vertex;
import utils.datenstrukturklassen.linear.List;

public class ListAlgorithms {
    public static <T> int getLength(List<T> list){
        int length = 0;
        for(list.toFirst(); list.hasAccess(); list.next()){
            length++;
        }
        return length;
    }
    public static Vertex[] ListToArray(List<Vertex> list){
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
