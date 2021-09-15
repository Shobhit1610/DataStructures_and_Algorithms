import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        reverse(n);
    }

    public static void reverse(int n) {
        while (n > 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }

}
