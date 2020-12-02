package tp3;

import java.util.ArrayList;
import java.util.List;

public class Tp3Impl<T> implements Tp3<T>{
    @Override
    public DijkstraResult<T> dijkstra(GraphWithWeight<T> graphWithWeight,T startingPoint) {
        //1er paso construyo el vector d, DNode contiene el vertice y el valor que cuesta ir del starting point a ese vertice
        List<DNode<T>> dVector= new ArrayList<>();
        int length=graphWithWeight.order();
        List<T> vertexes= graphWithWeight.getVertexes();
        for (int i = 0; i <length; i++) {
           DNode<T> dNode;
            if(vertexes.get(i).equals(startingPoint)){
                dNode=new DNode<T>(startingPoint,0);
            }
           else {
               // el Integer.MAX_VALUE va a contar como nuestro infinito, es decir lo que ponemos cuando no hay una arista directa desde startingPoint
                dNode = new DNode<T>(vertexes.get(i), graphWithWeight.getWeight(startingPoint, vertexes.get(i)));
            }
           dVector.add(dNode);
        }

        //2do paso creo el vector P(Path) al final va a contener los caminos de costo minimo pero ahora contiene solo el starting point
        List<PNode<T>> pVector= new ArrayList<>();// PNode contiene el vector al que voy y por el que tengo q pasar para llegar,
                                              // ahora el "previous" va a ser en todos los casos el starting point
        for (int i = 0; i <length ; i++) {
            PNode<T> pNode= new PNode<>(vertexes.get(i),startingPoint);
            pVector.add(pNode);
        }

        //3er lugar construimos el conjunto S que en este momento solo va a tener al startingPoint
        List<T> sVector= new ArrayList<>();
        sVector.add(startingPoint);
        // empieza el ciclo del algoritmo
        int step=0;
    while (step<length-2) {
        // mientras queden vertices que NO esten en sVector el algoritmo continua
        T w=searchForW(sVector,vertexes, dVector);
        sVector.add(w);
        //elegimos el vertice que no esta en sVector, cuyo weight en d sea el minimo, para ser nuestro w y lo agregamos  a sVector
        System.out.println(sVector.toString());
        for (int i = 0; i < length; i++) {
            //para todos los vertices comparamos que camino es menor, el que esta o el que pasa por w
            int currentWeight = dVector.get(i).getWeight();
            int potentialLowerWeight =getDValueOf(w,dVector)+ cost(w,dVector.get(i).getT(),graphWithWeight);
            if (potentialLowerWeight<currentWeight){
                dVector.get(i).setWeight(potentialLowerWeight);
                pVector.get(i).setPrevious(w);
            }
        }
        step++;
    }
    return new DijkstraResult<>(dVector,pVector);
    }



    boolean sContainsAllVertexes(List<T> sVector,List<T> vertexes){
        for (int i = 0; i <vertexes.size() ; i++) {
            if(!sVector.contains(vertexes.get(i))) return false;
        }
        return true;
    }

    T searchForW(List<T> sVector, List<T> vertexes, List<DNode<T>> dVector){
        DNode<T> min = new DNode<>((T)new Object(), Integer.MAX_VALUE);
        for (int i = 0; i < dVector.size(); i++) {
            if(dVector.get(i).getWeight()<min.getWeight() && !sVector.contains(dVector.get(i).getT())) min = dVector.get(i);
        }
        if(min.getWeight()!= Integer.MAX_VALUE) return min.getT();
        return null;
    }

    int getDValueOf(T vertex,List<DNode<T>> dVector){
        for (int i = 0; i <dVector.size() ; i++) {
            if(dVector.get(i).getT().equals(vertex)) return dVector.get(i).getWeight();

        }
        return -1;
    }

    int cost(T start,T end,GraphWithWeight<T> graphWithWeight){
        if (graphWithWeight.hasEdge(start,end)) return graphWithWeight.getWeight(start,end);
        return graphWithWeight.INFINITE;
    }
}
