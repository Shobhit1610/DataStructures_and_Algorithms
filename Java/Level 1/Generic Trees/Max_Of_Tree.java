import java.util.ArrayList;

public class Max_Of_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int max(Node node) {
        int res = node.data;

        // Faith
        for (Node child : node.children) {
            res = Math.max(res, max(child));
        }

        return res;
    }

}
