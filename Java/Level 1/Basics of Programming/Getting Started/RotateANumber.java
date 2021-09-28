   public class RotateANumber{
   
	public static void main (String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
	    int k = scanner.nextInt();

	    int digitsCount=0;
        int temp =n;
        while(temp>0)
        {
            digitsCount++;
            temp/=10;
        }

	    k=k%digitsCount;
	    if(k<0)k=digitsCount+k;
	   
	    
	    int rightPart = n%(int)Math.pow(10,k);
	    rightPart = rightPart *(int)Math.pow(10,digitsCount-k);
	    rightPart+=n/(int)Math.pow(10,k);

        System.out.println(rightPart);	    
	   // return rightPart;

	}
	
}
