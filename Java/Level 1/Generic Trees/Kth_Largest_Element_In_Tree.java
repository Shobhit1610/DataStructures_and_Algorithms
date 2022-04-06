import java.util.ArrayList;

public class Kth_Largest_Element_In_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int kthLargest(Node node, int k) {

        int res = findMax(node);
        while (k-- > 0) {
            findFloor(node, res);
            res = floorVal;
        }

        return res;
    }

    static int floorVal = Integer.MAX_VALUE;

    public static void findFloor(Node node, int data) {

        if (node.data < data && node.data > floorVal) {
            floorVal = node.data;
        }

        for (Node child : node.children) {
            findFloor(child, data);
        }
    }

    public static int findMax(Node node) {

        if (node.children.isEmpty()) {
            return node.data;
        }
        int res = Integer.MIN_VALUE;
        for (Node child : node.children) {
            res = Math.max(res, findMax(child));
        }
        return res;
    }

}
