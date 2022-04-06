import java.util.ArrayList;

public class Predecessor_And_Successor {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // Just previous and just next in preorder manner
    static Node predecessor;
    static Node successor;

    // State can have three values
    // -1 if requred node is not yet seen ,
    // 0 when seen,
    // 1 after seen
    static int state = -1;

    // In this question we have to travel in preorder manner and during each
    // iteration we will change the value of predecessor and successor

    public static void predecessorAndSuccessor(Node node, int data) {

        if (node.data == data) {
            state = 0;
        } else if (state == -1) {
            predecessor = node;
        } else if (state == 0) {
            successor = node;
            state = 1;
        }

        for (Node child : node.children) {

            predecessorAndSuccessor(child, data);
        }

    }
}