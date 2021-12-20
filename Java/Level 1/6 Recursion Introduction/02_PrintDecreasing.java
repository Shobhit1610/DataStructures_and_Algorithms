import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n){
        
        if(n<1)
            return;

        System.out.println(n);
        printDecreasing(n-1);
    }
    
}