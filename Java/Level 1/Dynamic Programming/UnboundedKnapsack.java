public class UnboundedKnapsack
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] profits = new int[n];
        int[] weights = new int[n];
        for(int i=0;i<n;i++) profits[i]=scanner.nextInt();
        for(int i=0;i<n;i++) weights[i]=scanner.nextInt();
        int target = scanner.nextInt();

        //DP Table
        int[][] dp =new int[profits.length+1][target+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);

        //Memoisation
        int result = unboundedKnapsack_Mem(profits,weights,target,0,0,dp); 

        System.out.println(result);
    }

    public static int unboundedKnapsack_Mem(int[] profits,int[] weights,int target,int index,int profitGained,int[][] dp)
    {
        if(target == 0) return profits[index];
        if(target<0) return 0;
        if(index == weights.length) return 0;
        if(dp[index][target]!=-1) return dp[index][target];

        int value = Math.max(
                    unboundedKnapsack_Mem(profits,weights,target-weights[index],index,profitGained+profits[index],dp),
                    unboundedKnapsack_Mem(profits,weights,target,index+1,profitGained,dp)
                    );

        dp[index][target] = value;
        return value;            
    }
}