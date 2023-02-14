import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Manufacturer {
    String name;
    int count = 0;
    int price = 0;

    Manufacturer(String name) {
        this.name = name;
        this.price = 0;
        this.count = 0;
    }

    public void setPrice(int pr) {
        price += pr;
    }

    public void setCount() {
        count++;
    }

    @Override
    public String toString() {
        return "Vkupno proizvedeno: " + count + " torti\n" +
                "Vkupna cena za site torti: " + price + " den.";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Map<String, Integer> countCakes = new HashMap<>();
//        Map<String, Integer> priceCakes = new HashMap<>();
        Map<String, Manufacturer> manufacturer = new HashMap<>();

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            manufacturer.putIfAbsent(parts[1], new Manufacturer(parts[1]));
            if(manufacturer.containsKey(parts[1])){
                manufacturer.get(parts[1]).setCount();
                manufacturer.get(parts[1]).setPrice(Integer.parseInt(parts[2]));
            }

//            countCakes.putIfAbsent(parts[1], 0);
//            priceCakes.putIfAbsent(parts[1], 0);
//
//            countCakes.computeIfPresent(parts[1], (k,v) -> ++v);
//            priceCakes.computeIfPresent(parts[1], (k,v) -> v += Integer.parseInt(parts[2]));
        }

        String man = sc.nextLine();
        if(manufacturer.containsKey(man)){
            System.out.println(manufacturer.get(man).toString());
        }

//        int numCakes = countCakes.get(manufacturer);
//        int price = priceCakes.get(manufacturer);
//
//        System.out.println("Vkupno proizvedeno: " + numCakes + " torti");
//        System.out.println("Vkupna cena za site torti: " + price + " den.");
    }
}