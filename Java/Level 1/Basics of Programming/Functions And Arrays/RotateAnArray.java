import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] ar, int k){
      
    k%=ar.length;
    if(k<0) k+=ar.length;
    // write your code here
    reverse(ar,0,ar.length-1-k);
    reverse(ar,ar.length-k,ar.length-1);
    reverse(ar,0,ar.length-1);
  }

public static void reverse(int[] ar,int l,int r)
{
    if(l>=r)return;
    
    int temp=ar[l];
    ar[l]=ar[r];
    ar[r]=temp;
    reverse(ar,l+1,r-1);
}
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}
