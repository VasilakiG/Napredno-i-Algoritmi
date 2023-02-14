import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> namesByAppearance = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            map.putIfAbsent(parts[0], parts[1]);
        }

        List<String> keys =
                map.keySet()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

        for(String key: keys) {
            int count = (int) map.values()
                    .stream()
                    .filter( v -> v.equals(key))
                    .count();
            if(count>0){
                System.out.println(String.format("%s %d", key, count));
            }

        }


    }
}