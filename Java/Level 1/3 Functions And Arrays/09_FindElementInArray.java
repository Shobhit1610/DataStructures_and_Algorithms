import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] ar = new int[n];
    for(int i=0;i<n;i++)
        ar[i]=scanner.nextInt();
    int d = scanner.nextInt();
    
    System.out.println(linearSearch(ar,0,d));
 }
 
 public static int linearSearch(int[] ar,int l,int d)
 {
        if(l==ar.length) return -1;
        if(ar[l]==d)return l;
        return linearSearch(ar,l+1,d);
 }

}
