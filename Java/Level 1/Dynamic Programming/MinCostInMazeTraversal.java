public class MinCostInMazeTraversal
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] input = new int[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                input[i][j]=scanner.nextInt();

        //Initial Parameters
        int sourceX = 0;
        int sourceY = 0;
        int destinationX = rows-1;
        int destinationY = columns-1;    

        //DP Table
        int[][] dp = new int[rows+1][columns+1];
        for(int i=0;i<rows+1;i++)
            Arrays.fill(dp[i],-1);

        //Memoisation
        int result = minCostInMazeTraversal_Mem(sourceX,sourceY,destinationX,destinationY,dp,input);

        //Tabulation
        int result = minCostInMazeTraversal_Tab(sourceX,sourceY,destinationX,destinationY,dp,input);


        System.out.println(result);

    }

    public static int minCostInMazeTraversal_Mem(int sourceX,int sourceY,int destinationX,int destinationY,int[][] dp,int[][] input)
    {
        //Positive Base Case
        if(sourceX == destinationX && sourceY == destinationY) return input[destinationX][destinationX];
        
        //Negetive Base Case
        if(sourceX > destinationX || sourceY > destinationY) return Integer.MAX_VALUE;

        //Return if found in DP Table
        if(dp[sourceX][sourceY]!=-1) return dp[sourceX][sourceY];


        //Expectation : You got the cheapest path to destination cell
        //Faith: You have the cheapest paths to (i-1,j) and (i,j-1)
        //Meeting : cheapest  = input[desx][desy] + min ( (i-1,j) , (i,j-1) )
        int value = Math.min( minCostInMazeTraversal_Mem(sourceX+1,sourceY,destinationX,destinationY,dp,input),
                              minCostInMazeTraversal_Mem(sourceX,sourceY+1,destinationX,destinationY,dp,input)
                             );  


        //IMPORTANT : If value already contains +Infinity
        if(value != Integer.MAX_VALUE)
            dp[sourceX][sourceY] = value + input[sourceX][sourceY];    
        else
            dp[sourceX][sourceY] = value; 

        return dp[sourceX][sourceY];                  


        
    }

    public static int minCostInMazeTraversal_Tab(int sourceX,int sourceY,int destinationX,int destinationY,int[][] dp,int[][] input)
    {
        int rows = destinationX +1;
        int columns = destinationY +1;


        //Have to build logic on pen and paper on how to fill table such that every cell has minimum cost from source
        for(int i=1;i<rows;i++)
        {
            input[i][0] += input[i-1][0] ;
        }

        for(int i=1;i<columns;i++)
        {
            input[0][i] += input[0][i-1];
        }
            
        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<columns;j++)
            {
                input[i][j] += Math.min(input[i-1][j],input[i][j-1]);
            }
        }

        return input[rows-1][columns-1];
    }

}
