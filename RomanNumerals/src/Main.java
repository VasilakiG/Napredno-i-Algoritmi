import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IntStream.range(0, n)
                .forEach(x -> System.out.println(RomanConverter.toRoman(scanner.nextInt())));
        scanner.close();
    }
}


class RomanConverter {
    /**
     * Roman to decimal converter
     *
     * @param n number in decimal format
     * @return string representation of the number in Roman numeral
     */
    public static String toRoman(int n) {
        // your solution here
        String[] FirstDigit  = {"", "M", "MM", "MMM", "MV", "V", "VM", "VMM", "VMM", "MX"};
        String[] SecondDigit = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ThirdDigit  = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] FourthDigit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        System.out.print(FirstDigit[ n /1000 ] + SecondDigit[ n /100 %10 ] +
                ThirdDigit[ n /10 %10 ] + FourthDigit[ n %10 ] );
        return "";
    }

}
