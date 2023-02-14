import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.List;
import java.util.Scanner;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

//    public Iterator<E> iterator () {
//        // Return an iterator that visits all elements of this list, in left-to-right order.
//        return new LRIterator<E>();
//    }

    // //////////Inner class ////////////

//    private class LRIterator<E> implements Iterator<E> {
//
//        private SLLNode<E> place, curr;
//
//        private LRIterator() {
//            place = (SLLNode<E>) first;
//            curr = null;
//        }
//
//        public boolean hasNext() {
//            return (place != null);
//        }
//
//        public E next() {
//            if (place == null)
//                throw new NoSuchElementException();
//            E nextElem = place.element;
//            curr = place;
//            place = place.succ;
//            return nextElem;
//        }
//
//        public void remove() {
//            //Not implemented
//        }
//    }
//
//    public void mirror(){
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            SLLNode<E> tmp = first;
//            SLLNode<E> newsucc = null;
//            SLLNode<E> next;
//
//            while(tmp != null){
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }

//    }

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public SLLNode<E> findMiddle() {
        SLLNode<E> slowPtr = first;
        SLLNode<E> fastPtr = first.succ;

        while (fastPtr != null) {
            fastPtr = fastPtr.succ;
            if (fastPtr != null) {
                fastPtr = fastPtr.succ;
                slowPtr = slowPtr.succ;
            }
        }
        return slowPtr;
    }
}

public class Main {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String line;
        String[] parts = new String[N];

        SLL<Integer> list = new SLL<>();

        line = sc.nextLine();
        parts = line.split(" ");

        for (int i = 0; i < parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        N = Integer.parseInt(sc.nextLine());

        SLLNode<Integer> middle = list.getFirst();
        SLLNode<Integer> middle1 = list.getFirst();
        SLLNode<Integer> middle2 = middle1.succ;
        SLLNode<Integer> fastPointer = list.getFirst();

        while (N > 0) {
            if (list.length() % 2 == 1) {
                middle = list.getFirst();
                fastPointer = list.getFirst();
                while (fastPointer.succ != null) {
                    middle = middle.succ;
                    fastPointer = fastPointer.succ.succ;
                }

                list.delete(middle);
                N--;
            } else {
                middle1 = list.getFirst().succ;
                middle2 = middle1.succ;
                while (fastPointer.succ != null) {
                    middle1 = middle1.succ;
                    middle2 = middle1.succ;
                    fastPointer = fastPointer.succ.succ;
                }


                if (middle2.element < middle1.element) {
                    list.delete(middle2);
                } else {
                    list.delete(middle1);
                }
                N--;
            }
        }
        System.out.println(list.toString());
        */


        Scanner sc = new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        SLL<Integer> numbers = new SLL<>();

        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(sc.nextLine());
            numbers.insertLast(num);
        }

        int M = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < M; i++) {
            int length = numbers.length();
            int index = numbers.length() / 2;
            SLLNode<Integer> node = numbers.getFirst();

            for (int j = 1; j < index; j++) {
                node = node.succ;
            }
            if(length%2 == 1) {
                if (node.succ == null){
                    numbers.delete(node);
                }else{
                    node = node.succ;
                    numbers.delete(node);
                }
            }
            else {
                if(node.succ.element < node.element) numbers.delete(node.succ);
                else numbers.delete(node);
            }

        }
        System.out.println(numbers.toString());
    }
}
