public class Goldmine
{
    public static void main(String[] args)
    {
        //Input
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] goldmine = new int[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                goldmine[i][j] = scanner.nextInt();

        //Initial Parameters (Recursion in opposite direction)
        int sourceX = 0;
        int sourceY = 0;
        


        //DP Table
        int[][] dp = new int[rows][columns];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);

        //Memoisation
        //Here starting point is not fixed as can iterate over left wall
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<goldmine.length;i++)
        {
            result = goldmine_Mem(sourceX+i,sourceY,goldmine,dp);
            if(max<result) max = result;
        }
        result=max;
        
        //Tabulation
        result= goldmine_Tab(goldmine);

        System.out.println(result);
    }

    public static int goldmine_Mem(int sourceX, int sourceY, int[][] goldmine,int[][] dp)
    {
        int rows = goldmine.length;
        int columns = goldmine[0].length;

        //Negetive Base Case
        if(sourceX <0 || sourceX>=rows || sourceY>= columns ) return 0; 

        //Positive Base Case
        if(sourceY == goldmine[0].length-1) return goldmine[sourceX][sourceY];

        //Check in DP Table
        if(dp[sourceX][sourceY]!=-1) return dp[sourceX][sourceY];


        //Expectation : Have maximum count from the current node to last column
        //Faith : Already have maximum counts from the two next nodes to last column
        //Meeting : f(x,y) = (x,y) + min( f(x-1,y+1) , f(x,y+1) , f(x+1,y+1))

        int value = Math.max( goldmine_Mem(sourceX-1,sourceY+1,goldmine,dp) ,
                              Math.max(goldmine_Mem(sourceX,sourceY+1,goldmine,dp) ,
                                       goldmine_Mem(sourceX+1,sourceY+1,goldmine,dp) ));

        value+=goldmine[sourceX][sourceY];

        //Store in table
        dp[sourceX][sourceY]=value;    

        return dp[sourceX][sourceY];
    }

    public static int goldmine_Tab(int[][] goldmine)
    {
        int first =0;
        int second =0;
        int third =0;

        //By building logic ypu have to find all values in dp table from row --> 0 
        //and solving every coumn first
        for(int j=goldmine[0].length-2 ; j>=0 ; j--)
        {
            for(int i=0;i<goldmine.length;i++)
            {
                if(i-1 >=0)
                    first = goldmine[i-1][j+1];
                else
                    first = 0;

                second = goldmine[i][j+1];
                if(i+1 <goldmine.length) 
                    third = goldmine[i+1][j+1];
                else 
                    third = 0;
                    
                goldmine[i][j] += Math.max(first , Math.max(second,third));

                first=0;
                second=0;
                third =0;

                
            }
        }

        //Finding max in left wall
        int max =0;
        for(int i=0;i<goldmine.length;i++)
            if(max<goldmine[i][0]) 
                max = goldmine[i][0];

        return max;        
    }


}