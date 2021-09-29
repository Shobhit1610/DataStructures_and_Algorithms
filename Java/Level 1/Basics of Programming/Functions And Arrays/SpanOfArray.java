import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scanner  = new Scanner(System.in);
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int n = scanner.nextInt();
    int temp=0;
    while(n-- >0)
    {
        temp = scanner.nextInt();
        if(max<temp) max=temp;
        if(min>temp) min=temp;
    }
    System.out.println(max-min);
    
 }

}
