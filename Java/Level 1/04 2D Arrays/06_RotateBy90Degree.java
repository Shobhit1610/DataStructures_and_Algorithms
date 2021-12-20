import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ar[i][j] = scanner.nextInt();
        scanner.close();

        // FInd transpose
        // Find mirror image of transpose keeping mirror at right edge of matrix

        // Transpose
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // swap(ar[i][j],ar[j][i]);
                temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }

        // mirror Image
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = ar[i][j];
                ar[i][j] = ar[i][n - 1 - j];
                ar[i][n - 1 - j] = temp;
            }
        }
        display(ar);
    }

    public static void swap(int x, int y) {

    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}