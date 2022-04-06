public class Find_Max {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static int max(Node node) {

        if (node == null)
            return Integer.MIN_VALUE;
        else if (node.left == null && node.right == null)
            return node.data;

        return Math.max(Math.max(node.data, max(node.left)), max(node.right));

    }
}
