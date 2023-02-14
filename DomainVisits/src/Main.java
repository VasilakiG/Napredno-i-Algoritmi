import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();

            String[] parts = line.split(" ");
            String site = parts[0];
            int visits = Integer.parseInt(parts[1]);


            String[] domains = site.split("\\.");

            for (int j = domains.length-1 ; j >= 0; j--) {
                if ( j == domains.length-1 ){
                    map.computeIfPresent(domains[j], (key,value) -> value += visits);
                    map.putIfAbsent(domains[j], visits);
                }else {
                    domains[j] = String.format("%s.%s", domains[j], domains[j+1]);
                    map.computeIfPresent(domains[j], (key,value) -> value += visits);
                    map.putIfAbsent(domains[j], visits);
                }
            }
        }

        for(String key: map.keySet()) {
            System.out.println(String.format("%s %s", key, map.get(key)));
        }
    }
}