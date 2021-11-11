public class ClimbStairsWithVariableJumps
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
            //input array gives the number of maximum moves starting from 1 
            //where i = levvel in recursion tree and number of maximum moves on that level is 1 to ar[i]
        int[] input = new int[n];
        for(int i=0;i<n;i++) input[i] = scanner.nextInt();

        //Initial Parameters
        int start = 0;
        int end = n;

        //Dp Table
        int[] dp = new int[end+1];
        Arrays.fill(dp,-1);

        //Memoisation
        int result = climbStairsWithVariableJumps_Mem(start,end,dp,input);  

        //Tabulation
        int result = climbStairsWithVariableJumps_Tab(start,end,dp,input);   

        System.out.println(result);
    }

    public static int climbStairsWithVariableJumps_Mem(int start,int end,int[] dp,int[] input)
    {
        //Positive base case
        if(start==end) return 1;

        //Negetive base case
        if(start>end) return 0 ;

        //Return if already present in table
        if(dp[start]!=-1) return dp[start];

        //Expectation : You have total path from 0 to n : f(0->n)
        //Faith : You have total paths from 1 to n - k to n : f(1->n) ... f(k->n)  
        //Meeting : f(0->n) = f(1->n) +...  f(k->n)

        int value = 0;
        for(int i=1;i<=input[start];i++)
            value += climbStairsWithVariableJumps_Mem(start+i,end,dp,input);

        //Storing value in table
        dp[start] = value;

        return dp[start];
    }

    public static int climbStairsWithVariableJumps_Tab(int start,int end,int[] dp,int[] input)
    {
        //Fixing the last value
        dp[end] = 1;

        for(int i=end-1;i>=0;i--)
        {
            dp[i]=0;
            for(int j=1;j<=input[i];j++)
            {
                if(i+j<=end) dp[i]+=dp[i+j];
            }
        }

        return dp[start];
    }
}