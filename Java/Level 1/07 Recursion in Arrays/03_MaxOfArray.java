import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=scanner.nextInt();
        scanner.close();

        System.out.println(maxOfArray(ar,0));
    }

    public static int maxOfArray(int[] arr, int idx){

        if(idx==arr.length) 
            return Integer.MIN_VALUE;

        int res = maxOfArray(arr,idx+1);
        return arr[idx] <= res ? res : arr[idx];
    }

}