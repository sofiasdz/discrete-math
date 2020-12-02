package tp3;

import org.junit.Assert;
import tp3.EdgeArrayGraphImplPonderado;
import graph.EdgeArrayGraphImpl;
import org.junit.Test;
import tp1.Tp1Impl;

import static org.junit.Assert.*;

public class GraphTest {


    @Test
    public void test_001(){
        EdgeArrayGraphImplPonderado graph=new EdgeArrayGraphImplPonderado<String>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addEdge("a","b",20);
        graph.addEdge("a","c",40);
        assertTrue(graph.hasEdge("a","b"));
        assertFalse(graph.hasEdge("b","c"));
        assertTrue(graph.hasEdge("b","a"));
        Assert.assertEquals(graph.getWeight("a","b"),20);
    }

    @Test
    public void test_002(){
        EdgeArrayGraphImplPonderado graph=new EdgeArrayGraphImplPonderado<String>();
        graph.addVertex("Holi");
        graph.addVertex("Mundito");
        graph.addVertex("jeje");
        graph.addEdge("Holi","jeje",20);
        assertTrue(graph.hasAnyEdge("Holi"));
        graph.removeEdge("Holi","jeje");
        graph.removeVertex("jeje");
        assertFalse(graph.hasAnyEdge("Holi"));
    }

    @Test
    public void test_003() {
        EdgeArrayGraphImplPonderado graph=new EdgeArrayGraphImplPonderado<String>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(1, 2,10);
        graph.addEdge(2, 3,50);
        graph.addEdge(1, 4,30);
        graph.addEdge(3, 4,20);
        graph.addEdge(4, 5,60);
        graph.addEdge(5, 1,100);
        graph.addEdge(3, 5,10);

        Tp3Impl<Integer> impl = new Tp3Impl<Integer>();
        DijkstraResult<Integer> result = impl.dijkstra(graph,1);
        for (int i = 0; i < result.d.size(); i++) {
            System.out.println("weight for i: "+result.getD().get(i).getT()+" is: "+ result.getD().get(i).getWeight());
            System.out.println( "its previous is "+result.getPath().get(i).getPrevious());
        }
    }


    @Test
    public void test_004() {
        EdgeArrayGraphImplPonderado<String> graph1=new EdgeArrayGraphImplPonderado<String>();
        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("E");
        graph1.addVertex("F");

        graph1.addEdge("A", "B",4);
        graph1.addEdge("A", "C",2);
        graph1.addEdge("C", "B",1);
        graph1.addEdge("B", "E",7);
        graph1.addEdge("B", "D",5);
        graph1.addEdge("C", "E",10);
        graph1.addEdge("C", "D",8);
        graph1.addEdge("D", "E",2);
        graph1.addEdge("E", "F",3);
        graph1.addEdge("D", "F",6);

        Tp3Impl<String> impl = new Tp3Impl<String>();
        DijkstraResult<String> result = impl.dijkstra(graph1,"A");
        for (int i = 0; i < result.d.size(); i++) {
            System.out.println("weight for i: "+result.getD().get(i).getT()+" is: "+ result.getD().get(i).getWeight());
            System.out.println( "its previous is "+result.getPath().get(i).getPrevious());
        }
    }

}
