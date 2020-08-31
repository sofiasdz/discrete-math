package tp1;

import graph.EdgeArrayGraphImpl;
import graph.Graph;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

// TODO: implement
public class Tp1Impl<T> implements Tp1<T> {
    @Override
    public void exercise_a(Graph<T> graph) {
        System.out.println(graph);
    }

    @Override
    public int exercise_b(Graph<T> graph) {
        int result = 0;
        List<T> vertexes = graph.getVertexes();
        for (int i = 0; i < vertexes.size(); i++) {
            List<T> adjacents = graph.getAdjacencyList(vertexes.get(i));
            for (int j = 0; j <adjacents.size() ; j++) {
                if(adjacents.get(j).equals(vertexes.get(i))) result++;
            }
        }
        return result;
    }

    @Override
    public List<T> exercise_c(Graph<T> graph) {
        List<T> result= new ArrayList<>();
        List<T> vertexes = graph.getVertexes();
        for (int i = 0; i < vertexes.size(); i++) {
            List<T> adjacents = graph.getAdjacencyList(vertexes.get(i));
            for (int j = 0; j <adjacents.size() ; j++) {
                if(adjacents.get(j).equals(vertexes.get(i))) {
                    result.add(vertexes.get(i));
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean exercise_d(Graph<T> graph, T vertex) {
        List<T> adjacents = graph.getAdjacencyList(vertex);
        return (adjacents.size()==0);
    } //True if vertex is isolated

    @Override
    public int exercise_e(Graph<T> graph) {
        List<T> vertexes = graph.getVertexes();
        int result=0;
        for (int i = 0; i < vertexes.size(); i++) {
            if(exercise_d(graph,vertexes.get(i))) result++;
        }
        return result;
    }

    @Override
    public List<T> exercise_f(Graph<T> graph) {
        List<T> vertexes = graph.getVertexes();
        List<T> isolatedVertexes = new ArrayList<>();
        for (int i = 0; i < vertexes.size(); i++) {
            if(exercise_d(graph,vertexes.get(i))) isolatedVertexes.add(vertexes.get(i));
        }
        return isolatedVertexes;
    }

    @Override
    public Graph<T> exercise_g(Graph<T> graph) {
        //Si ya tiene 0 lazos y 0 aislados lo retornamos tal cual esta
        if(exercise_b(graph)==0 && exercise_e(graph)==0) return graph;

        //Como debemos mantener la integridad del grafo recibido
        //debemos recrearlo adaptandolo a las condiciones
        //Caso contrario, sería tan facil como borrar vertices aislados
        //y lazos del grafo que recibimos como argumento.
        Graph<T> result = new EdgeArrayGraphImpl<>();

        if (exercise_b(graph)==0){
            //Si tiene 0 lazos, solo debemos recrearlo sin los vertices aislados
            List<T> vertexes = graph.getVertexes();
            //Nos quedamos con los vertices no aislados
            for (int i = 0; i <vertexes.size() ; i++) {
                if(!exercise_d(graph,vertexes.get(i))) result.addVertex(vertexes.get(i));
            }
            vertexes=result.getVertexes();
            //Tomamos ahora todas las aristas de dichos vertices para el nuevo grafo
            for (int i = 0; i <vertexes.size() ; i++) {
                List<T> adjacency = graph.getAdjacencyList(vertexes.get(i));
                for (int j = 0; j < adjacency.size(); j++) {
                        result.addEdge(vertexes.get(i),adjacency.get(j));
                }
            }
            return result;
        }
        else {
            //Si tiene 0 aislados, solo debemos recrearlo sin los lazos
            List<T> vertexes = graph.getVertexes();
            for (int i = 0; i < vertexes.size(); i++) {
                result.addVertex(vertexes.get(i));
            }
            //Tomamos ahora todas las aristas de dichos vertices para el nuevo grafo
            for (int i = 0; i < vertexes.size(); i++) {
                List<T> adjacency = graph.getAdjacencyList(vertexes.get(i));
                for (int j = 0; j < adjacency.size(); j++) {
                    if (adjacency.get(j).equals(vertexes.get(i))) continue; //Omitimos los lazos
                    result.addEdge(vertexes.get(i), adjacency.get(j));
                }
            }
            return result;
        }
    }

    @Override
    public int[][] exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int[][] exercise_i(Graph<T> graph) {
        List<Edge<T>> edges = getEdgeList(graph);
        List<T> vertexes = graph.getVertexes();
        int[][] result = new int[graph.order()][edges.size()];
        for (int i = 0; i <graph.order() ; i++) {
            List<T> adjacents = graph.getAdjacencyList(vertexes.get(i));
            for (int j = 0; j <adjacents.size(); j++) {
                Edge<T> edgeToCheck = new Edge<>(vertexes.get(i),adjacents.get(j));
                result[i][edges.indexOf(edgeToCheck)] = 1;
            }
            for (int j = 0; j < edges.size(); j++) {
                if(result[i][j]!=1) result[i][j] = 0;
            }
        }
        return result;
    }

    private List<Edge<T>> getEdgeList(Graph<T> graph){
        List<T> vertexes = graph.getVertexes();
        List<Edge<T>> result = new ArrayList<>();
        for (int i = 0; i < vertexes.size(); i++) {
            List<T> adjacents = graph.getAdjacencyList(vertexes.get(i));
            for (int j = 0; j < adjacents.size(); j++) {
                Edge<T> edgeToCheck = new Edge<>(vertexes.get(i), adjacents.get(j));
                if(!result.contains(edgeToCheck)){
                    result.add(edgeToCheck);
                }
            }
        }
        return result;
    }

    private class Edge<T>{
        T first;
        T second;

        private Edge(T first, T second){
            this.first=first;
            this.second=second;
        }

        @Override
        public boolean equals(Object obj) {
            return this.equals((Edge<T>) obj);
        }

        public boolean equals(Edge<T> o) {
            if (this.first.equals(o.first)  && this.second.equals(o.second)) return true;
            if (this.first.equals(o.second) && this.second.equals(o.first)) return true;
            return false;
        }

        public String toString(){
            return ("{"+first.toString()+", "+second.toString()+"}");
        }
    }
}
