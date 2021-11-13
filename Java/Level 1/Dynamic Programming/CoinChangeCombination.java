/**
    Question Link : https://leetcode.com/problems/coin-change-2/

    Editorial Link : https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
 */
public class CoinChangeCombination
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++)
            input[i] = scanner.nextInt();
        int target = scanner.nextInt();

        int result =0;

        //DP Table
        int[][] dp = new int[input.length+1][target+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);

        //Recursion
        result = coinChangeCombination_Recur(input,target,0);

        //Memoisation
        result = coinChangeCombination_Mem(input,target,0,dp);
        
        //Tabulation
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],0);
        result = coinChangeCombination_Tab(input,target,dp);
        

        System.out.println(result);

    }

    //Recursion
    public static int coinChangeCombination_Recur(int[] input,int target,int treeLevel)
    {
        if(target==0) return 1;
        if(target<0 || treeLevel == input.length) return 0;

        //Here as to multiple times include one element , we will not increase tree level
        int yes = coinChangeCombination_Recur(input,target-input[treeLevel],treeLevel);
        int no = coinChangeCombination_Recur(input,target,treeLevel+1); 

        int value = yes + no;

        return value;
    }

    public static int coinChangeCombination_Mem(int[] input,int target,int index,int[][] dp)
    {
        if(target==0) return 1;
        if(target<0 || index == input.length) return 0;

        if(dp[index][dp[0].length-target] !=-1) return dp[index][dp[0].length-target];

        int yes = coinChangeCombination_Mem(input,target-input[index],index,dp);
        int no = coinChangeCombination_Mem(input,target,index+1,dp); 

        dp[index][dp[0].length-target] = yes + no;

        return dp[index][dp[0].length-target];
    }

    public static int coinChangeCombination_Tab(int[] input,int target,int[][] dp)
    {
        int rows = dp.length;
        int columns = dp[0].length;

        for(int i=0;i<columns;i++) dp[0][i]=0;
        for(int i=0;i<rows;i++) dp[i][0]=1;

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<columns;j++)
            {
                dp[i][j] += dp[i-1][j];
                if(j-input[input.length-i] >=0 )
                    dp[i][j]  += dp[i][j-input[input.length-i]];
            }
        }

        return dp[rows-1][target];
 
    }

}