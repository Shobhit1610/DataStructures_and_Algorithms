import java.util.Scanner;

public class CountDigitsInANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int cnt = countDigits(n);
        System.out.println(cnt);
    }

    public static int countDigits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

}
