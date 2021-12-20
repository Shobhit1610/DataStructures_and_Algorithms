import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ar = new int[size];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            ar[i] = scanner.nextInt();
            if (max < ar[i])
                max = ar[i];
        }
        scanner.close();
        for (int i = 0; i < size; i++) {
            ar[i] = max - ar[i];
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < size; j++) {
                if (ar[j] > 0) {
                    ar[j]--;
                    System.out.print("	");
                } else {
                    System.out.print("*	");
                }
            }
            System.out.println();
        }
    }

}