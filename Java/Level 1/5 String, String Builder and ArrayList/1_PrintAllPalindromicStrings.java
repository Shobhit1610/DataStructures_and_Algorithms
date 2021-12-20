import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        //Iterate for every substring
        String subString ="";
        for(int i=0;i<=input.length();i++)
        {
            for(int j=i+1;j<=input.length();j++)
            {
                subString = input.substring(i,j);
                if(checkIfPalindrome(subString))
                {
                    System.out.println(subString);
                }
            }
        }
    }

    public static boolean checkIfPalindrome(String x)
    {
        int l=0;
        int r=x.length()-1;
        while(l<r)
        {
            if(x.charAt(l++)!=x.charAt(r--))
            {
                return false;
            }
        }
        return true;
    }

}