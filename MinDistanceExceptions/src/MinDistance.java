import java.util.Scanner;
import java.util.concurrent.ExecutionException;



public class MinDistance {

    public static float minimalDistance(float[][] points) throws Exception {
        //Vasiot kod ovde
        int arrayLength = points.length;
        if(arrayLength < 2){
            throw new Exception("N is lower than 2!");
        }
        double minDistance = 9999999999.99;

        double x1, y1, x2, y2;
        for (int i = 0; i < arrayLength; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            for (int j = 1; j < arrayLength; j++) {
                x2 = points [j][0];
                y2 = points [j][1];
                if( (y2!=y1 || x2!=x1) && Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) ) < minDistance ){
                    minDistance = Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );
                }
                else if( y2==y1 && x2==x1 ){
                    throw new Exception("There are two dots with the same position!");
                }
            }
        }

        return (float)minDistance;
    }

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        float[][] points = new float[N][2];

        for(int i=0;i<N;i++) {
            points[i][0] = input.nextFloat();
            points[i][1] = input.nextFloat();
        }

        try{
            System.out.printf("%.2f\n", minimalDistance(points));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}