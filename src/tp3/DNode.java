package tp3;

public class DNode<T> {
    private final T t;
    private int weight;

    public DNode( T t, int weight) {
        this.t = t;
        this.weight = weight;
    }

    public T getT() {
        return t;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
