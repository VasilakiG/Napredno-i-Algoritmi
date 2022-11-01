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

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        //SLLNode<E> ins = new SLLNode<E>(o, first);
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
            if(first==before){
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ!=null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);;
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
            tmp.succ = new SLLNode<E>(o, null);
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
            if(first == node) {
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
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void merge (SLL<E> in){
        if (first != null) {
            SLLNode<E> tmp = first;
            while(tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        }
        else{
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            //m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }
}

public class SpecialSLLJoin<E> {

    //todo: implement function

//    SLL <E> newMerged = new SLL<>();
//    SLLNode<E> temp1 = list1.getFirst();
//    SLLNode<E> temp2 = list2.getFirst();
//        while (temp1 != null || temp2 != null) {
//
//        //za prva lista
//        if(temp1 != null){
//            newMerged.insertFirst((E)temp1.element);
//            if (temp1.succ != null) {
//                newMerged.insertFirst((E)temp1.succ.element);
//                list1.deleteFirst();
//                temp1 = temp1.succ;
//            }
//            list1.deleteFirst();
//            temp1 = temp1.succ;
//        }
//
//
//        //za vtora lista
//        if(temp2 != null){
//            newMerged.insertFirst((E)temp2.element);
//            if (temp2.succ != null) {
//                newMerged.insertFirst((E)temp2.succ.element);
//                list2.deleteFirst();
//                temp2 = temp2.succ;
//            }
//            list2.deleteFirst();
//            temp2 = temp2.succ;
//        }
//
//    }
//        newMerged.mirror();
//        return newMerged;
    public SLL<E> specialJoin(SLL<E> list1, SLL<E> list2) {
        int size = 0;

        SLL<E> result = new SLL<>();
        SLLNode<E> resultNode = new SLLNode<>(list1.getFirst().element, null);
        result.insertFirst(resultNode.element);
        SLLNode<E> tmp1 = new SLLNode<>(list1.getFirst().element, list1.getFirst().succ);
        SLLNode<E> tmp2 = new SLLNode<>(list2.getFirst().element, list2.getFirst().succ);


        while (tmp1 != null || tmp2 !=null){
            if((tmp1!= null) && (size % 4 == 0 || size % 4 == 1)){

                if(size == 0) {
                    result.insertAfter(tmp1.element, result.getFirst());
                }
                if(tmp1.succ != null){
                    result.insertAfter(tmp1.succ.element, tmp1);
                    tmp1 = tmp1.succ;
                    size++;
                }
                tmp1 = tmp1.succ;
                size++;
            }
            if((tmp2!= null) && (size % 4 == 2 || size % 4 == 3)){
                result.insertAfter(tmp2.element, tmp1.succ);
                if(tmp2.succ != null){
                    result.insertAfter(tmp2.succ.element, tmp2);
                    tmp2 = tmp2.succ;
                    size++;
                }
                tmp2 = tmp2.succ;
                size++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list1 = new SLL<>();
        for(int i=0;i<n;i++) {
            list1.insertLast(input.nextInt());
        }

        n = input.nextInt();

        SLL<Integer> list2 = new SLL<>();
        for(int i=0;i<n;i++) {
            list2.insertLast(input.nextInt());
        }

        SpecialSLLJoin<Integer> tmp = new SpecialSLLJoin<>();

        System.out.println(tmp.specialJoin(list1, list2));
    }

}