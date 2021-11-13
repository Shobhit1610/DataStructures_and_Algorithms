public class ZeroOneKnapsack
{
    public static void main(String[] args)
    {
        //INPUT
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[2][n];
        //Value
        for(int i=0;i<n;i++) 
            input[0][i] = scanner.nextInt();
        //Weight    
        for(int i=0;i<n;i++) 
            input[1][i] = scanner.nextInt(); 
        int target = scanner.nextInt();

        int result=0;

        //DP Table
        int[][] dp = new int[input[0].length+1][target+1];
        for(int i=0;i<dp.length;i++) 
            Arrays.fill(dp[i],-1);

        //Memoisation    
        result=zeroOneKnapsack_Mem(input,target,0,0,dp,0);

        //Tabulation
        result=zeroOneKnapsack_Tab(input,target,dp);

        System.out.println(result);


    }

    public static int zeroOneKnapsack_Mem(int[][] input,int target,int currentSum,int index,int[][] dp,int profit)
    {
        //Positive Base case
        if(currentSum==target) return profit;

        //Negetive Base Case
        if(index==input[0].length) return 0;
        if(currentSum>target) return profit - input[0][index-1];

        //Return if found in table
        if(dp[index][currentSum]!=-1) return dp[index][currentSum];

        int newProfit = Math.max(
            zeroOneKnapsack_Mem(input,target,currentSum,index+1,dp,profit),
            zeroOneKnapsack_Mem(input,target,currentSum+input[1][index],index+1,dp,profit+input[0][index])
        );
        dp[index][currentSum] = newProfit;

        return dp[index][currentSum];

    }
    public static int zeroOneKnapsack_Tab(int[][] input,int target,int[][] dp)
    {
        
        int dpRows = dp.length;
        int dpColumns = dp[0].length;

        int[] profit = new int[input[0].length];
        int[] weight = new int[input[0].length];
        for(int i=0;i<input[0].length;i++) 
        {
             profit[i] = input[0][i];
             weight[i] = input[1][i];
        }
           

        for(int j=0;j<dpColumns;j++) 
            dp[0][j]=0;
        for(int i=0;i<dpRows;i++) 
            dp[i][0]=0;

        int yes =0;
        int no =0; 

        for(int i=1;i<dpRows;i++)
        {
            for(int j=1;j<dpColumns;j++)
            {
                no = dp[i-1][j];
                if(j-weight[i-1] >=0)
                    yes = dp[i-1][j-weight[i-1]] + profit[i-1];
                else 
                    yes=0;    

                dp[i][j] = Math.max(no,yes);
            }
        }

        return dp[profit.length][target];
    }
}