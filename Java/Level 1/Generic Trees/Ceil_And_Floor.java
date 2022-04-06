import java.util.ArrayList;

public class Ceil_And_Floor {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    // Here we dont have to find min on one side, we have to find floor in whole
    // data so state is not required
    // static int state = -1;

    public static void ceilAndFloor(Node node, int data) {

        if (node.data < data && floor < node.data)
            floor = node.data;
        if (node.data > data && ceil > node.data)
            ceil = node.data;

        for (Node child : node.children) {
            ceilAndFloor(child, data);
        }
    }
}
