import java.util.Scanner;

public class InverseOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
 inverse(n);
    }

    public static void inverse(int n) {
        int result = 0;
        int index=1;
        while(n>0)
        {
            int lastDigit = n % 10;
            result += index * Math.pow(10, lastDigit - 1);
            n /= 10;
            index++;
        }
        
        System.out.println(result);
    }
}
