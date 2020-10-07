package graph;

import graph.factory.Element;
import graph.factory.ElementAndIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: implement
public class AdjacencyListGraphImpl<T> implements Graph<T> {
    Element<T>[] elements;
    int n;
    int alpha;

    public AdjacencyListGraphImpl() {
        this.elements = new Element[50];
        this.n = 0;
        this.alpha = 0;
    }

    @Override
    public void addVertex(T x) {
       if(!this.hasVertex(x)) {
           Element<T> elem = new Element<T>(x, new ArrayList<>());
           if (n == elements.length) {
               elements = Arrays.copyOf(elements, 2*n );
           }
           elements[n] = elem;
           n++;
       }
    }

    @Override
    public boolean hasVertex(T v){
        if(n==0) return false;
        for (int i = 0; i < n; i++) {
            if(elements[i].getData().equals(v)) return true;
        }
        return false;
    }

    @Override
    public void removeVertex(T x) {
        List<T> adyacencyList=getAdjacencyList(x);
        for (int i = 0; i < adyacencyList.size(); i++) {
            removeEdge(x,adyacencyList.get(i));
        }
        Element<T>[] newElements;

        n=n-1;
    }

    @Override
    public void addEdge(T v, T w) {
         if(!(!this.hasVertex(v)||!this.hasVertex(w))&&!this.hasEdge(v,w)){
             if(v.equals(w)){
                 ElementAndIndex<T> vElem=getElementAndIndex(v);
                 vElem.getElement().getConnectedTo().add(vElem.getIndex());
             }
           else  { ElementAndIndex<T> vElem=getElementAndIndex(v);
        ElementAndIndex<T> wElem=getElementAndIndex(w);
        vElem.getElement().getConnectedTo().add(wElem.getIndex());
        wElem.getElement().getConnectedTo().add(vElem.getIndex());
        }
         alpha++;
         }
    }

    @Override
    public void removeEdge(T v, T w) {
        if(!(!this.hasVertex(v)||!this.hasVertex(w))) {
            ElementAndIndex<T> vElem = getElementAndIndex(v);
            ElementAndIndex<T> wElem = getElementAndIndex(w);
            List connV=vElem.getElement().getConnectedTo();
            connV.remove((connV.indexOf(wElem.getIndex())));
            List connW=wElem.getElement().getConnectedTo();
            connW.remove((connW.indexOf(vElem.getIndex())));
            alpha--;
        }

    }

    @Override
    public boolean hasEdge(T v, T w) {
        if(!this.hasVertex(v)||!this.hasVertex(w)) return false;
        ElementAndIndex<T> vElem=getElementAndIndex(v);
        ElementAndIndex<T> wElem=getElementAndIndex(w);
         if(vElem.getElement().getConnectedTo().contains(wElem.getIndex()) &&
        wElem.getElement().getConnectedTo().contains(vElem.getIndex())){
             return true;
         }
         return false;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int alpha() {
        if(n==0) return 0;
        return alpha;
    }

    @Override
    public List<T> getVertexes() {
        if(n==0) return new ArrayList<>();
        List rta=new ArrayList<>(n);
        for (int i = 0; i <n; i++) {
            rta.add(elements[i].getData());
        }
        return rta;
    }

    @Override
    public List<T> getAdjacencyList(T v) {
        List<Integer> indexes=getAdjacencyIndexList(v);
        List<T> rta=new ArrayList<>();
        for (int i = 0; i < indexes.size() ; i++) {
            rta.add(elements[indexes.get(i)].getData());
        }
        return rta;

    }

    private ElementAndIndex<T> getElementAndIndex(T x){
        for (int i = 0; i < n; i++) {
            if(elements[i].getData().equals(x)) return new ElementAndIndex<T>(i,elements[i]);
        }
        return null;
    }

    public List<Integer> getAdjacencyIndexList(T v){
        for (int i = 0; i < n ; i++) {
            if(elements[i].getData().equals(v)) return elements[i].getConnectedTo();
        }
    return new ArrayList<>();
    }

    public String toString(){
        if(n==0) return "V={} A={}";
        String v= "V={";
        String a= "A={";
        List<T> vertexes= this.getVertexes();
        for (int i = 0; i <vertexes.size() ; i++) {
            v=v+vertexes.get(i)+",";
            List adyacencyList=this.getAdjacencyList(vertexes.get(i));
            for (int j = 0; j < adyacencyList.size(); j++) {
                a = a + "(" + vertexes.get(i) + "," + adyacencyList.get(j)+");";
            }

        }
        v=v+"}";
        a=a+"}";

        return v+" "+a;
    }


}
