package tp2;

import graph.Graph;

import java.util.*;

public class Tp2Impl<T> implements Tp2<T> {
    @Override
    public List<T> depth_first_search(Graph<T> graph) {
        List<T> dfs=new ArrayList<>();
        List<T> vertex=graph.getVertexes();
        Stack<T> stack= new Stack();
        stack.push(graph.getVertexes().get(0));
        while (!stack.isEmpty()){
            T v= stack.pop();
            if (!dfs.contains(v)) dfs.add(v);
            //procesar
            vertex.remove(v);
            List<T> adyacentes=graph.getAdjacencyList(v);
            for (int i = 0; i <adyacentes.size() ; i++) {
                if(vertex.contains(adyacentes.get(i))) {
                   stack.push(adyacentes.get(i));
                }
            }
        }
        return dfs;
    }

    @Override
    public List<T> breadth_first_search(Graph<T> graph) {

        List<T> dfs = new ArrayList<>();
        List<T> vertex = graph.getVertexes();
        Queue<T> queue = new LinkedList<>();
        queue.add(graph.getVertexes().get(0));
        while (!queue.isEmpty()) {
            T v = queue.poll();
            //procesar
            if (!dfs.contains(v)) dfs.add(v);
            vertex.remove(v);
            List<T> adyacentes = graph.getAdjacencyList(v);
            for (int i = 0; i < adyacentes.size(); i++) {
                if (vertex.contains(adyacentes.get(i))) {
                    queue.add(adyacentes.get(i));
                }
            }
        }
        return dfs;

    }

    @Override
    public boolean exercise_a(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_b(Graph<T> graph, T v) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_c(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }


    @Override
    public boolean exercise_d(Graph<T> graph) {
        //    d) Verificar si un grafo es conexo.
        List<T> dfs=new ArrayList<>();
        List<T> vertex=graph.getVertexes();
        Stack<T> stack= new Stack();
        List vertexes=graph.getVertexes();
        if(vertex.size()==0) return false;
        stack.push(vertex.get(0));
        while (!stack.isEmpty()){
            T v= stack.pop();
            if (!dfs.contains(v)) dfs.add(v);
            //procesar
            vertex.remove(v);
            List<T> adyacentes=graph.getAdjacencyList(v);
            for (int i = 0; i <adyacentes.size() ; i++) {
                if(vertex.contains(adyacentes.get(i))) {
                    stack.push(adyacentes.get(i));
                }

            }
        }
        if(vertex.isEmpty()) return true;
        return false;



    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        List<T> visited = new ArrayList<>();
        if( existsPath(graph, v, w, visited)){
            return visited;
        }
        return new ArrayList<>();
    }

    private boolean existsPath(Graph<T> g, T s, T t, List<T> visited) {
        if ((s == t)){
            visited.add(s);
            return true;
        }
        if(g.hasEdge(s,t)){
            if(!visited.contains(s)) visited.add(s);
            visited.add(t);
            return true;
        }
        List<T> lst; // lista de adyacentes
        visited.add(s);
        lst = g.getAdjacencyList(s);
        if (lst.isEmpty()) return false;
        for(int j =0 ; j < lst.size() ; j++){
            if (!visited.contains(lst.get(j)) && existsPath(g, lst.get(j), t, visited))
                return true;
        }
        return false;
    }

    @Override
    public List<T> exercise_g(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_h(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_i(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) { //Verifico que g2 sea recubridor de g1
        if(g1.order()!=g2.order()) return false;
        List<T> g1Vertexes = g1.getVertexes();
        List<T> g2Vertexes = g2.getVertexes();
        if(!g1Vertexes.containsAll(g2Vertexes)) return false;
        for (int i = 0; i <g2Vertexes.size() ; i++) {
            List<T> adyacencyList = g2.getAdjacencyList(g2Vertexes.get(i));
            for (int j = 0; j < adyacencyList.size(); j++) {
                if (!g1.hasEdge(g2Vertexes.get(i),adyacencyList.get(j))) return false;
            }
        }
    return true;
    }

    @Override
    public boolean exercise_k(Graph<T> g1) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Graph<T> exercise_l(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_m(Graph<T> graph, T v) {
        int result = 0;
        if (!graph.hasVertex(v)) throw new RuntimeException("v isn't part of the graph!");
        List<T> vertexes = graph.getAdjacencyList(v);
        for (int i = 0; i < vertexes.size(); i++) {
            if(graph.hasEdge(v,vertexes.get(i))){
                if(vertexes.get(i).equals(v)) result +=2;
                else result +=1;
            }
        }
        return result;
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}
