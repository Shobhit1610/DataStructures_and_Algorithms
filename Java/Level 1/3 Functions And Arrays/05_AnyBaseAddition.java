import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       int carry =0;
       int result =0;
       int counter =0;
       
       return recur(b,n1,n2,carry,result,counter);
   }
   
   public static int recur(int base , int n1, int n2, int carry , int result,int counter)
   {
       if(n1==0 && n2==0)
       {
           return result + carry * (int)Math.pow(10,counter);
       }
       
        int partialSum = n1 %10 + n2 % 10 + carry ;
        return  recur(
                        base,
                        n1/10,
                        n2/10,
                        partialSum/base,
                        result+(partialSum%base)*(int)Math.pow(10,counter),
                        counter+1
        );
        
   }
   
  }
