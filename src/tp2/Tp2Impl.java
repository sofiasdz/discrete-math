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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public int exercise_e(Graph<T> graph, T v, T w) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public List<T> exercise_f(Graph<T> graph,T v, T w) {
        throw new UnsupportedOperationException("TODO");
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
    public boolean exercise_j(Graph<T> g1, Graph<T> g2) {
        throw new UnsupportedOperationException("TODO");
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
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Map<T, Integer> exercise_n(Graph<T> graph) {
        throw new UnsupportedOperationException("TODO");
    }

}
