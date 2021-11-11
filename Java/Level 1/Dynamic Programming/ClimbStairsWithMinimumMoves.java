public class ClimbStairsWithMinimumMoves
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++) input[i]=scanner.nextInt();

        //Initial Parameters
        int start = 0;
        int end = n;

        //DP Table
        int[] dp = new int[end+1];
        Arrays.fill(dp,-1);

        //Memoisation
        int result =climbStairsWithMinimumMoves_Mem(start,end,dp,input);

        //Tabulation
        int result =climbStairsWithMinimumMoves_Tab(start,end,dp,input);

        System.out.println(result);

    }

    public static int climbStairsWithMinimumMoves_Mem(int start,int end,int[] dp,int[] input)
    {
        //Positive Base Case
        if(start == end) return 1;

        //Negetive Base Case
        if(start>end) return Integer.MAX_VALUE;

        //Return if found in DP table
        if(dp[start]!=-1) return dp[start]; 


        //Expectation : Have minimum moves to reach end
        //Faith : Have Have minimum moves to reach end from (1 to k)
        //Meeting : f(start) = 1 + min( f(1->end),... ,f(k->end) )

        int value =0;
        for(int i=0;i<input[start];i++)
        {
            value = Math.min(value,climbStairsWithMinimumMoves_Mem(start+i,end,dp,input));
        }

        //IMPORTANT : Remember +Infinity + 1 = -Infinity 
        //So have to check if value is till INFINITE or not

         if(value != Integer.MAX_VALUE)
            dp[start] = 1 + value;
        else     
            dp[start] = value;

        return dp[start];
    }

    public static int climbStairsWithMinimumMoves_Tab(int start,int end,int[] dp,int[] input)
    {
        dp[end]=0;
        for(int i=end-1;i>=0;i--)
        {
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<input[i];j++)
            {
                if(i+j<=end) 
                    dp[i]=Math.min(dp[i],dp[i+j]);
            }

            if(dp[i] != Integer.MAX_VALUE)
                dp[i]+=1;
        }

        return dp[start];
    
    }

}