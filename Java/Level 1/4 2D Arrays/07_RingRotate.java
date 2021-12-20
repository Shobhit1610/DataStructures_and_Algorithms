import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ar[i][j] = scanner.nextInt();
        int s = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();

        // Mark corners of ring with a,b,c,d having two coordinates
        int a1 = s - 1, a2 = s - 1;
        int b1 = s - 1, b2 = m - s;
        int c1 = n - s, c2 = s - 1;
        int d1 = n - s, d2 = m - s;

        // Extract the ring into 1 d array
        // Size of 1 d array = 2 * (size of one row + size of one column - 1 overlapping
        // element)
        // Size of one row = m-2(s-1)
        // Size of one column =n-2(s-1)
        // Size of ring after calculation = 2*(m+n-4s+2)
        int sizeOfRing = 2 * (m + n - 4 * s + 2);
        // System.out.println(sizeOfRing);
        int[] ringArray = new int[sizeOfRing];

        // Copy elements into ring array
        int cnt = 0;
        for (int j = s - 1; j <= m - s; j++) {
            ringArray[cnt++] = ar[s - 1][j];
        }
        for (int i = s; i <= n - s - 1; i++) {
            ringArray[cnt++] = ar[i][m - s];
        }
        for (int j = m - s; j >= s - 1; j--) {
            ringArray[cnt++] = ar[n - s][j];
        }
        for (int i = n - s - 1; i >= s; i--) {
            ringArray[cnt++] = ar[i][s - 1];
        }

        // Rotate the array r times anticlockwise
        // 1. Reverse whole array
        // 2. reverse n-k-1 and k parts
        rotate(ringArray, r);

        // Copy elements back into ring
        cnt = 0;
        for (int j = s - 1; j <= m - s; j++) {
            ar[s - 1][j] = ringArray[cnt++];
        }
        for (int i = s; i <= n - s - 1; i++) {
            ar[i][m - s] = ringArray[cnt++];
        }
        for (int j = m - s; j >= s - 1; j--) {
            ar[n - s][j] = ringArray[cnt++];
        }
        for (int i = n - s - 1; i >= s; i--) {
            ar[i][s - 1] = ringArray[cnt++];
        }

        //Display Matrix
        display(ar);
    }

    public static void rotate(int[] ar, int r) {
       //Adjust number of rotations to come inside size of array
        r%=ar.length;
        if(r<0)r+=ar.length;
        r%=ar.length;

        // Rotating anticlockwise
        reverse(ar, 0, r - 1);
        reverse(ar, r, ar.length - 1);
        reverse(ar, 0, ar.length - 1);
    }

    public static void reverse(int[] ar, int l, int r) {
        int temp = 0;
        while (l < r) {
            temp = ar[l];
            ar[l] = ar[r];
            ar[r] = temp;
            l++;
            r--;
        }
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