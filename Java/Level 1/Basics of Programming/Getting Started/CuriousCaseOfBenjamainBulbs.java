import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int a = scanner.nextInt();
      int b =scanner.nextInt();
      int c = scanner.nextInt();
      
      
      //Have to create a<b<c
      int temp=0;
      if(a>b)
      {
          temp=a;
          a=b;
          b=temp;
      }
      if(b>c)
      {
          temp=b;
          b=c;
          c=temp;
      }
        
    
    if(a*a+b*b==c*c)System.out.println("true");
    else System.out.println("false");
    }
  }
