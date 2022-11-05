import java.util.Arrays;
import java.util.Scanner;

public class GreedyCoins {

    public static int minNumCoins(int[] coins, int sum) {
        //Vasiot kod ovde
        int arrayLength = coins.length;
        int numCoins = 0;

        Arrays.sort(coins);

        for (int i = arrayLength-1; i >= 0; i--) {
            while(sum >= coins[i]){
                sum -= coins[i];
                numCoins++;
            }
        }

        return numCoins;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String coinsStringLine = input.nextLine();
        String[] coinsString = coinsStringLine.split(" ");
        int[] coins = new int[coinsString.length];
        for(int i=0;i<coinsString.length;i++) {
            coins[i] = Integer.parseInt(coinsString[i]);
        }

        int sum = input.nextInt();

        System.out.println(minNumCoins(coins, sum));
    }
}