public class FibonacciDp{
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //DP Table with initial values as -1
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        //Memoisation
        int result = fibonacciDP_Mem(n,dp);

        //Tabulation
        int result = fibonacciDP_Tab(n,dp);
        
        System.out.println(result);

    }

    //Memoisation
    //1. Apply recursion 
    //2. Add two statements
    //  2.1 Check if value already present in table
    //  2.2 If not then calculate and store it in table 
    public static int fibonacciDP_Mem(int n, int[] dp)
    {
        //Base Condition
        if(n==0 || n==1) return n;

        //EXTRA Step : Check if already present in dp table
        if(dp[n] != -1) return dp[n]; 

        //Expectation : Find nth fibonacci number
        //Faith : Have (n-1)th and (n-2)th fib number
        //Meeting : f(n) = f(n-1)+f(n-2)
        int value = fibonacciDP_Mem(n-1,dp) + fibonacciDP_Mem(n-2,dp);

        //EXTRA STEP : Store this value in DP table and return the DP value
        dp[n] = value;

        return dp[n];

    }

    //Tabulation
    //1. Storage and Meaning : Dry run, fill the dp table and find the meaning of every element in array
    //2. Direction : Decide which direction does your loop goes, forward or backward
    //3. Travel and Solve 
    public static int fibonacciDP_Tab(int n,int[] dp)
    {
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}