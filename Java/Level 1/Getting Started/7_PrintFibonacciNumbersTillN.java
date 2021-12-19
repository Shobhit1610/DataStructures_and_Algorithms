import java.util.Scanner;

public class PrintFibonacciNumbersTillN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        printFibonacciNumbersTillN(n);
    }

    public static void printFibonacciNumbersTillN(int n) {

        // Starting numbers;
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);

        int cnt = 2;
        while (cnt++ < n) {
            int c = a + b;
            System.out.println(c);
            a = b;
            b = c;

        }
    }
}