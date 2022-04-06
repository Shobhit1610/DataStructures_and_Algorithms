import java.util.ArrayList;

public class Node_With_Maximum_Sum_Subtree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int max = Integer.MIN_VALUE;
    static Node maxPos = null;

    public static int maximumSumOfSubtree(Node node) {

        int sum = node.data;

        if (node.children.isEmpty()) {
            if (max < sum) {
                max = sum;
                maxPos = node;
            }
            return sum;
        }

        for (Node child : node.children) {

            sum += maximumSumOfSubtree(child);
        }
        if (sum > max) {
            max = sum;
            maxPos = node;
        }

        return sum;

    }

}
