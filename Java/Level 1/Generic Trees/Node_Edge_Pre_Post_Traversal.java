import java.util.ArrayList;

public class Node_Edge_Pre_Post_Traversal {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void traversals(Node node) {

        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);

    }

}
