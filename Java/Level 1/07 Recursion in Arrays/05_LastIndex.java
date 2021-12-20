import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
            ar[i]=scanner.nextInt();
        int x = scanner.nextInt();
        scanner.close();

        System.out.println(lastIndex(ar,ar.length-1,x));
    }

    public static int lastIndex(int[] arr, int idx, int x){

        if(idx<0)
            return -1;
        if(arr[idx]==x) 
            return idx;   

        return lastIndex(arr,idx-1,x);
    }

}