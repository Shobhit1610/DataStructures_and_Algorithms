public class ClimbStairs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int start =0;
        int end = n;

        //DP Table
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        //Memoisation
        int result = climbStairs_Mem(start,end,dp);

        //Tabulation
        int result = climbStairs_Tab(start,end,dp);

        System.out.println(result);
    }

    public static int climbStairs_Mem(int start,int end,int[] dp)
    {
        //Positive Base Condition
        if(start == end) return 1;

        //Negetive Base Condition
        if(start>end) return 0;

        //EXTRA : Get Value from DP Table
        if(dp[start]!=-1) return dp[start];


        //Expectation : You have total paths from 0 -> 4
        //Faith : You have paths from 1->4, 2->4 , 3->4
        //Meeting : f(0 -> 4) = f(1 -> 4) + f(2 -> 4) + f(3 -> 4)
        
        int value=climbStairs_Mem(start+1,end,dp) + climbStairs_Mem(start+2,end,dp) + climbStairs_Mem(start+3,end,dp);

        //Store the value in dp table
        dp[start]=value;

        return dp[start];

    }

    //Tabulation
    //Step 1 : Every element stores the total path from that elements to end
    //Step 2 : As we know path in leaves first,so we will fill the table while going up in tree so direction of loop whill be from right to left
    //Step 3 : Filled the array
    public static int climbStairs_Tab(int start,int end,int[] dp)
    {
        dp[end] = 1;
        for(int i = dp.length-2;i>=0;i--)
        {
            dp[i]=0;
            if(i+1<=end) dp[i]+=dp[i+1];
            if(i+2<=end) dp[i]+=dp[i+2];
            if(i+3<=end) dp[i]+=dp[i+3];
        }

        return dp[start];
    } 
}