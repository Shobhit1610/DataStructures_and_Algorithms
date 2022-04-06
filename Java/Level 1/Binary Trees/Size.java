public class Size {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static int size(Node node) {

        if (node == null)
            return 0;
        else if (node.left == null && node.right == null)
            return 1;

        return 1 + size(node.left) + size(node.right);
    }
}
