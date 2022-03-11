import java.io.*;

public class Smallest_number_following_pattern_without_stack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // Stack<Integer> stk = new Stack<>();

        String res = "";
        int consecutveD = 0;
        int maxSoFar = 0;

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == 'd') {
                consecutveD++;
            } else if (current == 'i') {
                consecutveD++;

                for (int j = consecutveD; j > 0; j--) {
                    res = res + (maxSoFar + j);
                }

                maxSoFar = maxSoFar + consecutveD;
                consecutveD = 0;
            }
        }

        // IN ENd same functionality of i
        consecutveD++;

        for (int j = consecutveD; j > 0; j--) {
            res = res + (maxSoFar + j);
        }

        maxSoFar = maxSoFar + consecutveD;
        consecutveD = 0;

        System.out.println(res);

    }
}
