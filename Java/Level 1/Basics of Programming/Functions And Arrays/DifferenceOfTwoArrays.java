import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] ar1 = new int[n1];
        for (int i = 0; i < n1; i++)
            ar1[i] = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] ar2 = new int[n2];
        for (int i = 0; i < n2; i++)
            ar2[i] = scanner.nextInt();

        int[] res = recur(ar1, ar2,ar1.length-1,ar2.length-1 ,0);
        
        //To remove starting zeroes
        int index=-1;
        while(res[++index]==0);
            
        for (int i = index; i < res.length; i++)
                System.out.println(res[i]);
    }

    public static int[] recur(int[] ar1, int[] ar2, int x,int y, int borrow) {
        if (x < 0)
        {
            if(y>=0)
                ar2[y]=ar2[y]-borrow;
            return ar2;
        }
            
        
        ar2[y]=ar2[y]-ar1[x]-borrow;
        if(ar2[y]<0)
        {
            ar2[y]+=10;
            borrow=1;
        }
        else
            borrow=0;
        
        return recur(ar1, ar2,  x - 1,y-1 ,borrow);
    }
}
