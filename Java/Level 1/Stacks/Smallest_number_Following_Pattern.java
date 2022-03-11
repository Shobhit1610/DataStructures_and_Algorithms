import java.io.*;
import java.util.*;

public class Smallest_number_Following_Pattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> stk = new Stack<>();

        String res = "";
        int cnt=1;

        for(int i =0;i<str.length();i++)
        {
            char current = str.charAt(i);
            if(current == 'd')
            {
               stk.push(cnt++);     
            }
            else if(current == 'i')
            {
               stk.push(cnt++);
               while(!stk.isEmpty()) 
               {
                   res = res + stk.pop();
               }
            }
        }

        //In end we will pop everything (repeat everything for current ==i )
        stk.push(cnt++);
        while (!stk.isEmpty()) {
            res = res + stk.pop();
        }
        System.out.println(res);

    }

    
}