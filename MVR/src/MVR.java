import java.util.NoSuchElementException;
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
interface Queue<E> {

    // Elementi na redicata se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size ();
    // Ja vrakja dolzinata na redicata.

    public E peek ();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear ();
    // Ja prazni redicata.

    public void enqueue (E x);
    // Go dodava x na kraj od redicata.

    public E dequeue ();
    // Go otstranuva i vrakja pochetniot element na redicata.

}
class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

class Gragjanin{
    String name;
    public int personalID;
    public int passport;
    public int driversID;

    public Gragjanin(String name, int personalID, int passport, int driversID) {
        this.name = name;
        this.personalID = personalID;
        this.passport = passport;
        this.driversID = driversID;
    }

//    public String getName() {
//        return name;
//    }
//
//    public int getPersonalID() {
//        return personalID;
//    }
//
//    public void setPersonalID(int personalID) {
//        this.personalID = personalID;
//    }

    @Override
    public String toString() {
        return name;
    }
}

public class MVR {

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        int N = Integer.parseInt(br.nextLine());

        LinkedQueue<Gragjanin> l = new LinkedQueue<>();
        LinkedQueue<Gragjanin> p = new LinkedQueue<>();
        LinkedQueue<Gragjanin> v = new LinkedQueue<>();

        for(int i=1;i<=N;i++){
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime,lKarta,pasos,vozacka);

            if(covek.personalID == 1){
                l.enqueue(covek);
            }else if(covek.passport == 1){
                p.enqueue(covek);
            }else{
                v.enqueue(covek);
            }
        }

        while(!l.isEmpty()){
            Gragjanin tmp =  l.dequeue();
            if(tmp.passport == 1){
                p.enqueue(tmp);
            }else if(tmp.driversID == 1){
                v.enqueue(tmp);
            }else{
                System.out.println(tmp);
            }
        }

        while(!p.isEmpty()){
            Gragjanin tmp =  p.dequeue();
            if(tmp.driversID == 1){
                v.enqueue(tmp);
            }else{
                System.out.println(tmp);
            }
        }

        while(!v.isEmpty()){
            Gragjanin tmp =  v.dequeue();
            System.out.println(tmp);
        }
    }
}