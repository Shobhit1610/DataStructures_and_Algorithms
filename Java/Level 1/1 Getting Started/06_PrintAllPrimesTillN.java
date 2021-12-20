import java.util.Scanner;

public class PrintAllPrimesTillN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = scanner.nextInt();
        int high = scanner.nextInt();

        printAllPrimesNumberInBetweenIncludingEnds(low, high);
        scanner.close();
    }

    public static void printAllPrimesNumberInBetweenIncludingEnds(int low, int high) {
        for (int i = low; i <= high; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1 || n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0)
                    return false;
            }
        }
        return true;

    }
}
