import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int n1 = scanner.nextInt();
    int[] ar1 = new int[n1];
    for(int i=0;i<n1;i++) ar1[i] = scanner.nextInt();
    int n2 = scanner.nextInt();
    int[] ar2 =new int[n2];
    for(int i=0;i<n2;i++) ar2[i] = scanner.nextInt();
    
    int[] temp = null;
    if(n1<n2)
    {
         temp  = new int[n2];
        for(int i = n2-n1;i<n2;i++)
        {
            temp[i]=ar1[i-n2+n1];
        }
        ar1=temp;
    }
    else
    {
        temp  = new int[n1];
        for(int i = n1-n2;i<n1;i++)
        {
            temp[i]=ar2[i-n1+n2];
        }
        ar2=temp;
    }
    
    int[] res =recur(ar1,ar2,new int[temp.length],temp.length-1,0);
    for(int i=0;i<res.length;i++)
        System.out.println(res[i]);
 }
 
 public static int[] recur(int[] ar1,int[] ar2,int[] result, int r,int carry)
 {
     if(r<0) return result;
     result[r]=(ar1[r]+ar2[r]+carry)%10;
     carry = (ar1[r]+ar2[r]+carry)/10;
     return recur(ar1,ar2,result,r-1,carry);
 }

}
