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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme(Rabotnik r) {
        return ime;
    }

    public RabotnaNedela getNedela(int brNedela) {
        return nedeli[brNedela];
    }
}

public class Main {

    public static int sumNedeli(Rabotnik r){

        int vkupnoCasovi = 0;

        for (int i = 0; i < 4; i++) {
            vkupnoCasovi += r.getNedela(i).sumEdnaNedela();
        }

        return vkupnoCasovi;
    }

    public static Rabotnik najvreden_rabotnik(Rabotnik [] niza) {

        int maxSum = sumNedeli(niza[0]);
        int maxIndex = 0;

        for (int i = 0; i < niza.length; i++) {

            if ( sumNedeli(niza[i]) > maxSum ){

                maxSum = sumNedeli(niza[i]);
                maxIndex = i;
            }
        }

        return niza[maxIndex];
    }
    public static void table(Rabotnik [] niza) {

        System.out.println("Rab   1   2   3   4   Vkupno");

        for (int i = 0; i < niza.length; i++) {
            System.out.print(niza[i].getIme(niza[i])+ "   ");

            for (int j = 0; j < 4; j++) {
                System.out.print(niza[i].getNedela(j).sumEdnaNedela() + "   ");
            }
            System.out.println(sumNedeli(niza[i]));
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
            String ime = input.next();

            RabotnaNedela[] rabNedela = new RabotnaNedela[4];
            for (int j = 0;j<4;j++) {

                int [] casovi = new int[5];

                for (int k = 0;k<5;k++) {
                    int cas = input.nextInt();
                    casovi[k] = cas;
                }

                RabotnaNedela rabotnaNedela = new RabotnaNedela(casovi, j+1);
                rabNedela[j]=rabotnaNedela;
            }

            niza[i] = new Rabotnik(ime, rabNedela);

        }

        table(niza);
        System.out.println();
        Rabotnik r = najvreden_rabotnik(niza);
        System.out.println("NAJVREDEN RABOTNIK: " +r.getIme(r));

    }
}

