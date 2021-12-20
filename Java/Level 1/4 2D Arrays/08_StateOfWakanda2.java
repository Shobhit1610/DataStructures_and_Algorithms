import java.io.*;
import java.util.*;

public class Main {

       public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ar[i][j] = scanner.nextInt();
        scanner.close();
        // Printing Diagonal
        // 1.outer loop deides the starting postion of diagonal
        // 2.inner loop prints the diagonal from above starting point
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                System.out.println(ar[i][i + j]);
            }
        }
    }

}