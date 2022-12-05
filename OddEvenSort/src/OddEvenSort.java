import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddEvenSort {

    static void oddEvenSort(int []a, int n) {
        // Vasiot kod tuka
        int [] even = new int[n];
        int [] odd  = new int[n];

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0 ){
                even[count1++] = a[i] * -1;
            }else{
                odd[count2++] = a[i];
            }
        }

        even = Arrays.stream(even).filter(num -> num != 0).sorted().toArray();
        odd = Arrays.stream(odd).filter(num -> num != 0).sorted().toArray();

        int length1 = even.length;
        int length2 = odd.length;

        for (int i = 0; i < length1; i++) {
            even[i] *= -1;
        }

        System.arraycopy(odd, 0,a ,0, length2);
        System.arraycopy(even, 0 ,a , length2, length1);
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}

//        Arrays.stream(odd).filter(num -> num != 0).sorted().forEach(System.out::println);

//        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(even));
//        list1.removeAll(Collections.singletonList(0));
//        even = list1.toArray(new Integer[0]);
//
//        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(odd));
//        list2.removeAll(Collections.singletonList(0));
//        odd = list2.toArray(new Integer[0]);