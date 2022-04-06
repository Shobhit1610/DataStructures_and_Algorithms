import java.util.ArrayList;

public class Display_Tree {

    class Node {
        int data;
        ArrayList<Node> chldren = new ArrayList<>();
    }

    public static void display(Node node) {

        // If root is null
        if (node == null)
            return;

        System.out.print(node.data + " -> ");
        for (Node child : node.chldren) {
            System.out.print(child.data + " , ");
        }
        System.out.println(".");
        System.out.println();

        for (Node child : node.chldren) {
            display(child);
        }

    }
}
