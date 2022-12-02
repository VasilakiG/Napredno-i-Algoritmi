import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Shapes1Test {


    public static void main(String[] args) throws IOException {
        ShapesApplication shapesApplication = new ShapesApplication();

        System.out.println("===READING SQUARES FROM INPUT STREAM===");
        System.out.println(shapesApplication.readCanvases(System.in));
        System.out.println("===PRINTING LARGEST CANVAS TO OUTPUT STREAM===");
        shapesApplication.printLargestCanvasTo(System.out);

    }
}
class Shape{
    private String id;
    private List<Integer> sizes;

    public Shape() {
        this.id = "";
        this.sizes = new ArrayList<>();
    }
    public Shape(List<Integer> sizes, String id){
        this.sizes = sizes;
        this.id = id;
    }

    public static Shape createShape(String line) {
        List<Integer> sum = new ArrayList<>();
        String[] parts = line.split("\\s+");
        String id = parts[0];
        for (int i=1;i<parts.length;i++){
            sum.add(Integer.parseInt(parts[i]));
        }
        return new Shape(sum,id);
    }

    public Shape sumShape(Shape other){
        List<Integer> allSum = new ArrayList<>();
        allSum.addAll(sizes);
        allSum.addAll(other.sizes);

        return new Shape(allSum,"");
    }

    public int largestPerimeter(){
        int L = 0;
        for(int i=0;i<sizes.size();i++){
            L += sizes.get(i) * 4;
        }
        return L;
    }

    @Override
    public String toString() {
        return id + " " + sizes.size() + " " + largestPerimeter();
    }
}

class ShapesApplication {
    List<Shape> shapes;

    public ShapesApplication() {
        shapes = new ArrayList<Shape>();
    }

    public int readCanvases(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        int count = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");


            for (int i = 0; i < parts.length; i++) {
                try {
                    int j = Integer.parseInt(parts[i]);
                    count++;
                } catch (NumberFormatException e) {

                }
            }
        }

        return count;
    }
//        List<String> count = br.lines()
//                .map(line -> String[]dataParts = line.split(" ");)
//                .
//                    for (String integer : dataParts){
//                        if (isInteger(integer)){
//                            return 1;
//                        }
//                    }


    public void printLargestCanvasTo(OutputStream output) {
        PrintWriter pw = new PrintWriter(output);

        Shape maxL = shapes.get(0);
        for (int i = 1; i <=shapes.size(); i++) {
            if (shapes.get(i).largestPerimeter() > maxL.largestPerimeter()) {
                maxL = shapes.get(i);
            }
        }
        System.out.println(maxL);

        pw.flush();
    }
}