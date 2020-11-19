package tp3;

public interface Tp3<T> {
     DijkstraResult<T> dijkstra(GraphWithWeight<T> graphWithWeight,T startingPoint);

}
