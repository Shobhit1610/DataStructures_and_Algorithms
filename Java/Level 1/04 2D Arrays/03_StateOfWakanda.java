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

        for (int j = 0; j < m; j++) {
            if (j % 2 == 0)
                for (int i = 0; i < n; i++)
                    System.out.println(ar[i][j]);
            else
                for (int i = n - 1; i >= 0; i--)
                    System.out.println(ar[i][j]);

        }
        scanner.close();
    }

}