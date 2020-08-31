package graph.factory;

import java.util.ArrayList;
import java.util.List;

public class Element<T> {
    T data;
    List<Integer> connectedTo;

    public Element(T data, List<Integer> connectedTo) {
        this.data = data;
        this.connectedTo = connectedTo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Integer> getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(List<Integer> connectedTo) {
        this.connectedTo = connectedTo;
    }
}
