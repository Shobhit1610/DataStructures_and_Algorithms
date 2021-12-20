import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ar[i][j] = scanner.nextInt();
        scanner.close();

        int min = 0, max = 0, positionOfMin = 0;
        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                // Find row minimum
                if (min > ar[i][j]) {
                    min = ar[i][j];
                    positionOfMin = j;
                }
            }
            // Check if its is max in column
            max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (ar[j][positionOfMin] > max) {
                    max = ar[j][positionOfMin];
                }
            }
            if (max == min) {
                System.out.println(max);
                return;
            }

        }
        System.out.println("Invalid input");
    }

}