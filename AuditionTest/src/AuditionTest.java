import java.util.*;
import java.util.stream.IntStream;

class Audition {

    Map<String, List<Participant>> participantsByCity = new HashMap<String, List<Participant>>();

    public void addParticipant(String city, String code, String name, int age) {
        participantsByCity.putIfAbsent(city, new ArrayList<Participant>());

        List<Participant> participantsList = participantsByCity.get(city);

        if (IntStream.range(0, participantsList.size())
                .noneMatch(i -> participantsList.get(i).getCode().equals(code))){
            participantsByCity.get(city).add(new Participant(code, name, age));
        }
    }

    public void listByCity(String city) {
        List<Participant> participantsList = participantsByCity.get(city);

        participantsList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}

class Participant implements Comparable<Participant> {

    private final String code;
    private final String name;
    private final int age;

    public Participant(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%3s %s %d", code, name, age);
    }

    @Override
    public int compareTo(Participant other) {
        int nameComparison = this.name.compareTo(other.getName());
        int ageComparison = Integer.compare(this.age, other.getAge());
        int codeComparison = this.code.compareTo(other.getCode());

        if (nameComparison == 0 && ageComparison == 0) {
            return codeComparison;
        }else if (nameComparison == 0){
            return ageComparison;
        }
        return nameComparison;
    }
}

public class AuditionTest {
    public static void main(String[] args) {
        Audition audition = new Audition();
        List<String> cities = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length > 1) {
                audition.addParticipant(parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]));
            } else {
                cities.add(line);
            }
        }
        for (String city : cities) {
            System.out.printf("+++++ %s +++++\n", city);
            audition.listByCity(city);
        }
        scanner.close();
    }
}