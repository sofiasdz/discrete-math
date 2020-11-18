package tp3;

public class DNode<T> {
    final private int T;
    final private int weight;

    public DNode(int t, int weight) {
        T = t;
        this.weight = weight;
    }

    public int getT() {
        return T;
    }

    public int getWeight() {
        return weight;
    }
}
