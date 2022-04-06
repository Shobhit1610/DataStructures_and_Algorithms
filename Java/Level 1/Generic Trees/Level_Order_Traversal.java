import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Level_Order_Traversal {

    public static void levelOrder(Node node) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.data + " ");
            for (Node child : current.children) {
                queue.add(child);
            }
        }
        System.out.print(".");

    }

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
}
