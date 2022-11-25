import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int PRICE = 100;
        int max = 0;
        int min = 0;

        if(M == 0){
            max = N*PRICE;
            min = max;
        } else if (M == 1) {
            max = N*PRICE + ((M-1)*PRICE);
            min = N*PRICE;
        } else if (N>M) {
            max = N*PRICE + (M-1)*PRICE;
            min = N*PRICE;
        }else{
            max = N*PRICE + ((M-1)*PRICE);
            min = N*PRICE + ((M-N)*PRICE);
        }

        System.out.println(min);
        System.out.println(max);
    }

}
