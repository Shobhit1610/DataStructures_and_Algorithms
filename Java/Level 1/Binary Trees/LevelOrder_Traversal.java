import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrder_Traversal {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void levelOrder(Node node) {

        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();

        mainQ.add(node);

        while (!mainQ.isEmpty()) {
            childQ = new ArrayDeque<>();
            while (!mainQ.isEmpty()) {
                Node current = mainQ.remove();
                System.out.print(current.data + " ");
                if (current.left != null)
                    childQ.add(current.left);
                if (current.right != null)
                    childQ.add(current.right);
            }
            System.out.println();
            mainQ = childQ;
        }
    }

    public static void levelOrder2(Node node) {

        Queue<Node> mainQ = new ArrayDeque<>();
        // Queue<Node> childQ = new ArrayDeque<>();

        mainQ.add(node);

        while (!mainQ.isEmpty()) {
            // childQ = new ArrayDeque<>();
            int count = mainQ.size();
            while (count-- > 0) {
                Node current = mainQ.remove();
                System.out.print(current.data + " ");
                if (current.left != null)
                    // childQ.add(current.left);
                    mainQ.add(current.left);
                if (current.right != null)
                    // childQ.add(current.right);
                    mainQ.add(current.right);
            }
            System.out.println();
            // mainQ = childQ;
        }
    }

}
