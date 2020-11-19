package tp3;

public class PNode<T> {
   private final T end;
   private T previous;

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

    public void setPrevious(T previous) {
        this.previous = previous;
    }
}
