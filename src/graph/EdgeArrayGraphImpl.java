package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeArrayGraphImpl<T> implements Graph<T>{

    private class Edge<T>{
        T first;
        T second;

        private Edge(T first, T second){
            this.first=first;
            this.second=second;
        }

        public boolean equalsNonDirected(Edge<T> o) {
            if (this.first.equals(o.first)  && this.second.equals(o.second)) return true;
            if (this.first.equals(o.second) && this.second.equals(o.first)) return true;
            return false;
        }

        public boolean equalsDirected(Edge<T> o) {
            return (this.first.equals(o.first) && this.second.equals(o.second));
        }

        public String toString(){
            return ("{"+first.toString()+", "+second.toString()+"}");
        }
    }

    private T[] vertex;
    private int n;  //Amount of vertex
    private int a;  //Amount of edges
    private List<Edge<T>> edgeList;

    public EdgeArrayGraphImpl() {
        this.vertex  = (T[]) new Object[10];
        this.n = 0;
        this.a = 0;
        this.edgeList = new LinkedList<>();
    }

    @Override
    public void addVertex(T x) {
        if(n==vertex.length){
            T[] newVertex = (T[]) new Object[n*2];
            for (int i = 0; i <n ; i++) {
                newVertex[i]=vertex[i];
            }
            vertex=newVertex;
        }
        vertex[n] = x;
        n++;
    }

    @Override
    public boolean hasVertex(T v){
        for (int i = 0; i <n ; i++) {
            if(vertex[i].equals(v)) return true;
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        if(!this.hasVertex(x)) return;
        if(hasAnyEdge(x)) throw new RuntimeException("That vertex has edges!");
        int indexOfX = 0;
        for (int i = 0; i <n ; i++) {
            if(vertex[i].equals(x)) indexOfX = i;
        }
        vertex[indexOfX] = null;
        for (int i = indexOfX+1; i <n ; i++) {
            vertex[i-1]= vertex[i];
        }
        n--;
    }

    private boolean hasAnyEdge(T v){
        for (int i = 0; i < a ; i++) {
            if(edgeList.get(i).first.equals(v) || edgeList.get(i).second.equals(v)) return true;
        }
        return false;
    }

    @Override
    public void addEdge(T v, T w) {
        if(!hasVertex(v) || !hasVertex(w)) return;
        if(hasEdge(v,w)) return;
        edgeList.add(new Edge<>(v,w));
        a++;
    }

    @Override
    public void removeEdge(T v, T w) {
        if(hasEdge(v,w)) {
            Edge<T> edgeToRemove = new Edge<>(v,w);
            for (int i = 0; i <a ; i++) {
                if(edgeList.get(i).equalsNonDirected(edgeToRemove)) {
                    a--;
                    edgeList.remove(i);
                    return;
                }
            }
        }
    }

    @Override
    public boolean hasEdge(T v, T w) {
        if(a==0) return false;
        Edge<T> edgeToFind = new Edge<>(v,w);
        for (int i = 0; i <a ; i++) {
            if(edgeList.get(i).equalsNonDirected(edgeToFind)) return true;
        }
        return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int alpha() {
        return a;
    }

    @Override
    public List<T> getVertexes() {
        List<T> vertexList = new ArrayList<T>(n);
        for (int i = 0; i <n ; i++) {
            vertexList.add(vertex[i]);
        }
        return vertexList;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        if(!hasAnyEdge(v)) return new ArrayList<>();
        List<T> adjacencyList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            Edge<T> currentEdge = edgeList.get(i);
            if(currentEdge.first==currentEdge.second && currentEdge.first==v) {
                adjacencyList.add(v);
                continue;
            }
            if(currentEdge.first==v) adjacencyList.add(currentEdge.second);
            if(currentEdge.second==v) adjacencyList.add(currentEdge.first);
        }
        return adjacencyList;
    }

    public String toString(){
        String result = "V = {";
        for (int i = 0; i < n; i++) {
            result+=vertex[i].toString();
            if(i!=n-1) result+=", ";
        }
        result+="} A = {";
        for (int i = 0; i <a ; i++) {
            result+=edgeList.get(i).toString();
            if(i!=a-1) result+=", ";
        }
        result+="}";
        return result;
    }
}
