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

        System.out.println(firstIndex(ar,0,x));
    }

    public static int firstIndex(int[] arr, int idx, int x){

        if(arr.length ==idx)
            return -1;
        if(arr[idx]==x)
            return idx;

        return firstIndex(arr,idx+1,x);    
            

    }

}