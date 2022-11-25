import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;

interface Stack<E> {
    public boolean isEmpty();
    public E peek();
    public void clear();
    public void push(E x);
    public E pop();
    public int len();
}

interface Queue<E> {
    public boolean isEmpty();
    public int size();
    public E peek();
    public void clear();
    public void enqueue(E x);
    public E dequeue();
    public int len();
}

class ArrayQueue<E> implements Queue<E> {
    E[] elems;
    int length, front, rear;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public int len() {
        return elems.length;
    }

    public E peek() {
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear() {
        length = 0;
        front = rear = 0;
    }

    public void enqueue(E x) {
        elems[rear++] = x;
        if (rear == elems.length)
            rear = 0;
        length++;
    }

    public E dequeue() {
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)
                front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

class ArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        return (depth == 0);
    }

    public E peek() {
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        for (int i = 0; i < depth; i++)
            elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        elems[depth++] = x;
    }

    public E pop() {
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }

    public int len() {
        return elems.length;
    }
}

public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka
        Queue<Integer> shpil = new ArrayQueue<Integer>(51);
        Stack<Integer> sedumKarti = new ArrayStack<Integer>(7);

        int meshanja = 0;

        for (int i = 0; i < shpil.len(); i++) {
            shpil.enqueue(i+1);
        }

        while(N != shpil.peek()){
            for (int i = 0; i < sedumKarti.len(); i++) {
                sedumKarti.push(shpil.dequeue());
            }

            while(!sedumKarti.isEmpty()){
                shpil.enqueue(sedumKarti.pop());
                shpil.enqueue(shpil.dequeue());
            }
            meshanja++;
        }

        return meshanja;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}


//          ============BLOOPERS============
//
//      int brKarti = 1;
//      int meshanja = 0;
//      int sedumKarti = 0;
//
//      LinkedList<Integer> shpil = new LinkedList<Integer>();
//
//      while(brKarti != 52){
//          shpil.add(brKarti);
//              brKarti++;
//      }
//
//      for (int i = sedumKarti; i < 7; i++) {
//
//      }
//