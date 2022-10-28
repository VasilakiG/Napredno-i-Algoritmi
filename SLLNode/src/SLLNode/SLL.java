package SLLNode;

public class SLL<E> {
    private SLLNode<E> firstNode; //prviot anchor node se chuva tuka

    public SLL() {
        this.firstNode = null; //pochetniot node ni e null deka e single linked list
        //vaka se kreira prazna lista
    }

    //metodi definirani od teorija

    public void insertFirst(E dataNaNov){
        SLLNode<E> nov = new SLLNode<E>(dataNaNov, null); //sozdavame nov jazol so vnesenata data i sledbenik null
        nov.succ = firstNode; //na noviot sledbenik mu e prviot node shto go chuvame vo klasata
        firstNode = nov; //anchor shto pokazhuva kon noviot jazol

    }
    public void insertAfter(E dataNaNov, SLLNode <E> afterMe){ //after e posle koj node sakame da dodademe
        if(afterMe != null) { //proveruvame dali jazolot posle koj treba da se dodade e null
            SLLNode<E> nov = new SLLNode<E>(dataNaNov, afterMe.succ);
            //znachi sledbenikot na noviot node e sledbenikot shto bil na after node-ot za da se dodade tochno izmegju
            afterMe.succ = nov;
        }
        else{
            System.out.println("Dadeniot jazol e null");
        }
    }
    public void insertBefore(E dataNaNov, SLLNode <E> beforeMe){
        if(firstNode != null){
            SLLNode<E> temp = firstNode;
            if(firstNode == beforeMe){
                insertFirst(dataNaNov);
                return;
            }
            //ako first != before togash mora da go najdeme
            while (temp.succ != null && temp.succ != beforeMe)
                temp = temp.succ;
            if(temp.succ == beforeMe){ //sme go nashle elementot pred koj sakame da vmetneme
                temp.succ = new SLLNode<E>(dataNaNov, beforeMe); //toj element sega stanuva noviot jazol(za da ima ist pprethodnik kako stariot jazol)a negov sledbenik e before me
            }else{
                System.out.println("Elementot ne postoi vo listata");
            }
        }
        else{ //ako first node e ednakov na nula znachi listata e prazna
            System.out.println("Listata e PRAZNA");
        }
    }
    public E deleteFirst(){
        // A-first B C
        if(firstNode != null){
            SLLNode <E> temp = firstNode; //temp = A
            firstNode = temp.succ; // prebrishi A i stavi B kako prvo
            return  temp.element; //kazhi koj se izbrishalo
        }
        else{
            System.out.println("Listata e prazna");
            return null;
        }
    }
    public E delete(SLLNode <E> nodeToDel){
        if(firstNode != null){
            SLLNode<E> temp = firstNode;
            if(firstNode == nodeToDel){
                return this.deleteFirst();
            }
            while(temp.succ != null && temp.succ != nodeToDel){
                temp = temp.succ;
            }
            if(temp.succ == nodeToDel){
                temp.succ = temp.succ.succ;
                return nodeToDel.element;
            }
            else{
                System.out.println("Elementot ne postoi vo listata i ne e pronajden!!!");
                return null;
            }
        }
        else {
            System.out.println("Listata ni e prazna");
            return null;
        }
    }

    public SLLNode<E> getFirstNode() {
        return firstNode;
    }
}
