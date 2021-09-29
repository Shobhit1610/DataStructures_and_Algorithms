import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();

    int gcd = findGcd(num1, num2);
    int lcm = num1*num2/gcd;
    System.out.println(gcd);
    System.out.println(lcm);
  }

  public static int findGcd(int dividend, int divisor)
  {
    int rem = dividend % divisor;
    if (rem <= 0) return divisor;
    return findGcd(divisor, rem);
  }
}
