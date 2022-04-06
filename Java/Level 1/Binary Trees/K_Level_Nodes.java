public class K_Level_Nodes {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void printKLevelsDown(Node node, int k) {

        if (node == null) {
            return;
        } else if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }
}
