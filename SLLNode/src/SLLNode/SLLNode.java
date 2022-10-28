package SLLNode;

public class SLLNode<E>{
    protected E element;
    protected SLLNode succ;

    public SLLNode(E element, SLLNode succ) {
        this.element = element;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return "SLLNode{" +
                "data=" + element +
                ", successor=" + succ +
                '}';
    }
}
