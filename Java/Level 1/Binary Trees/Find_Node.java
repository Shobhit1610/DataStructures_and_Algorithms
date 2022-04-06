public class Find_Node {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static boolean find(Node node, int data) {

        if (node == null)
            return false;
        else if (node.data == data)
            return true;

        return find(node.left, data) || find(node.right, data);
    }
}
