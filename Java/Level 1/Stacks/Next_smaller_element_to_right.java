import java.util.Stack;

public class Next_smaller_element_to_right {

    public static int[] solve(int[] arr) {
        
        int[] result = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for(int i= arr.length-1;i>=0;i--)
        {
            int current = arr[i];

            if(stk.isEmpty())
            {
                result[i]=-1;
                stk.push(current);
            }
            else if(stk.peek() < current)
            {
                result[i]=stk.peek();
                stk.push(current);
            }
            else if (stk.peek() >= current) 
            {
                while(!stk.isEmpty() && stk.peek() >= current)
                    stk.pop();

                if(stk.isEmpty())
                {
                    result[i] = -1;
                    stk.push(current);
                }
                else if (stk.peek() < current) {
                    result[i] = stk.peek();
                    stk.push(current);
                }
            }

        }

        return result;
    }
    
}
