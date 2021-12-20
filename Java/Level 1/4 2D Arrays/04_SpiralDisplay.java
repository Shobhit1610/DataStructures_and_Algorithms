import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ar[i][j] = scanner.nextInt();
        scanner.close();
        // System.out.println();
        int rowMin = 0;
        int rowMax = n - 1;
        int colMin = 0;
        int colMax = m - 1;
        int countOfElementsPrinted = 0;

        // If elemets printed is greater than n*m then terminate the program not only
        // loop

        while (countOfElementsPrinted < n * m) {
            // North to south
            for (int a = rowMin; a <= rowMax; a++) {
                System.out.println(ar[a][colMin]);
                countOfElementsPrinted++;
                if (countOfElementsPrinted >= n * m)
                    return;
            }

            // west to east
            for (int a = colMin + 1; a <= colMax - 1; a++) {
                System.out.println(ar[rowMax][a]);
                countOfElementsPrinted++;
                if (countOfElementsPrinted >= n * m)
                    return;
            }

            // south to north
            for (int a = rowMax; a >= rowMin; a--) {
                System.out.println(ar[a][colMax]);
                countOfElementsPrinted++;
                if (countOfElementsPrinted >= n * m)
                    return;
            }

            // east to west
            for (int a = colMax - 1; a >= colMin + 1; a--) {
                System.out.println(ar[rowMin][a]);
                countOfElementsPrinted++;
                if (countOfElementsPrinted >= n * m)
                    return;
            }

            rowMin++;
            rowMax--;
            colMax--;
            colMin++;
        }
    }


}