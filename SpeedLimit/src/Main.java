import java.util.*;

class Driver {
    String name;
    String time;

    public Driver(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        Map<String, String> licensePlateAndName = new HashMap<>();
        //Map<String, String> driversByTime = new TreeMap<>();

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            licensePlateAndName.put(parts[0], String.format("%s %s", parts[1], parts[2]));
        }

        int SPEED_LIMIT = Integer.parseInt(sc.nextLine());

        List<Driver> drivers = new ArrayList<>();
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        for (int i = 0; i < parts.length; i+=3) {
            String licensePlate = parts[i];
            int speed = Integer.parseInt(parts[i+1]);
            String time = parts[i+2];

            if(speed > SPEED_LIMIT) {
                //driversByTime.put(time, licensePlateAndName.get(licensePlate));
                Driver driver = new Driver(licensePlateAndName.get(licensePlate), time);
                drivers.add(driver);
            }
        }
        drivers
                .stream()
                .sorted(Comparator.comparing(Driver::getTime))
                .forEach(driver -> System.out.println(driver.toString()));


    }
}