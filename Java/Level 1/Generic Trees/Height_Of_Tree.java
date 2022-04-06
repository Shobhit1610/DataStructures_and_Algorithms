import java.util.ArrayList;

public class Height_Of_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int height(Node node) {

        if (node.children.size() == 0)
            return 0;

        int res = 0;

        // Faith
        for (Node child : node.children) {
            res = Math.max(res, height(child));
        }

        res += 1;
        return res;

    }
}
