import java.util.Scanner;

class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }

    public void setElement(E element) {
        this.element = element;
    }
}

class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
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

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if(after==last){
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if(before == first){
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(DLLNode<E> node) {
        if(node==first){
            deleteFirst();
            return node.element;
        }
        if(node==last){
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            ret += tmp + " ";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                if(tmp != last)
                    ret += tmp + " ";
                else
                    ret += tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp + "<->";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }
}
/*
Дадена е двојно поврзана лсита со n јазли кои содржат природни броеви. Треба да ја модифицирате листата така што новата вредност на првиот елемент да е еднаква на
сумата од вредноста на последниот јазел во листата и тековната вредност на првиот елемент, а после него да се вметне јазел во листата со поголемата вредност од вредноста
на последниот јазел и вредноста на првиот; понатаму новата вредност на вториот јазел да е еднаква на сумата од вредноста на претпоследниот јазел во листата и вредноста на
вториот јазел во листата, а после него да се вметне јазел во листата со поголемата вредност од вредноста на претпоследниот и вториот јазел. Оваа модификација да се направи
се до средината на листата. Ако n е непарен број, тогаш да не се менува вредноста на средниот јазел во листата.
*/


public class Main {
    public static void main(String[] args) {
        DLL<Integer> numbers = new DLL<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < parts.length; i++) {
            numbers.insertLast(Integer.parseInt(parts[i]));
        }
        DLLNode<Integer> left = numbers.getFirst();
        DLLNode<Integer> right = numbers.getLast();
        int iterations = numbers.length() / 2;
        for (int i = 0; i<iterations; i++) {
            int leftValue = left.element;
            left.setElement(left.element + right.element);
            numbers.insertAfter(Math.max(leftValue, right.element), left);
            left = left.succ.succ;
            right = right.pred;
        }

        System.out.println(numbers.toString());
    }
}