import java.util.Stack;

public class Celebrity_Problem {

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> stk = new Stack<>();

        // Push all people into Stack
        for (int i = 0; i < arr.length; i++) {
            stk.push(i);
        }

        // Pop two people A and B and check
            // If [A][B] == 0 means A doent know B so B cannot be celeb so push only A
            // If [A][B] == 1 means A know B so A cannot be celeb so push only B
        while (stk.size() > 1) {
            int a = stk.pop();
            int b = stk.pop();
            if (arr[a][b] == 0)
                stk.push(a);
            else
                stk.push(b);

        }

        // Only one entry left in stack but not final so check for its row and column 
        int celeb = stk.pop();

        // Have to check if last entry is actually a celeb
        for (int i = 0; i < arr.length; i++) {
            if (celeb != i && arr[i][celeb] == 0) {
                System.out.println("none");
                return;
            }

        }
        for (int i = 0; i < arr[0].length; i++) {
            if (celeb != i && arr[celeb][i] == 1) {
                System.out.println("none");
                return;
            }
        }
        System.out.println(celeb);

    }
}
