import java.util.Scanner;

public class IsANumberPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            if (checkPrime(n))
                System.out.println("prime");
            else
                System.out.println("not prime");

        }

        scanner.close();
    }

    public static boolean checkPrime(int n) {
        // 1.Check for numbers till root(n)
        // 2.Only check for odd factors

        // Checking divisibility by 2
        if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        // Checking divisibility for all odd numbers starting with 3
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
