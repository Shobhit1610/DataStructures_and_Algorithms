import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    
    for(int i=2;i*i<=n || n>1;i++)
    {
        while(n%i==0)
        {
            System.out.print(i+" ");
            n/=i;
        }
        
    }
 }
}
