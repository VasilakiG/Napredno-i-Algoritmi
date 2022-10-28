package SLLNode;

import java.util.Scanner;

public class RunApp {

    static void pushZerosToEnd(int []arr, int n) {

        int foundNumber = 0;
        int notFound0 = 0;

        while( notFound0 < n){

            if(arr[notFound0] != 0){

                arr[foundNumber] = arr[notFound0];
                foundNumber++;
            }

            notFound0++;

        }

        while(foundNumber < n){

            arr[foundNumber] = 0;
            foundNumber++;

        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int []arr = new int[100];

        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }

        pushZerosToEnd(arr, n);

        System.out.println("Transformiranata niza e:");

        for(int i=0; i<n; i++){

            if( i < n-1 ){
                System.out.print(arr[i]+ " ");
            }else{
                System.out.print(arr[i]);
            }
        }
    }
}
