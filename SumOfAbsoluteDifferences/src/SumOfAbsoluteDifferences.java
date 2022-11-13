import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int[] numbers, int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni

        int arrayLength = numbers.length;
        int result = 0;
        int [][] pairAbsoluteDifference = new int[N-1][N-1];
        int helper = 1;



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pairAbsoluteDifference[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = helper-1; j < i; j++) {
                if (pairAbsoluteDifference[j][helper-1] +
                        Math.abs (numbers[j] - numbers[i]) > result) {
                    result = pairAbsoluteDifference[j][helper-1] +
                            Math.abs (numbers[j] - numbers[i]);
                }
                if(helper < K && helper-1 >= 0){
                    pairAbsoluteDifference[i][helper-1] = result;
                    helper++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (pairAbsoluteDifference[i][K-1] > result ) {
                result = pairAbsoluteDifference[i][K-1];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}