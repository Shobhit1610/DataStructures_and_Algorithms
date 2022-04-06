import java.util.ArrayList;
import java.util.Stack;

public class Construct_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {

        Stack<Node> stk = new Stack<>();
        Node root = null;

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            if (current == -1) {
                stk.pop();

            } else {

                Node newNode = new Node();
                newNode.data = current;

                if (stk.isEmpty()) {
                    // First node
                    root = newNode;
                } else {
                    Node parent = stk.peek();
                    parent.children.add(newNode);
                }
                stk.push(newNode);

            }
        }

        return root;
    }
}
