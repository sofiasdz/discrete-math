package MyTests;

import graph.AdjacencyListGraphImpl;
import graph.Graph;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest1 {

    @Test
     public void test_001(){
        AdjacencyListGraphImpl graph=new AdjacencyListGraphImpl<String>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addEdge("a","b");
        System.out.println(graph.toString());


    }

    @Test
    public void test_002(){
        AdjacencyListGraphImpl graph=new AdjacencyListGraphImpl<String>();
        graph.addVertex(11);
        graph.addVertex(12);
        graph.addEdge(11, 12);
        System.out.println(graph.toString());
        graph.removeEdge(11, 12);
        System.out.println(graph.toString());


    }







}
