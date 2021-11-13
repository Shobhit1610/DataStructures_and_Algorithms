public class TargetSumSubsets
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n;i++) input[i]=scanner.nextInt();
        int target = scanner.nextInt();

        boolean result = false;

        //Recursion
        result = targetSumSubset_Recur(input,target,0,0);

        //Memoisation
        int[][] dp = new int[input.length][target];
        // for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        result = targetSumSubset_Mem(input,target,0,0,dp);

        //Tabulation
        dp=new int[input.length+1][target+1];
        result = targetSumSubset_Tab(input,target,0,0,dp);

        System.out.println(result);
    }

    public static boolean targetSumSubset_Recur(int[] input,int target,int currentSum,int index)
    {
        //Positive Base Case
        if(currentSum==target) return true;

        //Negetive Base Case
        if(index == input.length && currentSum!=target) return false;

        //Pruning
        if(currentSum > target) return false;

        //Expectation : Have a result that will i get a subset by adding or removing the current number
        //Faith : ALready have result by adding or removing next number
        //Meeting : 

        boolean value = targetSumSubset_Recur(input,target,currentSum+input[index],index+1) ||
                        targetSumSubset_Recur(input,target,currentSum,index+1);

        return value;                
    }

    //Applying ANDHA Memoisation just to cut calls of recursion tree
    public static boolean targetSumSubset_Mem(int[] input,int target,int currentSum,int index,int[][] dp)
    {
        //Positive Base Case
        if(currentSum==target) return true;

        //Negetive Base Case
        if(index == input.length && currentSum!=target) return false;

        //Pruning
        if(currentSum > target) return false;

        if(dp[index][currentSum]!=0) return (dp[index][currentSum]!=0); 

        //Expectation : Have a result that will i get a subset by adding or removing the current number
        //Faith : ALready have result by adding or removing next number
        //Meeting : 

        boolean value = targetSumSubset_Mem(input,target,currentSum+input[index],index+1,dp) ||
                        targetSumSubset_Mem(input,target,currentSum,index+1,dp);

        dp[index][currentSum] = value?1:0;                

        return value;    
    }

    //Tabulation
    //Only way is to imagine table 
    //where every element of table is based on the two other previous entries of table

    //Here every ar[i][j] shows that is sum = j possible if we take elements from 0 to i in input array
    //So final answer will be in last bottom right cell
    public static boolean targetSumSubset_Tab(int[] input,int target,int currentSum,int index,int[][] dp)
    {
        //Initial Conditions
        for(int i=0;i<dp.length;i++) dp[i][0] = 1; 
        int yes =0;
        int no =0;

        //Looping over DP Table
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(j-input[i-1] >=0) yes = dp[i-1][j-input[i-1]];
                no = dp[i-1][j];

                if(yes ==1 || no ==1) dp[i][j] =1; 
            }
        }

        return dp[dp.length-1][dp[0].length-1] == 1 ? true :false;

    }

}