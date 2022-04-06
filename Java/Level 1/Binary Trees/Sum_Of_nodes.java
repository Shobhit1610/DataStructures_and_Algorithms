public class Sum_Of_nodes {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static int sum(Node node) {

        if (node == null)
            return 0;
        else if (node.left == null && node.right == null)
            return node.data;

        return node.data + sum(node.left) + sum(node.right);
    }
}