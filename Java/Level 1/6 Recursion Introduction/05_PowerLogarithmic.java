import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(power(x,n));
    }

    public static int power(int x, int n){

        if(n==0)
            return 1;

         int result = power(x,n/2)*power(x,n/2);
         if(n%2!=0)
            result *= x;

         return result;   
    }

}