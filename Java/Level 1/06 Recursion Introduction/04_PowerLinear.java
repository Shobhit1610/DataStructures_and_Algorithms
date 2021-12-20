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

        return power(x,n-1)*x;

    }

}