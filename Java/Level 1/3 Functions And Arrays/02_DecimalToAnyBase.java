import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       
       int result = 0;
       int counter = 0;
       return recur(n,b,result,counter);
       
       
   }
   
   public static int recur (int n,int b,int res,int cnt){
       
       if(n==0) return res;
       
       res = res  + (n%b) * (int)Math.pow(10,cnt);
       return recur(n/b,b,res,cnt+1);
       
   }
   
   
  }
