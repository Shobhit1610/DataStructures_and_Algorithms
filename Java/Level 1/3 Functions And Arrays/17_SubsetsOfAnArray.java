import java.io.*;
import java.util.*;

public class Main{

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(ar[k] + "	");
                }
                System.out.println();
            }
        }
    }

}