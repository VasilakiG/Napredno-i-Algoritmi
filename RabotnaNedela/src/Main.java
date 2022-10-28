import java.util.Scanner;

class RabotnaNedela {

    private int[] casovi;
    private int brNedela;

    public RabotnaNedela(int[] casovi, int brNedela) {
        super();
        this.casovi = casovi;
        this.brNedela = brNedela;
    }

    @Override
    public String toString() {
        return "";
    }
    public int sumEdnaNedela(){
        int sumCasovi = 0;

        for(int i = 0; i< 5;i++) {
            sumCasovi += casovi[i];
        }

            return sumCasovi;
    }
}

class Rabotnik{

    private String ime;

    private RabotnaNedela [] nedeli;

    public Rabotnik(String ime, RabotnaNedela[] nedeli) {
        super();
        this.ime = ime;
        this.nedeli = nedeli;
    }
    @Override
    public String toString() {
        return "";
    }

    public int vkupnoNedeli(Rabotnik r){

    }

    public String getIme(Rabotnik r) {
        return ime;
    }

}

public class Main {

    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza)
    {

    }
    public static void table(Rabotnik [] niza)
    {
        System.out.println("Rab   1   2   3   4   Vkupno");
        for (int i = 0; i < niza.length; i++) {
            System.out.println(niza[i].getIme()+ "   " ;
        }
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Rabotnik [] niza = new Rabotnik[n];
        for(int i=0;i<n;i++)
        {
            //vasiot kod tuka

        }

        table(niza);
        System.out.println("NAJVREDEN RABOTNIK: " +najvreden_rabotnik(niza).getIme());

    }
}

