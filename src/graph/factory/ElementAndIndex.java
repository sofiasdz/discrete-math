package graph.factory;

public class ElementAndIndex<T> {
    int index;
    Element<T> element;

    public ElementAndIndex(int index, Element<T> element) {
        this.index = index;
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Element<T> getElement() {
        return element;
    }

    public void setElement(Element<T> element) {
        this.element = element;
    }

    public  String toString(){
        return "Index="+index+" Elem="+element.getData()+"{"+element.getConnectedTo().toString()+"}";
    }
}
