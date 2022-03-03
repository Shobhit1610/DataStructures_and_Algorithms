import java.util.Scanner;
import java.util.Stack;

public class Sliding_Window_Maximum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar =new int[n];
        for(int i=0;i<n;i++)
            ar[i]=sc.nextInt();
        int k= sc.nextInt();
        sc.close();

        int[] index_nextGreaterElementInRight = nextGreaterElementInRight(ar);

        for(int i=0;i<=n-k;i++)
        {
            int index_startWindow = i;
            int index_endWindow = i+k-1;
            int index_previousMaximum = 0;

            if(index_previousMaximum < index_startWindow)
            {
                index_previousMaximum=index_startWindow;
            }
            while(index_nextGreaterElementInRight[index_previousMaximum]<= index_endWindow)
            {
                index_previousMaximum = index_nextGreaterElementInRight[index_previousMaximum];
            }
            System.out.println(ar[index_previousMaximum]);
        }


    }

    public static int[] nextGreaterElementInRight(int[] arr)
    {
        int[] result =new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for(int i=arr.length-1;i>=0;i--)
        {
            int current =arr[i];

            if(stk.isEmpty())
            {
                result[i]=arr.length;
                stk.push(i);
            }
            else if(arr[stk.peek()] <=current)
            {
                while(!stk.isEmpty() && arr[stk.peek()] <=current)
                    stk.pop();

                if(stk.isEmpty())
                {
                    result[i] = arr.length;
                    stk.push(i);
                }    
                else if(arr[stk.peek()] > current)
                {
                    result[i]=stk.peek();
                    stk.push(i);
                }
            }
            else if (arr[stk.peek()] > current) 
            {
                result[i] = stk.peek();
                stk.push(i);
            }
        }

        return result;
    }
}
