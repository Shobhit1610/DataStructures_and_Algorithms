import java.util.ArrayList;

public class Node_To_Root_Path {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        ArrayList<Integer> res = new ArrayList<>();

        if (node == null) {
            return res;
        } else if (node.data == data) {
            res.add(node.data);
            return res;
        }

        ArrayList<Integer> left = nodeToRootPath(node.left, data);
        ArrayList<Integer> right = nodeToRootPath(node.right, data);

        if (!left.isEmpty()) {
            left.add(node.data);
            return left;
        }
        if (!right.isEmpty()) {
            right.add(node.data);
            return right;
        }
        return res;
    }

}
