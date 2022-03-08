import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Merge_Overlapping_Interval
{
    static class MyComp implements Comparator<int[]>
    {
        @Override
        public int compare(int[] o1, int[] o2) {

            return o1[0]-o2[0];
        }

    }
     public static void mergeOverlappingIntervals(int[][] arr) {
     
        Arrays.sort(arr,new MyComp());
        
        Stack<int[]> stk =new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            int[] current = arr[i]; 

            if(stk.isEmpty())
            {
                stk.push(current);
            }
            else if(stk.peek()[1]>=current[0] )
            {
                int[] top = stk.pop();
                if(top[1]<=current[1])
                    top[1] = current[1];
                stk.push(top);
            }
            else if(stk.peek()[1] < current[0])
            {
                stk.push(current);
            }
        }
        displayStack(stk);

    }

    public static void displayStack(Stack<int[]> stk)
    {
        if(stk.isEmpty())
            return;

        int[] top = stk.pop();
        displayStack(stk);
        System.out.println(top[0]+" "+top[1]);
    }
}