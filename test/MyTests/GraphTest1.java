package MyTests;

import graph.AdjacencyListGraphImpl;
import graph.EdgeArrayGraphImpl;
import graph.Graph;
import org.junit.Test;
import tp1.Tp1;
import tp1.Tp1Impl;

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

    @Test
    public void test_003() {
        AdjacencyListGraphImpl graph=new AdjacencyListGraphImpl<String>();
        Tp1Impl tp1=new Tp1Impl<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 6);
        graph.addEdge(3, 6);
        System.out.println(tp1.matrixToString(tp1.exercise_i(graph)));
       /* {1,0,0,0,0,0,0,0},
        {1,1,1,0,0,0,0,0},
        {0,1,0,1,1,0,0,1},
        {0,0,1,1,0,1,1,0},
        {0,0,0,0,1,1,0,0},
        {0,0,0,0,0,0,1,1}*/


    }


    @Test
    public void test_004() {
        AdjacencyListGraphImpl graph1=new AdjacencyListGraphImpl<String>();
        Tp1Impl tp1=new Tp1Impl<>();
        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);

        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 1);

        EdgeArrayGraphImpl graph2=new EdgeArrayGraphImpl();
        graph2.addVertex(1);
        graph2.addVertex(2);
        graph2.addVertex(3);

        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 1);

        System.out.println((tp1.matrixToString(tp1.exercise_i(graph2))));
        System.out.println(tp1.matrixToString(tp1.exercise_i(graph1)));



    }

}
