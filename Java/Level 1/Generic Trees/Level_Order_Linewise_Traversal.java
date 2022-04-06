import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Level_Order_Linewise_Traversal {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrderLinewise(Node node) {

        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();
        mainQ.add(node);

        while (!mainQ.isEmpty()) {
            childQ = new ArrayDeque<>();
            while (!mainQ.isEmpty()) {
                Node current = mainQ.remove();
                System.out.print(current.data + " ");

                for (Node child : current.children) {
                    childQ.add(child);
                }
            }
            System.out.println();
            mainQ = childQ;
        }
    }

}
