package tp3;

import java.util.List;

public class DijkstraResult<T> {
    List<DNode<T>> d;
    List<PNode<T>> path;

    public List<DNode<T>> getD() {
        return d;
    }

    public void setD(List<DNode<T>> d) {
        this.d = d;
    }

    public List<PNode<T>> getPath() {
        return path;
    }

    public void setPath(List<PNode<T>> path) {
        this.path = path;
    }

    public DijkstraResult(List<DNode<T>> d, List<PNode<T>> path) {
        this.d = d;
        this.path = path;
    }
}
