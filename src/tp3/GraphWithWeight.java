package tp3;

import java.util.List;

public interface GraphWithWeight<T> {

        void addVertex(T x);
        void removeVertex(T x);
        boolean hasVertex(T v);
        List<T> getVertexes();

        void addEdge(T v, T w,int weight);
        void removeEdge(T v, T w);
        boolean hasEdge(T v, T w);
        int getWeight(T v,T w);

        int order();
        int alpha();

        List<T> getAdjacencyList(T v);
        static int INFINITE=999999999;
}
