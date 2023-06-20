import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Discounts {

    private final List<Store> stores;

    public Discounts() {
        this.stores = new ArrayList<Store>();
    }

    public List<Store> getStores() {
        return stores;
    }

    public int readStores(InputStream in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String line;
        String[] parts;
        String storeName;
        List<String> rawPrices = new ArrayList<String>();
        int count = 0;

        while(( line = bufferedReader.readLine()) != null ){
            count++;
            parts = line.split("\\s+");

            storeName = parts[0];
            String[] finalParts = parts;
            IntStream.range(1, parts.length)
                    .forEach(i -> rawPrices.add(finalParts[i]));

            

        }

        return count;
    }

    public List<Store> byAverageDiscount() {
        return null;
    }

    public List<Store> byTotalDiscount() {
        return null;
    }
}
