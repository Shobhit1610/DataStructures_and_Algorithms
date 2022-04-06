import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Level_Order_Linewise_Constant_Space {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrderLinewise(Node node) {

        Node delimiter = new Node();
        delimiter.data = -1;
        delimiter.children = null;

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(delimiter);

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current.data == -1) {
                if (!q.isEmpty())
                    q.add(delimiter);
                System.out.println();
            } else {
                System.out.print(current.data + " ");

                for (Node child : current.children) {
                    q.add(child);
                }
            }
        }

    }

}
