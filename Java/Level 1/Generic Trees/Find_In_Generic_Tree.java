import java.util.ArrayList;

public class Find_In_Generic_Tree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static boolean find(Node node, int data) {

        if (node.children.size() == 0) {
            if (node.data == data)
                return true;
            else
                return false;
        }

        boolean result = false;

        for (Node child : node.children) {
            result = result || find(child, data);
        }

        return result;
    }
}
