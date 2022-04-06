import java.util.ArrayList;

public class Size_Of_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int size(Node node) {

        int res = 1;

        // Faith
        for (Node child : node.children) {
            res = res + size(child);
        }

        return res;
    }

}
