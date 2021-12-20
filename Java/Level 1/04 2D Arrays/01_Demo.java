import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ar[i][j] = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(ar[i][j] + " ");
            System.out.println();
        }
        scanner.close();
    }


}