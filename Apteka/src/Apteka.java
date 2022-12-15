import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Lek {

    String name;
    int positive, price, quantity;

    Lek(String name, int positive, int price, int quantity) {
        this.name = name.toUpperCase();
        this.positive = positive;
        this.price = price;
        this.quantity = quantity;
    }

    String getPositive() {
        return positive == 1? "POZ": "NEG";
    }

    boolean makeOrder(int n) {
        if (quantity >= n){
            quantity -= n;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "\n" +
                getPositive() + "\n" +
                price + "\n" +
                quantity;
    }
}


class LekIme {
    String name;

    public LekIme(String name){
        this.name = name.toUpperCase();
    }

    @Override
    public int hashCode() {
        return (29 * (29 * (name.charAt(0)) + name.charAt(1))+ name.charAt(2)) % 102780;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        LekIme other = (LekIme) obj;

        if (name == null){
            return other.name == null;
        }else{
            return name.equals(other.name);
        }
    }
}


public class Apteka {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<LekIme, Lek> table = new HashMap<>();

        int N = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < N; ++i){

            String line = scan.nextLine();
            String[] parts = line.split("\\s+");

            Lek lek = new Lek(parts[0], Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));

            LekIme lekIme = new LekIme(parts[0]);

            table.put(lekIme, lek);
        }

        while (true) {

            String name = scan.nextLine();

            if (name.equals("KRAJ")){
                break;
            }

            int number = Integer.parseInt(scan.nextLine());
            LekIme lekIme = new LekIme(name);

            if (table.containsKey(lekIme)) {

                Lek lek = table.get(lekIme);
                System.out.println(lek);

                if (lek.makeOrder(number)){
                    System.out.println("Napravena naracka");
                }else{
                    System.out.println("Nema dovolno lekovi");
                }
            }
            else{
                System.out.println("Nema takov lek");
            }
        }
    }
}