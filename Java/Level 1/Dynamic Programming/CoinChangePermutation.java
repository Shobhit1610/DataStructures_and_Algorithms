/**
    Question Link : https://leetcode.com/problems/combination-sum-iv/

 */
public class CoinChangePermutation
{
    public static void main(String[] args)
    {
        //INPUT
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++)
            input[i]=scanner.nextInt();
        int target = scanner.nextInt();

        int result=0;

        //DP Table
        //As only one value is changing table dimension will be 1
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=0 ;

        //Recursion
        result = coinChangePermutation_Recur(input,target); 

        //Memoisation
        result = coinChangePermutation_Mem(input,target,dp);

        //Tabulation
        result = coinChangePermutation_Tab(input,target,dp);


        System.out.println(result);       

    }

    //Recursion
    public static int coinChangePermutation_Recur(int[] input,int target)
    {
        //Positive Base Case
        if(target==0) return 1;
        if(target<0) return 0;

        int result=0;
        for(int i=0;i<input.length;i++)
            result += coinChangePermutation_Recur(input,target-input[i]);

        return result; 
    }

    //Memoisation
    public static int coinChangePermutation_Mem(int[] input,int target,int[] dp)
    {
        //Positive Base Case
        if(target==0) return 1;

        //Negetive Base Case
        if(target<0) return 0;

        //Check in Table
        if(dp[target]!=-1) return dp[target];

        int result=0;
        for(int i=0;i<input.length;i++)
            result += coinChangePermutation_Mem(input,target-input[i],dp);

        dp[target]=result;    

        return result; 
    }

    //Tabulation
    public static int coinChangePermutation_Tab(int[] input,int target,int[] dp)
    {
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=0;
            for(int x =0;x<input.length;x++)
            {
                if(i-input[x]>=0) dp[i]+=dp[i-input[x]]; 
            }
        }

        return dp[target];
    }
}