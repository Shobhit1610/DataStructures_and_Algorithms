import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     
     String[] res= recur(n,sourceBase,destBase,0,0);
     System.out.println(res[1]);
   } 
   
   
   public static String[] recur (int n , int sourceBase , int destBase , int result ,int counter)
   {
       
       if(n==0)
       {
           String[] res = new String[2];
           res[0] = Integer.toString(result);
           res[1] = "";
           
           return res;
       }
       
       String[] res = recur( n/10 , sourceBase , destBase , result + (n%10) * (int)Math.pow(sourceBase,counter) , counter +1  ) ;
       
       int num = Integer.parseInt(res[0]);
       
       if(num>0){
       res[0] = Integer.toString(num/destBase);
       res[1] = Integer.toString(num%destBase)+res[1];
       }
       
       return res;
       
   }
   
  }
