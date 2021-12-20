import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        pdi(n);
    }

    public static void pdi(int n){

        if(n<1) return;

        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }

}