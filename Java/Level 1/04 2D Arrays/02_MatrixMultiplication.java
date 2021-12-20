import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Matrix M1
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int[][] matrix1 = new int[r1][c1];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1; j++)
                matrix1[i][j] = scanner.nextInt();

        // Input Matrix M1
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int[][] matrix2 = new int[r2][c2];
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                matrix2[i][j] = scanner.nextInt();

        // Matrix Multiplication
        // 1. Check if c1 == r2
        if (c1 == r2) {
            // 2. Make a result matrix of size[r1][c2]
            int[][] result = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    // 3. result[i][j] =
                    // m1[ i ][ 0 ] * m2[ 0 ][ j ] + m1[ i ][ 1 ] * m2[ 1 ][ j ] + m1[ i ][ 2 ] *
                    // m2[ 2 ][ j ]
                    // Here till 3 as c1 == r2 == 3

                    for (int k = 0; k < r2; k++)
                        result[i][j] += matrix1[i][k] * matrix2[k][j];

                }
            }

            // Display product matrix
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }else
            System.out.println("Invalid input");

        scanner.close();
    }

}