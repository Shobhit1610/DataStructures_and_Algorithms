import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
    
      int result =0;
      int counter =0;
      return recur(n,b,0,0);
   }
   
   public static int recur(int n ,int b, int res,int cnt)
   {
       if(n==0) return res;
       
       res = res +(n%10)*(int)Math.pow(b,cnt);
       return recur(n/10,b,res,cnt+1);
   }
  }
