import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
//        int currZigZagCount = 0;
//        int maxZigZagCount = 0;
//        int arrayLength = a.length;
//        boolean flag = true;
//
//        for (int i = 0; i < arrayLength; i++) {
//
//            if(currZigZagCount > maxZigZagCount){
//                maxZigZagCount = currZigZagCount;
//            }
//
//            if(flag){
//                flag = false;
//                continue;
//            }
//
//            if(a[i-1] * a[i] < 0 ){
//                currZigZagCount++;
//            }
//        }
//        if(currZigZagCount > maxZigZagCount){
//            maxZigZagCount = currZigZagCount;
//        }
//
//        int currZigZagCount = 0;
//        int maxZigZagCount = 0;
//        int arrayLength = a.length;
//
//        for (int i = 0; i < arrayLength; i++) {
//            if (currZigZagCount > maxZigZagCount){
//                maxZigZagCount = currZigZagCount;
//            }
//            for (int j = 2; j < arrayLength; j++) {
//                if(a[j]*a[i] >= 0 && a[j-1]*a[i] <= 0){
//                    currZigZagCount++;
//                    break;
//                }
//            }
//
//        }
//        if (currZigZagCount > maxZigZagCount){
//            maxZigZagCount = currZigZagCount;
//        }
//
//        return maxZigZagCount;

        int originalArrayLength = a.length;
        int tmpLength = 1;
        int maxTmpLength = 1;

        if(originalArrayLength == 1){
            if(a[0] != 0){
                return 1;
            }
        }

        for (int i = 1; i < originalArrayLength; i++) {

            if(a[i] > 0){

                if(a[i-1] < 0){
                    tmpLength++;
                }else{
                    tmpLength=1;
                }
            }

            if (a[i] < 0){

                if (a[i-1] > 0){
                    tmpLength++;
                }else{
                    tmpLength=1;
                }
            }

            if (tmpLength > maxTmpLength){
                maxTmpLength = tmpLength;
            }
        }
        return maxTmpLength;
//        if (maxTmpLength >= originalArrayLength){
//            return originalArrayLength;
//        }else{
//            return maxTmpLength;
//        }

    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
