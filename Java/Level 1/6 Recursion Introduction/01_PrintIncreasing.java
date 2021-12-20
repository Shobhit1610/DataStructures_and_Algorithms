import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        printIncreasing(n);
    }

    public static void printIncreasing(int n){
        
        //Base Condition
        if(n<1) return;

        //Faith
        printIncreasing(n-1);
        //Meeting
        System.out.println(n);
    }

}