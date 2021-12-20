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

        int row = 0;
        int column = 0;
        int movingRight = 0;
        int movingDown = 1;
        int movingLeft = 2;
        int movingUp = 3;
        int direction = 0;

        while (row >= 0 && row < n && column >= 0 && column < m) {
            if (ar[row][column] == 1) {
                if (direction == movingRight) {
                    direction = movingDown;
                    row++;
                } else if (direction == movingDown) {
                    direction = movingLeft;
                    column--;
                } else if (direction == movingLeft) {
                    direction = movingUp;
                    row--;
                } else if (direction == movingUp) {
                    direction = movingRight;
                    column++;
                }

            } else {
                if (direction == movingRight) {
                    column++;
                } else if (direction == movingDown) {
                    row++;
                } else if (direction == movingLeft) {
                    column--;
                } else if (direction == movingUp) {
                    row--;
                }
            }

        }
        if (row < 0)
            row++;
        if (column < 0)
            column++;
        if (row == n)
            row--;
        if (column == m)
            column--;
        System.out.println(row);
        System.out.println(column);
    }


}