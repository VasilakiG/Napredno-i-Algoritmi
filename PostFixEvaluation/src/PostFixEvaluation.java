//
// Да се напише алгоритам кој ќе врши евалуација на израз во постфикс нотација.
//
//На влез се чита низа од знаци за изразот (стринг), а на излез се печати вредноста на изразот по евалуацијата.
//
//Име на класата (Java): PostFixEvaluation
//
//  For example:
//
//  Input                   Output
//  1 2 +                   3
//
//  60 80 * 20 40 * /       6
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PostFixEvaluation {

    static int evaluatePostfix(char [] izraz, int n) {
        ArrayStack<Integer> sum = new ArrayStack<Integer>(n);
        int number1 = 0;
        int number2 = 0;
        int result = 0;
        int pushNumber = 0;

        for (int i = 0; i < n; i++) {
            if(izraz[i] != ' '){

                if(izraz[i] >= '0' && izraz[i] <= '9') {
                    pushNumber = pushNumber * 10 + (izraz[i] - '0');
                }
            }
            if(izraz[i] == ' ' ){
                sum.push(pushNumber);
                pushNumber = 0;
            }

            if(izraz[i] == '+'){
                number1 = sum.pop();
                number2 = sum.pop();
                result = number2 + number1;
                sum.push(result);
                i++;
                continue;
            }
            if(izraz[i] == '-'){
                number1 = sum.pop();
                number2 = sum.pop();
                result = number2 - number1;
                sum.push(result);
                i++;
                continue;
            }
            if(izraz[i] == '*'){
                number1 = sum.pop();
                number2 = sum.pop();
                result = number2 * number1;
                sum.push(result);
                i++;
                continue;
            }
            if(izraz[i] == '/'){
                number1 = sum.pop();
                number2 = sum.pop();
                if(number1 != 0  || number2 == 0){
                    result = number2 / number1;
                    sum.push(result);
                    i++;
                    continue;
                }
            }
        }

        return sum.pop();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }

}