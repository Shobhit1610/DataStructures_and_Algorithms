import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        scn.close();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {

        int sum = 0, i = 0;
        while (n2 > 0) {
            sum = addPartialProducts(sum, getProductWithLastDigit(b, n1, n2 % 10) * (int) Math.pow(10, i++), b);
            n2 /= 10;
        }
        return sum;
    }

    public static int addPartialProducts(int previousSum, int partialProduct, int base) {
        int carry = 0, sum = 0, i = 0;
        while (previousSum > 0 || partialProduct > 0 || carry != 0) {
            sum += (((previousSum % 10) + (partialProduct % 10) + carry) % base) * Math.pow(10, i++);
            carry = ((previousSum % 10) + (partialProduct % 10) + carry) / base;
            previousSum /= 10;
            partialProduct /= 10;
        }
        return sum;
    }

    public static int getProductWithLastDigit(int base, int n1, int n2) {
        int sum = 0, i = 0, carry = 0;
        while (n1 > 0 || carry != 0) {
            sum += (((n1 % 10) * n2 + carry) % base) * Math.pow(10, i++);
            carry = ((n1 % 10) * n2) / base;
            n1 /= 10;

        }
        return sum;
    }
}