import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeatherStationTest {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        int n = scanner.nextInt();
        scanner.nextLine();
        WeatherStation ws = new WeatherStation(n);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("=====")) {
                break;
            }
            String[] parts = line.split(" ");
            float temp = Float.parseFloat(parts[0]);
            float wind = Float.parseFloat(parts[1]);
            float hum = Float.parseFloat(parts[2]);
            float vis = Float.parseFloat(parts[3]);
            line = scanner.nextLine();
            Date date = df.parse(line);
            ws.addMeasurment(temp, wind, hum, vis, date);
        }
        String line = scanner.nextLine();
        Date from = df.parse(line);
        line = scanner.nextLine();
        Date to = df.parse(line);
        scanner.close();
        System.out.println(ws.total());
        try {
            ws.status(from, to);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
//todo
// 1. implementiraj konstruktor so argument broj na denovi = DONE
// 2. metod addMeasurement - dodavanje na podatoci za novo merenje = DONE
// 3. metod total - vkupen broj merenja = DONE
// 4. metod status - od do merenja pecatenje, sorted po datum vo rastecki =
//    redosled, na kraj prosecna temperatura(cim ima prosek, znaci stastics
//    se koriste)

// vashiot kod ovde
class WeatherStation{
    int days;
    TreeSet<Measurement> measurements;

    public WeatherStation(int days) {
        this.days = days;
        measurements = new TreeSet<Measurement>();
    }


    public void addMeasurment(float temp, float wind, float hum, float vis, Date date) {

        Measurement measure = new Measurement(temp, wind, hum, vis, date);

        if (!measurements.add(measure)){
            return;
        }

        Iterator<Measurement> it = measurements.iterator();

        while (it.hasNext()) {
            Measurement tmp = it.next();
            long time1 = tmp.date.getMonth() * 31 + tmp.date.getDate();
            long time2 = date.getMonth() * 31 + date.getDate();
            if (time2 - time1 >= days) {
                it.remove();
            }
        }
    }

    public int total(){
        return measurements.size();
    }


    public void status(Date from, Date to) {
        double sum = 0;
        int count = 0;

        for (Measurement measure : measurements){
            if (!(measure.date.before(from) || measure.date.after(to))) {
                long measureTime = measure.date.getHours() * 60 + measure.date.getMinutes();
                long fromTime = from.getHours() * 60 + from.getMinutes();
                long toTime = to.getHours() * 60 + to.getMinutes();

                if (measureTime >= fromTime || measureTime <= toTime) {
                    System.out.println(measure);

                    sum += measure.getTemperature();
                    count++;
                }
            }
        }

//        DoubleSummaryStatistics statistics = measurements.stream()
//                .mapToDouble(Measurement::getTemperature)
//                .summaryStatistics();
//
//        double averageTemp = statistics.getAverage();

        if (count == 0 ){
            throw new RuntimeException();
        }else{
            System.out.printf("Average temperature: %.2f", sum/count);
        }
    }
}

class Measurement implements Comparable<Measurement>{
    public float getTemperature() {
        return temperature;
    }

    float temperature;
    float wind;
    float humidity;
    float visibility;
    Date date;

    public Measurement(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }


    @Override
    public int compareTo(Measurement other) {
        long time1 = date.getTime()/1000;
        long time2 = other.date.getTime()/1000;
        if (Math.abs(time1-time2) < 150){
            return 0;
        }
        return date.compareTo(other.date);
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s", temperature, wind, humidity, visibility, df.format(date));
    }
}