public class Height {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static int height(Node node) {

        if (node == null)
            return -1;
        else if (node.left == null && node.right == null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
