package tp3;

public class PNode<T> {
   private final T end;
   private final T previous;

    public PNode(T end, T previous) {
        this.end = end;
        this.previous = previous;
    }

    public T getEnd() {
        return end;
    }

    public T getPrevious() {
        return previous;
    }
}
